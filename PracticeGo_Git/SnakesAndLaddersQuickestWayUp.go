package main

import "fmt"

func main() {
	var t int
	fmt.Scanf("%d\n", &t)
	for i := 0; i < t; i++ {
		var nSnakes, nLadders int
		var paths [101]int
		fmt.Scanf("%d\n", &nLadders)
		// fmt.Println(nLadders)
		for j := 0; j < nLadders; j++ {
			var start, end int
			fmt.Scanf("%d %d\n", &start, &end)
			paths[start] = end
		}
		fmt.Scanf("%d\n", &nSnakes)
		for j := 0; j < nSnakes; j++ {
			var start, end int
			fmt.Scanf("%d %d\n", &start, &end)
			paths[start] = end
		}
		//Till here, paths array has all the snakes and ladders config
		start := 1
		var currLocationsOnBoard []int
		var nextLocationsOnBoard []int
		moves := 0
		ans := -1
		currLocationsOnBoard = append(currLocationsOnBoard, start)
		var visited [101]int
		visited[start] = 1
		for j := 0; j < len(currLocationsOnBoard); j++ {
			if currLocationsOnBoard[j] == 100 {
				ans = moves
				break
			}
			for k := 1; k <= 6; k++ {
				nextLoc := currLocationsOnBoard[j] + k
				if nextLoc > 100 {
					break
				}
				if paths[nextLoc] != 0 {
					nextLoc = paths[nextLoc]
				}
				if visited[nextLoc] == 1 {
					continue
				}
				visited[nextLoc] = 1 // appending visited
				nextLocationsOnBoard = append(nextLocationsOnBoard, nextLoc)
			}
			if j == len(currLocationsOnBoard)-1 {
				// fmt.Println(currLocationsOnBoard)
				j = -1
				currLocationsOnBoard = nextLocationsOnBoard
				var empty []int
				nextLocationsOnBoard = empty
				moves++
			}
		}
		fmt.Println(ans)
	}
}
