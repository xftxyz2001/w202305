package lc30;

public class Test2520 {
    public int countDigits(int num) {
        int res = 0;
        int n = num;
        while (n > 0) {
            int d = n % 10; // 从右面取一位
            if (num % d == 0) {
                res++;
            }
            n /= 10; // 去掉最右面一位
        }
        return res;
    }

}
