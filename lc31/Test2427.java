package lc31;

public class Test2427 {
    public int commonFactors(int a, int b) {
        int ans = 1;
        int min = Math.min(a, b);
        for (int i = 2; i <= min; i++) {
            if (a % i == 0 && b % i == 0) {
                ans++;
            }
        }
        return ans;
    }

}
