package main

import "fmt"

func currNeededCalc(charCount [26]int) int {
	currNeeded := 0
	for j := 0; j < 26; j++ {
		if charCount[j] > 0 {
			currNeeded = j
			break
		}
	}
	return currNeeded
}

func findLexographicSmallest(buffer []byte, curr byte, need [26]int) ([]byte, [26]int) {
	var retString []byte
	var charCount [26]int
	for i := range buffer {
		charCount[buffer[i]-'a']++
	}

	pos := 0
	for i := 0; i < 26; i++ {
		if charCount[i] != 0 && i < int(curr-'a') && need[i] > 0 {
			//scan buffer for this character

			for j := pos; j < len(buffer); j++ {
				if byte(i+'a') == buffer[j] && need[i] > 0 {
					retString = append(retString, byte(i+'a'))
					need[i]--
					pos = j + 1
					//break
				}
			}

		}
	}
	fmt.Println("Buffer=", string(buffer), "Return=", string(retString), "curr=", string(curr))
	return retString, need
}

func main() {
	var inputStr string
	fmt.Scanf("%s", &inputStr)
	byteArray := []byte(inputStr)
	var charCount [26]int
	for i := range byteArray {
		charCount[byteArray[i]-'a']++
	}
	//charCount will contain how many are needed
	var needed [26]int

	for i := range charCount {
		needed[i] = charCount[i] / 2
	}
	fmt.Println(needed)
	//how many passed already
	var passed [26]int
	var buffer []byte
	ans := ""
	//scan from right
	for i := len(byteArray) - 1; i >= 0; i-- {
		//scan for smallest, if smallest needed found then add to ans, decrease need
		currentNeeded := currNeededCalc(needed)
		if currentNeeded == int(byteArray[i]-'a') {
			ans += string(byteArray[i])
			needed[currentNeeded]--
			var tmpBuffer []byte
			fmt.Println("buffer=", string(buffer), "added=", string(byteArray[i]))
			buffer = tmpBuffer
		} else {
			//if smallest not found, check for criticality,
			if needed[byteArray[i]-'a'] >= charCount[byteArray[i]-'a']-passed[byteArray[i]-'a'] {
				//get the buffer and find the minimum possible string based on needed
				var currBytes []byte
				currBytes, needed = findLexographicSmallest(buffer, byteArray[i], needed)
				ans += string(currBytes)

				var tmpBuffer []byte
				buffer = tmpBuffer

				if needed[byteArray[i]-'a'] >= charCount[byteArray[i]-'a']-passed[byteArray[i]-'a'] {
					ans += string(byteArray[i])
				} else {
					buffer = append(buffer, byteArray[i])
				}

			} else {
				buffer = append(buffer, byteArray[i])
			}
			//if critical, scan buffer and get the smallest string before adding the first critical char

			// else add to passed and move on
		}
		passed[byteArray[i]-'a']++

	}
	fmt.Println(ans)
}
