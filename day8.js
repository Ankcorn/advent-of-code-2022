const fs = require("node:fs");

const dataset = fs
  .readFileSync("day8.txt")
  .toString()
  .split("\n")
  .map((el) => el.split("").map(Number));

function findTallerTree(dataset, tree, axis, direction, pos) {
  pos[axis] = pos[axis] + direction;
  const otherTree = dataset[pos.y][pos.x];

  if (otherTree >= tree) {
    return true;
  }
  if (pos[axis] === 0 || pos[axis] >= dataset.length -1) {
    return false;
  }
  return findTallerTree(dataset, tree, axis, direction, pos);
}


console.log(dataset);

const sides = [
  { axis: "y", direction: -1 },
  { axis: "x", direction: 1 },
  { axis: "y", direction: 1 },
  { axis: "x", direction: -1 },
];

let visibleTrees = (dataset.length -1)*4

console.log(visibleTrees);

for (let y in dataset) {
  for (let x in dataset[y]) {
    if (x > 0 && x < dataset.length -1 && y > 0 && y < dataset.length -1) {
      for (let settings of sides) {
        if (
          !findTallerTree(
            dataset,
            dataset[y][x],
            settings.axis,
            settings.direction,
            { x: Number(x), y: Number(y) }
          )
        ) {

          // console.log(
          //   dataset[y][x],
          //   settings.axis,
          //   settings.direction,
          //   { x: Number(x), y: Number(y) })
          visibleTrees++;
          break;
        }
      }
    }
  }
}

function viewingDistance(dataset, tree, axis, direction, pos, distance = 0) {
  distance++
  pos[axis] = pos[axis] + direction;
  const otherTree = dataset[pos.y][pos.x];

  if (otherTree >= tree) {
    return distance;
  }
  if (pos[axis] === 0 || pos[axis] >= dataset.length -1) {
    return distance;
  }
  return viewingDistance(dataset, tree, axis, direction, pos, distance);
}

let scores = [];
for (let y in dataset) {
  for (let x in dataset[y]) {
    if (x > 0 && x < dataset.length -1 && y > 0 && y < dataset.length -1) {
      let score = 1;
      for (let settings of sides) {
        const distance = viewingDistance(dataset,
          dataset[y][x],
          settings.axis,
          settings.direction,
          { x: Number(x), y: Number(y) })
          score = score* distance
      }
      scores.push(score)
      
    }
  }
}

console.log(scores.sort((a,b) => a-b)[scores.length -1]);
