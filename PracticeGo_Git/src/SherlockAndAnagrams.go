package main

import "fmt"

func checkAnagram(str1 string, str2 string) bool {
	byteArray1 := []byte(str1)
	byteArray2 := []byte(str2)
	var charsA [26]int
	var charsB [26]int
	for i := range byteArray1 {
		charsA[byteArray1[i]-'a']++
		charsB[byteArray2[i]-'a']++
	}
	for i := 0; i < 26; i++ {
		if charsA[i] != charsB[i] {
			return false
		}
	}
	return true
}

func main() {
	var t int
	fmt.Scanf("%d", &t)
	for i := 0; i < t; i++ {
		var str string
		fmt.Scanf("%s", &str)
		l := len(str)
		count := 0               //length of string to check for substring
		for j := 1; j < l; j++ { //will check the chars of this length from 1 char strings to multi char strings
			for k := 0; k < l-j; k++ { //get the base string start
				str1 := str[k : k+j]
				for m := k + 1; m <= l-j; m++ {
					str2 := str[m : m+j]
					// fmt.Println("m", m, "str1=", str1, "<>str2=", str2)
					if checkAnagram(str1, str2) {
						// fmt.Println(str1, " - ", str2)
						count++
					}
				}
			}
		}
		fmt.Println(count)
	}
}
