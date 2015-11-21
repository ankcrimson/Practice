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
 var db=conn.database('starwars');

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


 db.save(null, {
      name: 'Darth', force: 'Dark'
  }, function (err, res) {
    if(res)
    {
      var id=res.id;
      db.merge(id,{lname:'Vader'},function  (err,res) {});
    }
 });
  