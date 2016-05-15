package main

import "fmt"

func main() {
	var n int // number of rows
	fmt.Scanf("%d", &n)
	var adjList [100][]int // adjacency list -> graph, l0 = data, l1 = attributes
	//l1 will contain the depthLevel and parent
	for i := 0; i < n; i++ {
		var x, y int
		fmt.Scanf("%d %d", &x, &y)
		adjList[x] = append(adjList[x], y)
		adjList[y] = append(adjList[y], x)
	}

	//StartNode
	start := 1

	var currLevelVals []int
	var nextLevelVals []int
	level := 0

	currLevelVals = append(currLevelVals, start)
	var visited [100]int
	visited[start] = 1
	for i := 0; i < len(currLevelVals); i++ {
		// fmt.Println(currLevelVals[i])
		for j := range adjList[currLevelVals[i]] {
			currChild := adjList[currLevelVals[i]][j]
			if visited[currChild] == 0 { // add current child if not already added
				nextLevelVals = append(nextLevelVals, currChild)
				visited[currChild] = 1
			}
		}

		if i == len(currLevelVals)-1 { // End of current level, move on to next one
			fmt.Println(currLevelVals)
			currLevelVals = nextLevelVals
			level++
			i = -1
			var emptyLevel []int
			nextLevelVals = emptyLevel

		}
	}

}
