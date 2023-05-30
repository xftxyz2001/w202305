package lc30;

public class Test1281 {
    public int subtractProductAndSum(int n) {
        int mul = 1;
        int sum = 0;
        while (n > 0) {
            mul *= n % 10;
            sum += n % 10;
            n /= 10;
        }
        return mul - sum;
    }
}
