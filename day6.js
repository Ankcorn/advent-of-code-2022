const fs = require("node:fs/promises");

fs.readFile("day6.txt")
  .then((d) => d.toString())
  .then((data) => {
    data.split("").forEach((el, i, orig) => {
      const memory = orig.slice(i, i + 14);
      if (new Set(memory).size === 14) {
        console.log(i + 14);
        process.exit(0);
      }
    });
  });
