package main

import (
	"os"
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
	for _, b :=range strings.Split(eatinglist, "\n\n") {
		var total int = 0
		for _, c := range strings.Split(b, "\n") {
			if len(c) > 0 {
				print(c)
				calories, err := strconv.Atoi(c)
				check(err)
				total = total + calories
			}
			
		}
		if total > max {
			max = total
		}
	}

	print("max: ", max, "\n")


}
