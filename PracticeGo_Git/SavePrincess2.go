package main

import "fmt"

func main() {
	var n int
	fmt.Scanf("%d\n", &n)
	var mr, mc, pr, pc int
	fmt.Scanf("%d %d\n", &mr, &mc)
	// outer:
	for i := 0; i < n; i++ {
		var line string
		fmt.Scanf("%s\n", &line)
		bytes := []byte(line)
		for j := 0; j < len(bytes); j++ {
			if bytes[j] == 'p' {
				pr = i
				pc = j
				break
			}
		}
	}
	// fmt.Println(mx, my, px, py)
	if pc < mc {
		fmt.Println("LEFT")
	} else if pc > mc {
		fmt.Println("RIGHT")
	} else if pr < mr {
		fmt.Println("UP")
	} else if pr > mr {
		fmt.Println("DOWN")
	}
}
