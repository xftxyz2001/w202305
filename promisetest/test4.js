const fs = require('fs');

new Promise((resolve, reject) => {
    fs.readFile('./test1.html', (err, data) => {
        if (err) reject(err);
        resolve(data);
    });
}).then(value => {
    return new Promise((resolve, reject) => {
        fs.readFile('./test2.html', (err, data) => {
            if (err) reject(err);
            resolve([value, data]);
        });
    });
}).then(value => {
    return new Promise((resolve, reject) => {
        fs.readFile('./test3.html', (err, data) => {
            if (err) reject(err);
            value.push(data);
            resolve(value);
        })
    });
}).then(value=>{
    console.log(value.toString());
});
