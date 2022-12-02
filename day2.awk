BEGIN 	{ 
	part1 = 0  
	part2 = 0 
}{ 
			a = index("ABC", $1)
			b = index("XYZ", $2)
			res = (b-a % 3 + 3) % 3
			if(res == 1) {
				part1 += 6 + b
			} else if(res == 0) {
				part1 += 3 + b
			} else {
				part1 += b
			}

			if($2 == "X") {
				part2 += (a + 1) % 3 + 1
			}
			if($2 == "Y") {
				part2 +=3
				part2 += a
			}
			if($2 == "Z") {
				part2 += 6
				part2 += (a % 3) + 1
			}
		}
END   	{ printf "part1: %d part2: %d\n", part1, part2 }
