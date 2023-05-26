async function main() {
    console.log(1111);
    let result = await Promise.resolve('ok');
    console.log(result);
    console.log(2222);
    console.log(3333);
    console.log(4444);
    let result1 = await Promise.resolve('ok2');
    console.log(result1);
}

main();
console.log(5555);