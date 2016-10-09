module.exports={
before:function(browser)
{
	console.log('starting up');
},

'step 1': function(browser)
{
	browser
	 .url('http://www.google.com')
	 .waitForElementVisible('body',1000);
},
'step 2': function(browser)
{
	browser
	 .setValue('input[type=text]','oggy and the cockroaches');

},
'step 3': function(browser)
{
	browser
	 .click('button[name=btnG]')
	 .pause(1000);
},
'step 4':function(browser)
{
	browser
	 .assert.containsText('#main','oggy')
	 .end();
},
after:function(browser) {
	
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
//console.log(browser);
done();
}


};