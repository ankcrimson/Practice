package main

import (
	"fmt"
)

func main() {
	var str string;
	fmt.Scanf("%s",&str);
	var arr [26]int;
	for i := 0; i < 26; i++ {
		arr[i]=0;
	}
	for i := 0; i < len(str); i++ {
		arr[str[i]-'a']++;
	}
	violations :=0;
	for i := 0; i < 26; i++ {
		if(arr[i]%2!=0){
			violations++;
		}
	}
	if(violations==0||len(str)%2==1&&violations==1){
		fmt.Println("YES");
	} else {
		fmt.Println("NO");
	}
	
}
