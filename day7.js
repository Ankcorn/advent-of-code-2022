const fs = require("node:fs");

let dirs = {
  "/": 0,
};

const totalsize = 70000000;
const requiredSpace = 30000000;
console.log({ requiredSpace });
let currentDir = [];
fs.readFileSync("day7.txt")
  .toString()
  .split("\n")
  .forEach((line) => {
    if (line.startsWith("$")) {
      const input = line.substring(1).trim().split(" ");
      switch (input[0]) {
        case "cd":
          if (input[1] === "..") {
            currentDir.pop();
          } else {
            currentDir.push(input[1]);
          }
          break;
        case "ls":
          break;
        default:
          throw Error("I don't know this command");
      }
    } else {
      const output = line.split(" ");
      if (output[0] === "dir") {
        // console.log("creating dir ", currentDir.join(""));
        dirs[currentDir.join("") + output[1]] =
          dirs[currentDir.join("") + output[1]] || 0;
      } else {
        // console.log("adding to dir", currentDir.join(""), output[0]);
        Object.keys(dirs).filter((el) => {
          if (currentDir.join("").includes(el)) {
            dirs[el] += Number(output[0]);
          }
        });
      }
    }
  });

console.log(dirs);
// console.log(
//   Object.values(dirs)
//     .filter((a) => a < 100000)
//     .reduce((sum, el) => sum + el)
// );

console.log(totalsize - Object.values(dirs)[0]);
console.log(
  Object.values(dirs)
    .filter((a) => a >= requiredSpace - (totalsize - Object.values(dirs)[0]))
    .sort((a, b) => a - b)
);
