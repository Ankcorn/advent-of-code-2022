const fs = require("node:fs");

fs.readFileSync("day8.txt")
  .toString()
  .split("\n")
  .forEach((el, y) => {
    el.split("").forEach((el, x) => {
      console.log(el, x, y);
    });
  });
