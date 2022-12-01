package main

import (
	"fmt"
	"os"
	"sort"
	"strconv"
	"strings"
)

func check(e error) {
	if e != nil {
	    panic(e)
	}
  }

func main() {
	dat, err := os.ReadFile("./day1.txt")
	check(err)

	var eatinglist = string(dat)
      var max = 0
	var list []int
	for _, b :=range strings.Split(eatinglist, "\n\n") {
		var total int = 0
		for _, c := range strings.Split(b, "\n") {
			if len(c) > 0 {
				calories, err := strconv.Atoi(c)
				check(err)
				total = total + calories
			}
			
		}
		list = append(list, total)
		if total > max {
			max = total
		}
	}

	print("max: ", max, "\n")
	sort.Ints(list)

	var listTop3 = []int{list[len(list)-1], list[len(list)-2], list[len(list)-3]}
	fmt.Printf("top 3 %v\n", listTop3)

	var sumTop3 int
	for _, cals := range listTop3 {
		sumTop3 = sumTop3 + cals
	}

	print("sumTop3: ", sumTop3,  "\n")




}
