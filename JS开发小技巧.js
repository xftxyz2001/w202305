// 替换字符串中匹配的第一个相同字符
let str = "Hello World";
str = str.replace("H", "haha ");
console.log(str);

// 替换所有相同的字符
let str2 = "Hello World";
str2 = str2.replace(/l/g, "L"); //正则
console.log(str2);
str2 = str2.replaceAll("L", "l"); //ES12
console.log(str2);

// 获取字符串中的某个字符
let char = str2.charAt(0);
console.log(char);

// 查找是否存在某个字符
// let index = str.indexOf("l");
console.log(str.includes("e", 1));

// 反转字符串
let str3 = "Hello World";
const stringReverse = (str) => str.split("").reverse().join("");
console.log(stringReverse(str3));

// 将数字字符串转换为Number类型
let num = "123";
// num = Number(num);
// num = num * 1;
num = +num;
console.log(num);

// 对小数优雅的取整
let num2 = 1.23456 | 0;
console.log(num2);

// 条件判断给字符变量赋值（短路评估）
let str4 = "";
// if (str4 !== null && str4 !== undefined && str4 !== "") {
//     let finalStr = str4;
// } else {
//     let finalStr = "Default String";
// }
// let finalStr = str4 ? str4 : "Default String";
let finalStr = str4 || "Default String";
console.log(finalStr);

// 条件判断增加对象属性
let isAdd = true;
let girlFriend = {
    name: "Lucyh",
    height: "175cm",
    age: 21,
    ...(isAdd && { work: "singer" }),
};
console.log(girlFriend);

// 检查某个属性是否存在对象中
console.log(!girlFriend.work); //?不在
console.log("work" in girlFriend); //?在
// girlFriend.hasOwnProperty("work");
// Object.keys(girlFriend).indexOf("work");

// 标准JSON
let k = {
    a: 1,
    b: {
        c: 2,
        d: 8,
    },
};

let n = JSON.parse(JSON.stringify(k));
n.b.c = 3;
console.log(k);
console.log(n);

// 快速遍历数组
let langs = ["Java", "Python", "JavaScript", "C++"];
for (const item of langs) {
    console.log(item);
}

// 统计一个数组中某个元素出现的次数
let = numbers = [1, 1, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
let numArr = numbers.reduce(function (a, b) {
    // a[b] = (a[b] || 0) + 1;
    if (b in a) {
        a[b]++;
    } else {
        a[b] = 1;
    }
    return a;
}, {});
console.log(numArr);

// 将对象的属性转化为数组
let obj = {
    name: "Lucy",
    age: 21,
    height: "175cm",
};

console.log(Object.keys(obj));

// 将对象属性和对应的值转化为数组
console.log(Object.entries(obj));

// 过滤数组中值为false的元素
const arr = [0, 1, false, 2, "", 3, null, undefined, NaN];
const filterArr = arr.filter(Boolean);
console.log(filterArr);

// 数组去重
const arr2 = [1, 2, 3, 4, 5, 6, 7, 8, 9, 1];
const unique = (arr) => [...new Set(arr)];
console.log(unique(arr2));

// 获取数组中随机项目
const randomItem = (arr) => arr[Math.floor(Math.random() * arr.length)];
console.log(randomItem(arr2));

// 获取数组中元素的最大值和最小值
const arr3 = [5, 6, 7, 8, 9, 1, 2, 3, 4];
// const max = Math.max(...arr3);
// const min = Math.min(...arr3);
// console.log(max, min);
// ?
const maxNum = (arr, n = 1) => [...arr].sort((a, b) => b - a).slice(0, n);
const minNum = (arr, n = 1) => [...arr].sort((a, b) => a - b).slice(0, n);
console.log(maxNum(arr3, 3));
console.log(minNum(arr3, 3));

// 快速实现一个指定长度的相同元素的数组
const arr4 = Array(5).fill(1);
console.log(arr4);

// 优化多个条件的if语句
let x = "kk";
// if (x === "kk" || x === "def" || x === "ghi" || x === "aa") {
//     console.log("x值不为空");
// }

if (["kk", "def", "ghi", "aa"].includes(x)) {
    console.log("x值不为空");
}

// 对两个数组取交集
let array1 = [1, 2, 3, 4, 5];
let array2 = [3, 4, 5, 6, 7];
let intersection = array1.filter((x) => array2.includes(x));
console.log(intersection);

// 检测数组中是否存在某个值，有删除，没有添加
let myNums = [1, 2, 3, 4, 5];
let proccessing = (num) => {
    if (myNums.includes(num)) {
        myNums.splice(myNums.indexOf(num), 1);
    } else {
        myNums.push(num);
    }
}
proccessing(3);
console.log(myNums);

