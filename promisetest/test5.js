const fs = require('fs');
// const util = require('util');
util.promisify
function ReadFileFun(path) {
    return new Promise((resolve, reject) => {
        fs.readFile(path, (err, data) => {
            if (err) {
                reject(err);
            } else {
                resolve(data);
            }
        });
    });
}

ReadFileFun('./test1.html').then((result) => {
    console.log(result.toString());
}).catch((err) => {
    console.log(err);
});
