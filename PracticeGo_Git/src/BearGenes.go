package main

import (
	"fmt"
)

func main() {
	var n, need int
	fmt.Scanf("%d", &n)
	var str string
	fmt.Scanf("%s", &str)
	var nums [4]int
	for i := 0; i < n; i++ {
		switch str[i] {
		case 'A':
			nums[0]++
			break
		case 'C':
			nums[1]++
			break
		case 'T':
			nums[2]++
			break
		case 'G':
			nums[3]++
			break
		}
	}
	need = n / 4
	for i := 0; i < 4; i++ {
		nums[i] = nums[i] - need
	}
	// short-circuit for all equal
	if nums[0] == nums[1] && nums[1] == nums[2] && nums[2] == nums[3] {
		fmt.Println(0)
		return
	}

	min := n
	// fmt.Println(nums)
	low := 0
	a := nums[0]
	c := nums[1]
	t := nums[2]
	g := nums[3]
	i := 0
	for i = 0; i < n; i++ {
		switch str[i] {
		case 'A':
			a--
			break
		case 'C':
			c--
			break
		case 'T':
			t--
			break
		case 'G':
			g--
			break
		}
		for a < 1 && c < 1 && t < 1 && g < 1 {
			switch str[low] {
			case 'A':
				a++
				break
			case 'C':
				c++
				break
			case 'T':
				t++
				break
			case 'G':
				g++
				break
			}
			if i-low < min {
				min = i - low
			}
			low++
		}
	}
	fmt.Println(min + 1)
}
