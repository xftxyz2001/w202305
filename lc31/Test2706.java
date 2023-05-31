package lc31;

import java.util.Arrays;

public class Test2706 {
    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        // 最便宜的两块巧克力
        int p = prices[0] + prices[1];
        // if (p > money) {
        // return money;
        // }
        // return money - p;
        return p > money ? money : money - p;
        // return Math.max(0, money - p);
    }

}
