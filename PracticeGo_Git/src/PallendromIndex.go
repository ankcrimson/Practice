package main

import (
	"fmt"
)

func checkPallendromeWithoutJ(text string, ignore int, len int) bool {
	for i,j :=0,len-1; i < len/2 && j>len/2; i,j = i+1,j-1 {
		if(i==ignore) {
			i++;
		}
		if(j==ignore) {
			j--;
		}
		if(text[i]!=text[j]){
			return false;
		}
	}
	return true;
}

func main() {
	var t int
	fmt.Scanf("%d", &t)
	for i := 0; i < t; i++ {
	var text string;
	fmt.Scanf("%s",&text);
	len :=len(text);
	lenBy2 := len/2;
	//flag := true;
	ans :=-1;
	for j := 0; j < lenBy2; j++ {
		if(text[j]!=text[len-j-1]) {
	//		flag=false;
			if(text[j+1]==text[len-j-1] && checkPallendromeWithoutJ(text,j,len)){ //also check for pallendrom without this char
				ans=j;
			} else{
				ans=len-j-1;
			}
			break;
		}
	}
	fmt.Println(ans);
}
}

