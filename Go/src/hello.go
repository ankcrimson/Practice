package main
import(
"fmt"
"runtime"
)

func main() {
	fmt.Println("Hello World from",runtime.GOOS)
}