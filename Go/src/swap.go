package main

import(
"fmt"
)

func swap(x *int, y *int) string{
 var c int
 c=*x
 *x=*y
 *y=c
 return "Done Swapping"
}

func main() {
	x :=3
	y:=4
	fmt.Println("Before Swapping",x,y)
	fmt.Println(swap(&x,&y),x,y)
}