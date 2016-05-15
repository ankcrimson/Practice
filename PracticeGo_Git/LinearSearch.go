package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
)

func main() {
	var v, n int
	fmt.Scanf("%d", &v)
	fmt.Scanf("%d", &n)
	scanner := bufio.NewScanner(os.Stdin)
	scanner.Split(bufio.ScanWords)
	for i := 0; i < n; i++ {
		if scanner.Scan() {
			val, _ := strconv.Atoi(scanner.Text())
			if val == v {
				fmt.Println(i)
			}
		}
	}
}
