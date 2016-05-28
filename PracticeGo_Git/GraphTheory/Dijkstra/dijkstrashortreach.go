package main

import "fmt"

// returns the minimum node and path
func findMinimum(paths [3001]int, visited [3001]int, n int) (int, int) {
	minN := -1
	minP := -1

	for i := 1; i <= n; i++ {
		//non visited non infinity
		if visited[i] == 0 && paths[i] != -1 {
			// either first non visited or a minimum one
			if paths[i] < minP || minP == -1 {
				minP = paths[i]
				minN = i
			}
		}
	}

	return minN, minP
}

func main() {
	var t int
	fmt.Scanf("%d\n", &t)
	for i := 0; i < t; i++ {
		var n, m int
		var adjList [3001][][2]int
		fmt.Scanf("%d %d\n", &n, &m)
		for j := 0; j < m; j++ {
			var x, y, r int
			fmt.Scanf("%d %d %d\n", &x, &y, &r)
			var n1, n2 [2]int
			n1[0] = y
			n1[1] = r
			n2[0] = x
			n2[1] = r
			adjList[x] = append(adjList[x], n1)
			adjList[y] = append(adjList[y], n2)
		}
		var start int
		fmt.Scanf("%d\n", &start)
		var visited [3001]int
		var paths [3001]int
		for j := 0; j < 3001; j++ {
			visited[j] = 0
			paths[j] = -1
		}
		paths[start] = 0
		// visited[start] = 1
		minN, minP := findMinimum(paths, visited, n)
		for minP != -1 {
			// fmt.Println("Min", minN, minP)
			for j := range adjList[minN] {
				// nodePath:=getPath(adjList[minN])
				// fmt.Println(paths[adjList[minN][j][0]], minP+adjList[minN][j][1])
				if paths[adjList[minN][j][0]] == -1 || paths[adjList[minN][j][0]] > minP+adjList[minN][j][1] {
					paths[adjList[minN][j][0]] = minP + adjList[minN][j][1]
					visited[adjList[minN][j][0]] = 0
				}
			}
			visited[minN] = 1
			minN, minP = findMinimum(paths, visited, n)
		}
		for j := 1; j <= n; j++ {
			if j != start {
				fmt.Print(paths[j], " ")
			}
		}
		fmt.Println()
	}
}
