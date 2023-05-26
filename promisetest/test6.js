
class A {
    a;
    b;
    constructor(a, b) {
        this.a = a;
        this.b = b;
    }
}

class B extends A {
    constructor(a) {
        super(a);
    }
}

let a = new B(1, 2);
console.log(a);
