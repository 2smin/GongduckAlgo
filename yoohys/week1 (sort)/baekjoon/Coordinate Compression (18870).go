package main

// bufio 모듈을 이용하여, 속도 조절
import (
	"bufio"
	"fmt"
	"os"
	"sort"
	"strconv"
	"strings"
)

func main() {
	scanner := bufio.NewScanner(os.Stdin)
	scanner.Scan()

	var length, _ = strconv.Atoi(scanner.Text())
	scanner.Scan()

	coordsArray := strings.Split(scanner.Text(), " ")
	coords := make([]int, length)
	for i := range coords {
		coords[i], _ = strconv.Atoi(coordsArray[i])
	}

	coordsClone := make([]int, length)
	copy(coordsClone, coords)
	sort.Ints(coordsClone)
	m := make(map[int]int)

	var idx = 0
	for i := 0; i < length; i++ {
		v, found := m[coordsClone[i]]
		if found {
			_ = v
		} else {
			m[coordsClone[i]] = idx
			idx++
		}
	}

	for i := 0; i < length; i++ {
		fmt.Printf("%d ", m[coords[i]])
	}
}
