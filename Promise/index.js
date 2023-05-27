// function Promise() {
// }
// window.Promise = Promise;

// IIFE
(function () {
    function Promise(executor) {
        this.PromiseState = 'pending';
        this.PromiseResult = undefined;
        // let _this = this;

        // try {
        //     executor(function () {
        //         _this.PromiseState = 'fulfilled';
        //         return;
        //     }, function () {
        //         _this.PromiseState = 'rejected';
        //     }
        //     );
        // } catch (error) {
        //     // PromiseRejectionEvent(error);
        //     this.PromiseState = 'rejected';
        // }

        // try {
        //     executor(function (value) {
        //         // 成功
        //         this.PromiseState = 'fulfilled';
        //         this.PromiseResult = value;
        //     }.bind(this), function (value) {
        //         // 失败
        //         this.PromiseState = 'rejected';
        //         this.PromiseResult = value;
        //     }.bind(this)
        //     );
        // } catch (error) {
        //     // 异常
        //     this.PromiseState = 'rejected';
        //     if (typeof error === 'object') {
        //         this.PromiseResult = error.message;
        //     }else{
        //         this.PromiseResult = error;
        //     }
        // }

        // 定义resolve函数
        // const _resolve = function (value) {
        //     this.PromiseState = 'fulfilled';
        //     this.PromiseResult = value;
        // }.bind(this);
        const _resolve = value => {
            if (this.PromiseState !== 'pending') return;
            this.PromiseState = 'fulfilled';
            this.PromiseResult = value;
        }
        // 定义reject函数
        // const _reject = function (value) {
        //     this.PromiseState = 'rejected';
        //     this.PromiseResult = value;
        // }.bind(this);
        const _reject = value => {
            if (this.PromiseState !== 'pending') return;
            this.PromiseState = 'rejected';
            this.PromiseResult = value;
        }

        try {
            executor(_resolve, _reject);
        } catch (error) {
            // 异常
            this.PromiseState = 'rejected';
            // if (typeof error === 'object') {
            //     this.PromiseResult = error.message;
            // } else {
            //     this.PromiseResult = error;
            // }
            this.PromiseResult = typeof error === 'string' ? error : error.message;
        }
    }

    // Promise.prototype.PromiseState = {}
    // Promise.prototype.PromiseResult = {}

    // Promise.prototype.then = function () { }
    // Promise.prototype.catch = function () { }
    // Promise.prototype.finally = function () { }
    // Object.assign(Promise.prototype, {
    //     then(onfulfilled, onrejected) {
    //         return new Promise((resolve, reject) => {

    //             if (this.PromiseState === 'fulfilled') {
    //                 setTimeout(() => {
    //                     // let returnValue = onfulfilled(this.PromiseResult);
    //                     // if (returnValue instanceof Promise) {
    //                     //     return returnValue.then(resolve, reject);
    //                     // }else{
    //                     //     resolve(returnValue);
    //                     // }
    //                     const value = onfulfilled(this.PromiseResult);
    //                     if (value instanceof Promise) {
    //                         // value.then(v => {
    //                         //     resolve(v);
    //                         // }, r => {
    //                         //     reject(r);
    //                         // });
    //                         value.then(resolve, reject);
    //                     } else {
    //                         resolve(value);
    //                     }
    //                 });
    //             } else if (this.PromiseState == 'rejected') {
    //                 setTimeout(() => {
    //                     // onrejected(this.PromiseResult);
    //                     const value = onrejected(this.PromiseResult);
    //                     if (value instanceof Promise) {
    //                         value.then(resolve, reject);
    //                     } else {
    //                         resolve(value);
    //                     }

    //                 });
    //             }
    //         });

    //     }
    // });

    // Object.assign(Promise.prototype, {
    //     then(onfulfilled, onrejected) {
    //         return new Promise((resolve, reject) => {

    //             if (this.PromiseState === 'fulfilled') {
    //                 setTimeout(() => {
    //                     try {
    //                         const value = onfulfilled(this.PromiseResult);
    //                         if (value instanceof Promise) {
    //                             value.then(resolve, reject);
    //                         } else {
    //                             resolve(value);
    //                         }
    //                     } catch (error) {
    //                         reject(error);
    //                     }
    //                 });
    //             } else if (this.PromiseState == 'rejected') {
    //                 setTimeout(() => {
    //                     try {
    //                         const value = onrejected(this.PromiseResult);
    //                         if (value instanceof Promise) {
    //                             value.then(resolve, reject);
    //                         } else {
    //                             resolve(value);
    //                         }
    //                     } catch (error) {
    //                         reject(error);
    //                     }

    //                 });
    //             }
    //         });

    //     }
    // });
    Object.assign(Promise.prototype, {
        then(onfulfilled, onrejected) {

            // if (typeof onfulfilled !== 'function') { 
            //     onfulfilled = value => value;
            // }

            // if (typeof onrejected !== 'function') { 
            //     onrejected = reason => { throw reason };
            // }

            if (!(onfulfilled instanceof Function)) {
                onfulfilled = value => value;
            }

            if (!(onrejected instanceof Function)) {
                onrejected = reason => { throw reason };
            }

            return new Promise((resolve, reject) => {
                const _common = function (callback) {
                    setTimeout(() => {
                        try {
                            const value = callback(this.PromiseResult);
                            if (value instanceof Promise) {
                                value.then(resolve, reject);
                            } else {
                                resolve(value);
                            }
                        } catch (error) {
                            reject(error);
                        }
                    });
                }
                if (this.PromiseState === 'fulfilled') {
                    _common.call(this, onfulfilled);
                } else if (this.PromiseState == 'rejected') {
                    _common.call(this, onrejected);
                } else {
                    
                }
            });

        }
    });


    window.Promise = Promise;
})(window);
