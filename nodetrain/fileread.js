var fs = require("fs");

fs.readFile("xml.xml", function  (err,data) {
console.log(data.toString());
});