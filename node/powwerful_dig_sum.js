var max=0;
for (var i = 0; i < 100; i++) {
	var tmp=1;
	for (var j = 0; j < 100; j++) {
		tmp *= i;
		var tmp_ans = calc_sum(tmp);
		if (tmp_ans > max) {
			max=tmp_ans;
		};
	};
};
console.log(max);

function calc_sum (num) {
	console.log(num);
	var ans=0;
	for (var i = 0; num >0 ; ) {
		ans += num%10;
		num=Math.floor(num/10);
	};
	return ans;
}