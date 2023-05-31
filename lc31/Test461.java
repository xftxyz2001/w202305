package lc31;

/**
 * Test461
 */
public class Test461 {

    public int hammingDistance(int x, int y) {
        // 找出不同
        int xor = x ^ y;

        int ans = 0;
        // 数1
        while (xor != 0) {
            ans++;
            xor &= xor - 1;
        }
        return ans;
    }
}