package main

import (
	"fmt"
)

func main() {
	
	var t int;

	fmt.Scanf("%d",&t);

	outer: for j := 0; j < t; j++ {
	

	var str1,str2 string;
	fmt.Scanf("%s",&str1);
	fmt.Scanf("%s",&str2);
	
	var arr [26]bool;
	for i := 0; i < 26; i++ {
		arr[i]=false;
	}

	for i := 0; i < len(str1); i++ {
		arr[str1[i]-'a']=true;
	}

	for i := 0; i < len(str2); i++ {
		if arr[str2[i]-'a'] {
			fmt.Println("YES");
			//countine=ue outer
			continue outer;
		}
	}
	fmt.Println("NO");
	


	}
}
