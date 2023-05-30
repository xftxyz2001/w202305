package lc30;

public class TestLCP06 {
    public int minCount(int[] coins) {
        int res = 0;
        for (int coin : coins) {
            res += (coin + 1) >> 1;
        }

        return res;

    }
}
