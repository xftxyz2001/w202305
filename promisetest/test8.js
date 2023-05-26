async function main() {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            resolve("Hello world");
        }, 1000);
    });
}

let result = main();
result
    .then((result) => {

    }).catch((err) => {

    });