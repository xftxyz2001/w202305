public class Offer64 {
    public int sumNums1(int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += i;
        }
        return sum;
    }
    
    public int sumNums2(int n) {
        return (1 + n) * n / 2;
    }

    // 没想出来
    // 下面是看的答案
    public int sumNums(int n) {
        boolean flag = n > 0 && (n += sumNums(n - 1)) > 0;
        return n;
    }
}
