// aahaxxxhxhxxah
package main

import "fmt"

//find minimum and return reduced buffer
func bufferOperations(buffer []byte) (byte, []byte) {
	var min byte
	pos := 0
	if len(buffer) > 0 {
		min = buffer[0]
	}
	for i := 1; i < len(buffer); i++ {
		if buffer[i] < min {
			min = buffer[i]
			pos = i
		}
	}
	return min, buffer[pos+1:]
}

func main() {
	var ans string
	var str string
	fmt.Scanf("%s", &str)
	var needed [26]int
	byteArray := []byte(str)
	for i := range byteArray {
		needed[byteArray[i]-'a']++
	}
	for i := 0; i < 26; i++ {
		needed[i] /= 2
	}

	var buffer []byte
	var passed [26]int
	fmt.Println(needed)

	//start parsing each char from right
	for i := len(byteArray) - 1; i >= 0; i-- {
		//loop over each char in chars counts from a-z
		curr := byteArray[i]
		passed[curr-'a']++
		var minumumCharNeeded byte
		for j := 0; j < 26; j++ {
			if needed[j] > 0 {
				minumumCharNeeded = byte('a' + j)
				break
			}
		}
		if curr == minumumCharNeeded {
			ans += string(curr)
			needed[curr-'a']--
			passed[curr-'a']--
			buffer = buffer[:0]
		} else if passed[curr-'a'] > needed[curr-'a'] {
			// fmt.Println(curr, buffer)
			for len(buffer) > 0 {
				var min byte
				min, buffer = bufferOperations(buffer)
				// fmt.Println(string(buffer), min)

				if needed[min-'a'] > 0 && min < curr {
					ans += string(min)
					needed[min-'a']--
					passed[min-'a']--
				}
			}
			buffer = buffer[:0]
			//process current character
			if needed[curr-'a'] > 0 {
				ans += string(curr)
				needed[curr-'a']--
				passed[curr-'a']--
			}
		} else {
			buffer = append(buffer, curr)
		}
	}
	fmt.Println(ans)
}
