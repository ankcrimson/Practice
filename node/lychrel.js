
var cnt=0;

function lychrel (num,callback) {
	var str=num.toString();

	for (var i = 0; i <= 50; i++) {
	var rev='';
	for(var j=str.length-1;j>=0;j--){
		rev+=str.charAt(j);
	}
	
	str=(Number(str)+Number(rev)).toString();

	var rev2='';
	for(var j=str.length-1;j>=0;j--){
		rev2+=str.charAt(j);
	}
	

	if(str===rev2)//check for equals as a result of last iteration
	{
		return;
	}
}	
cnt++;
}


for (var i = 2; i <= 10000; i++) {
	lychrel(i);
}
console.log(cnt);
