package main

import (
"fmt"
"math"
"strconv"
)
func main() {
	x:=2103
	ln:=len(strconv.Itoa(x))
	fmt.Println(ln,",",x)
		for i := 1; i <= ln; i++ {
			y:=x%10
			x=x/10
			y=y*int(math.Pow(10,float64(ln-1)))
			x=x+y	
			fmt.Println(x)
		}
		
}