#!/bin/bash

awk '\

function winner(player1, player2)
{
      win = 6
	draw = 3
	loose = 0

     if(player1 == "A" && player2 == "X") {
	  return draw
     } else if (player1 == "B" && player2 == "Y") {
	  return draw
     } else if (player1 == "C" && player2 == "Z") {
	  return draw
     } else if (player1 == "A" && player2 == "Y") {
	  return win 
	} else if (player1 == "B" && player2 == "Z") {
	  return win 
	} else if (player1 == "C" && player2 == "X") {
	  return win 
	} else {
	  return loose
      }
}

function rig(player1, result) {
	 if(player1 == "A" && result == "X") {
		return "Z"
	 }
	 if(player1 == "A" && result == "Y") {
		return "X"
	 }
	 if(player1 == "A" && result == "Z") {
		return "Y"
	 }

	 if(player1 == "B" && result == "X") {
		return "X"
	 }
	 if(player1 == "B" && result == "Y") {
		return "Y"
	 }
	 if(player1 == "B" && result == "Z") {
		return "Z"
	 }

	 if(player1 == "C" && result == "X") {
		return "Y"
	 }
	 if(player1 == "C" && result == "Y") {
		return "Z"
	 }
	 if(player1 == "C" && result == "Z") {
		return "X"
	 }
}
function addOn(type) {
	if(type == "X") { 
		return 1
	}
	if(type == "Y") { 
		return 2
	}
	if(type == "Z") { 
		return 3
	}
}
BEGIN 	{ print "Lets Go" } \
		{ 
			round = winner($1, $2) + addOn($2)
			rigger = rig($1, $2)

			riggedResult = winner($1, rigger) + addOn(rigger)
		}	\
		{
			sum += round
			riggedSum += riggedResult
		} \
END   	{ printf "part1: %d part2: %d\n", sum, riggedSum } \
' day2.txt