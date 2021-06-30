package main

import (
	"bufio"
	"fmt"
	"math"
	"os"
	"sort"
	"strconv"
)

func main() {
	scanner := bufio.NewScanner(os.Stdin)
	scanner.Scan()

	var length, _ = strconv.Atoi(scanner.Text())
	numberArray := make([]int, length)
	sortArray := make([]int, length)

	for i := 0; i < length; i++ {
		scanner.Scan()
		numberArray[i], _ = strconv.Atoi(scanner.Text())
	}
	copy(sortArray, numberArray)
	sort.Ints(sortArray)

	var sum = 0
	var max = -4000
	var min = 4000

	for i := 0; i < length; i++ {
		sum += numberArray[i]
		if numberArray[i] > max {
			max = numberArray[i]
		}
		if numberArray[i] < min {
			min = numberArray[i]
		}
	}

	fmt.Println(math.Round(float64(sum) / float64(length)))
	fmt.Println(sortArray[length/2])
	fmt.Println(findMode(sortArray))
	fmt.Println(max - min)
}

func findMode(a []int) int {
	prevN := a[0]
	counter := 0

	modes := []int{prevN}
	maxCounter := 0

	for _, n := range a[1:] {
		if prevN != n {
			prevN = n
			counter = 0
		} else {
			counter++
		}

		if counter == maxCounter {
			if len(modes) < 2 {
				modes = append(modes, n)
			}
		} else if counter > maxCounter {
			maxCounter = counter
			modes = []int{n}
		}
	}

	if len(modes) > 1 {
		return modes[1]
	}
	return modes[0]
}
