package main

import (
	"fmt"
	"strconv"
)

func main() {
	var t int // number of rows
	fmt.Scanf("%d\n", &t)
	for i := 0; i < t; i++ {
		var n, m int
		fmt.Scanf("%d %d\n", &n, &m)
		// var nodes [1001]int
		var adjacencyList [1001][]int //adjacencyList
		for j := 0; j < m; j++ {
			var a, b int
			fmt.Scanf("%d %d\n", &a, &b) //edge between a and b
			adjacencyList[a] = append(adjacencyList[a], b)
			adjacencyList[b] = append(adjacencyList[b], a)
		}
		var start int
		fmt.Scanf("%d\n", &start) //Start position
		var currLevel, nextLevel []int
		var lenghts [1001]int
		//could be optimized
		for j := range lenghts { // initial locations with -1
			lenghts[j] = -1
		}
		lenghts[start] = 0
		currLevel = append(currLevel, start)
		level := 0
		for j := 0; j < len(currLevel); j++ {
			currentNode := currLevel[j]
			for k := range adjacencyList[currentNode] {
				// add them
				currentChild := adjacencyList[currentNode][k]
				if lenghts[currentChild] == -1 { //if node has not been visited till now, add it
					nextLevel = append(nextLevel, currentChild)
					lenghts[currentChild] = (level + 1) * 6
				}
			}

			if j == len(currLevel)-1 {
				j = -1
				fmt.Println("Curr Level: ", currLevel)
				currLevel = nextLevel
				var empty []int
				nextLevel = empty
				level++
			}
		}
		ans := ""
		for j := 1; j <= n; j++ {
			if j != start {
				ans = ans + strconv.Itoa(lenghts[j]) + " "
			}
		}
		fmt.Println(ans)
	}
}
