//prob 34
package main

import(
"fmt"
)

func main() {
	ans:=0
	fact:=make([]int,10)
	fact[0]=1
	for i:=1;i<10;i++ {
		fact[i] = fact[i-1]*i
	}


	for i:=3;i<100000000;i++{
		x:=i
		sum:=0
		for x>0{
			sum+=fact[x%10]
			x/=10
		}
		if i==sum{
			fmt.Println(i)
			ans+=i
		}
	}

	fmt.Println("Answer is : ",ans)
}