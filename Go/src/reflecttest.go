package main

import (
	"fmt"
	"reflect"
)
var(
	a string
	b float64
)

func main() {

a="Ankur"
b=3.14
	fmt.Println("Type of a is",reflect.TypeOf(a),"and Type of b is",reflect.TypeOf(b))
	fmt.Println(a,b)

}