part1 = 0
part2 = 0

def findRangeOfAssignment(assignment) {
    start = assignment.split("-")[0] as Integer
    end = assignment.split("-")[1] as Integer
    return start..end as Range
}

new File("day4.txt").eachLine { line ->

    assignments = line.split(",")
    firstAssignment = findRangeOfAssignment(assignments[0])
    secondAssignment = findRangeOfAssignment(assignments[1])

    if(
        firstAssignment.contains(secondAssignment.from) && firstAssignment.contains(secondAssignment.to) ||
        secondAssignment.contains(firstAssignment.from) && secondAssignment.contains(firstAssignment.to)
    ) {
        part1 += 1
    }

     if(
        firstAssignment.contains(secondAssignment.from) || firstAssignment.contains(secondAssignment.to) ||
        secondAssignment.contains(firstAssignment.from) || secondAssignment.contains(firstAssignment.to)
    ) {
        part2 += 1
    }
    
}

println "part1: " + part1
println "part2: " + part2