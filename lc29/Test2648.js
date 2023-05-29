/**
 * @return {Generator<number>}
 */
var fibGenerator = function* () {
    // x = 0, y = 1;
    let x = 0, y = 1;
    // yield 0;
    // yield 1;
    while (true) {
        // yield y += x;
        // x = y - x;
        yield x;
        x += y;
        y = x - y;
    }

};

/**
 * const gen = fibGenerator();
 * gen.next().value; // 0
 * gen.next().value; // 1
 */

const gen = fibGenerator();
console.log(gen.next().value);
console.log(gen.next().value);
console.log(gen.next().value);
console.log(gen.next().value);
console.log(gen.next().value);
console.log(gen.next().value);