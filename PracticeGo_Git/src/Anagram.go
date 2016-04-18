package main

import (
	"fmt"
)

func main() {
	var t int
	fmt.Scanf("%d", &t)
	for i := 0; i < t; i++ {
	var text string;
	fmt.Scanf("%s",&text);
	len :=len(text);
	if(len%2 == 0) {
	halfLen:=len/2;
	var arr1, arr2 [26]int;
	
	for j := 0; j < 26; j++ {
		arr1[j]=0;
		arr2[j]=0;
	}

	for j := 0; j < halfLen; j++ {
		arr1[text[j]-'a']++;
	}
	for j := halfLen; j < len; j++ {
		arr2[text[j]-'a']++;
	}
	var count int;
	for j := 0; j < 26; j++ {
		var diff int;
		if(arr1[j]-arr2[j]>0){
			diff=arr1[j]-arr2[j];
		} else{
			diff=arr2[j]-arr1[j];
		}
		count+=diff;
	}
	fmt.Println(count/2);
	} else{
		fmt.Println(-1);
	}
	}
}
