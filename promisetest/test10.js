const fs = require('fs');
const { promisify } = require('util');

async function main() {
    let myreadfile = promisify(fs.readFile); //以错误优先的回调函数为参数的函数转换为返回promise的函数
    try {
        let one = await myreadfile('./test1.html');
        let two = await myreadfile('./test2.html');
        let three = await myreadfile('./test3.html');
        console.log(one+two+three);
    } catch (error) {
        console.log(error);
    }
}

main();