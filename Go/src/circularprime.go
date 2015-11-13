/*
Logic: 
Make a list of primes
Also store it in a string
loop through the list
circulate each element
check for presence in string of primes
if its not present, increase the count
*/
package main

import(
"fmt"
"math"
"strings"
"strconv"
)

func main() {
	ans:=0
	primes:=make([]int,0)
	primeStr:=""
	for i:=2;i<1000000;i++{
		found:=false
		for _,p:=range primes{
			if i%p==0{
				found=true
				break
			}
		}
		if !found{
			primes=append(primes,i)	
			primeStr+=" "+strconv.Itoa(i)
		}
	}
	primeStr+=" "
	

	for _,p:=range primes{
		x:=p
		ln:=len(strconv.Itoa(x))
		prime:=true
		for i := 1; i <= ln; i++ {
			y:=x%10
			x=x/10
			y=y*int(math.Pow(10,float64(ln-1)))
			x=x+y	
			if !strings.Contains(primeStr," "+strconv.Itoa(x)+" "){
			//	fmt.Println("Couldnt continue for %d as %d is not prime",p,x)
				prime=false
				break
			}
		}
		if prime{
			ans++
		}
	}
	fmt.Println("Answer is :",ans)
}