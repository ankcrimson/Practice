var fs=require("fs");
var xml2js=require("xml2js");
function parse(filename) {
    var content=fs.readFileSync(filename);
	//console.log();

	var parseString = require('xml2js').parseString;
	
	var xml = content.toString();
console.log(xml);	
	var start=xml.indexOf("testsuites");
	var end=xml.indexOf("/testsuites");
	var s=xml.indexOf("tests=",start);
	var e=xml.indexOf("\"",s+7);
	console.log(">>>>>>>>>"+xml.substring(s,e));
	}
console.log(parse("xml.txt"));