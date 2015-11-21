var cradle = require('cradle');
//create db connection
var conn =   new(cradle.Connection)('localhost', 5984, {
      cache: true,
      raw: false,
      forceSave: true,
      auth: {
        username:'admin',
        password:'admin'
      }
  });

//connect to db
 var db=conn.database('node_selenium_logs');

id=null;
time=Date.now();

module.exports={
before:function(browser)
{
	
	//check if exist or else create one db
    db.exists(function (err, exists) {
    if (err) {
      console.log('error', err);
    } else if (exists) {
      console.log('the force is with you.');
    } else {
      console.log('database does not exists.');
      db.create();
       //create views
      db.save('_design/nw', {
        log_id: {
          map: function (doc) {
              if (doc._id) emit(doc._id, doc);
          }
        },
      start_time: {
          map: function (doc) {
              if (doc.TestData.StartTime ) {
                  emit(doc.TestData.StartTime, doc);
              }
          }
        }
      });
    }
 });


	console.log('starting up');
},

'Step1: Open Google Page': function(browser)
{
	browser
	 .url('http://www.google.com')
	 .waitForElementVisible('body',1000);
},
'step2: Search for Oggy and Cockroaches': function(browser)
{
	browser
	 .setValue('input[type=text]','oggy and the cockroaches');

},
'step3: Click on Search Button': function(browser)
{
	browser
	 .click('button[name=btnG]')
	 .pause(1000);
},
'step4: Validate if page contains the keyword Oggy':function(browser)
{
	browser
	 .assert.containsText('#main','oggy')
	 .end();
},

after:function(browser) {
	console.log('ID of CouchDB record created:'+id);
	console.log('shutting down');
},

beforeEach:function(browser,done)
{
console.log('starting a test');
done();
},

afterEach:function(browser,done)
{
console.log('ended with a test');

var obj={};
obj[browser.currentTest.name]=browser.currentTest.results;

console.log(browser);

if(id) //if id exists then update
    {
    	obj['StartTime']=time;
    	obj['Platform']=browser.capabilities.platform;
        obj['Browser']=browser.capabilities.browserName;
        obj['BrowserVersion']=browser.capabilities.version;
    	db.merge(id,obj,function  (err,res) {
    	if(res)
    	console.log('logged into db Pass for '+browser.currentTest.name);	
    	
    	});
    }
else //if id does not exist then insert
{
      db.save(id, obj, function (err, res) {
       if(res)
       {
        id=res.id;
        //db.merge(id,{lname:'Vader'},function  (err,res) {});
    	console.log('logged into db Pass for '+browser.currentTest.name);
       }
       else
       {
    	console.log('Error inserting into db');
       }
       });
}
 console.log(browser.currentTest.name);
 done();
}
};