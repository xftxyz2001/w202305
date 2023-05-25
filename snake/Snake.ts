class Snake {
    // 表示蛇头的元素
    head: HTMLElement;
    // 蛇的身体（包括蛇头）
    bodies: HTMLCollection;
    // 获取蛇的容器
    element: HTMLElement;

    constructor() {
        this.element = document.getElementById('snake')!;
        // const snake = document.getElementById('snake')!;
        // this.head = document.querySelector('#snake > div')!;
        this.head = document.querySelector('#snake')! as HTMLElement;
        // document.querySelectorAll('#snake > div');
        // this.bodies = document.getElementById('snake')!.getElementsByTagName('div');
        this.bodies = this.element.getElementsByTagName('div');
    }

    // 获取蛇的坐标（蛇头坐标）
    get X(): number {
        return this.head.offsetLeft;
    }

    get Y(): number {
        return this.head.offsetTop;
    }


    // 增加身体的方法
    addBody(): void {
        // 向element中添加一个div
        // this.head.insertAdjacentHTML('afterend', '<div></div>');
        // beforeend: 在element结束标签之前添加
        this.element.insertAdjacentHTML('beforeend', '<div></div>');
    }

    // 添加一个蛇身体移动的方法
    moveBody(): void {
        /**
         * 将后边的身体设置为前边身体的位置
         * 举例子：
         *   第4节 = 第3节的位置
         *   第3节 = 第2节的位置
         *   第2节 = 蛇头的位置
         */
        // 遍历获取所有的身体
        for (let i = this.bodies.length - 1; i > 0; i--) {
            // 获取前边身体的位置
            let X = (this.bodies[i - 1] as HTMLElement).offsetLeft;
            let Y = (this.bodies[i - 1] as HTMLElement).offsetTop;

            // 将值设置到当前身体上
            (this.bodies[i] as HTMLElement).style.left = `${X}px`;
            (this.bodies[i] as HTMLElement).style.top = `${Y}px`;
        }
    }

    // 检查蛇头是否撞到身体的方法
    // checkHeadBody(): boolean {
    checkHeadBody(): void {
        // 获取所有的身体，检查其是否和蛇头的坐标发生重叠
        for (let i = 1; i < this.bodies.length; i++) {
            let bd = this.bodies[i] as HTMLElement;
            if (this.X === bd.offsetLeft && this.Y === bd.offsetTop) {
                // console.log('撞到自己了！');
                // 进入判断说明蛇头撞到了身体
                throw new Error('撞到自己了！');
                // return true;
            }
        }
        // 没有撞到自己
        // return false;
    }

    // 设置蛇头的坐标
    set X(value: number) {
        // 如果新值和旧值相同，则直接返回不再修改
        if (this.X === value) {
            return;
        }
        // X的值的合法范围0-290之间
        if (value < 0 || value > 290) {
            // 进入判断说明蛇撞墙了
            throw new Error('蛇撞墙了！');
        }
        if (this.bodies[1] && (this.bodies[1] as HTMLElement).offsetLeft === value) {
            // console.log('水平方向发生了掉头');
            // 如果发生了掉头，让蛇向反方向继续移动
            if (value > this.X) {
                // 如果新值value大于旧值X，则说明蛇在向右走，此时发生掉头，应该使蛇继续向左走
                value = this.X - 10;
            } else {
                value = this.X + 10;
            }
        }
        this.moveBody();
        this.head.style.left = `${value}px`;

        this.checkHeadBody();
    }

    set Y(value: number) {
        // 如果新值和旧值相同，则直接返回不再修改
        if (this.Y === value) {
            return;
        }
        // Y的值的合法范围0-290之间
        if (value < 0 || value > 290) {
            // 进入判断说明蛇撞墙了
            throw new Error('蛇撞墙了！');
        }

        if (this.bodies[1] && (this.bodies[1] as HTMLElement).offsetTop === value) {
            // console.log('垂直方向发生了掉头');
            // 如果发生了掉头，让蛇向反方向继续移动
            if (value > this.Y) {
                // 如果新值value大于旧值Y，则说明蛇在向下走，此时发生掉头，应该使蛇继续向上走
                value = this.Y - 10;
            } else {
                value = this.Y + 10;
            }
        }

        this.moveBody();
        this.head.style.top = `${value}px`;

        this.checkHeadBody();
    }


}

export default Snake;