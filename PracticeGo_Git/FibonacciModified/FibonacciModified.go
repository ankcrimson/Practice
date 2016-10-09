package main

import (
	"fmt"
	"math/big"
)

func main() {
	//Enter your code here. Read input from STDIN. Print output to STDOUT
	var a, b big.Int
	var n int
	fmt.Scanf("%d %d %d", &a, &b, &n)
	for i := 0; i < n-2; i++ {
		var tmp big.Int
		tmp.Mul(&b, &b)
		tmp.Add(&tmp, &a)
		a = b
		b = tmp
	}
	fmt.Println(b)
}
