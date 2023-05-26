let p1 = new Promise((resolve, reject) => {
    setTimeout(() => {
        console.log('1');
        resolve('1');
    }, 1000);
});
let p2 = new Promise((resolve, reject) => {
    setTimeout(() => {
        console.log('2');
        resolve('2');
    }, 2000);
});
let p3 = new Promise((resolve, reject) => {
    setTimeout(() => {
        console.log('3');
        resolve('3');
    }, 3000);
});

Promise.any([p2, p1, p3]).then((result) => {
    console.log(result);
}).catch((err) => {
    
});
