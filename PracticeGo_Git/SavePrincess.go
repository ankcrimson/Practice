package main

import "fmt"

func main() {
	var n int
	fmt.Scanf("%d", &n)
	mx, my := 0, 0
	px, py := 0, 0
	for i := 0; i < n; i++ {
		var line string
		fmt.Scanf("%s", &line)
		bytes := []byte(line)
		for j := range bytes {
			if bytes[j] == 'm' {
				mx = j
				my = i
			}
			if bytes[j] == 'p' {
				px = j
				py = i
			}
		}
	}
	for i := 0; i < py-my; i++ {
		fmt.Println("DOWN")

	}
	for i := 0; i < my-py; i++ {
		fmt.Println("UP")

	}
	for i := 0; i < mx-px; i++ {
		fmt.Println("LEFT")

	}
	for i := 0; i < px-mx; i++ {
		fmt.Println("RIGHT")

	}
}
