package main

import "fmt"

func main() {
	var n, m int
	fmt.Scanf("%d %d\n", &n, &m)
	var adjList [3001][][2]int
	for i := 0; i < m; i++ {
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
	var selectedMap = make(map[int]int, 0)
	selectedMap[start] = 1
	var keys []int
	keys = append(keys, start)
	var ans int
	for len(keys) < n {
		minN := -1
		minP := -1
		//get all children of selected which are themselves not selected
		for i := range keys {
			childs := adjList[keys[i]]
			for j := range childs {
				if selectedMap[childs[j][0]] == 0 && (minP == -1 || minP > childs[j][1]) {
					minN = childs[j][0]
					minP = childs[j][1]
				}
			}
		}
		ans += minP
		keys = append(keys, minN)
		selectedMap[minN] = 1
	}
	fmt.Println(ans)
}
