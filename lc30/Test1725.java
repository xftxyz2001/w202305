package lc30;

import java.util.HashMap;
import java.util.Map;

public class Test1725 {
    public int countGoodRectangles1(int[][] rectangles) {
        Map<Integer, Integer> hash = new HashMap<>();
        for (int[] is : rectangles) {
            int min = is[0] < is[1] ? is[0] : is[1];
            hash.put(min, hash.getOrDefault(min, 0) + 1);
        }

        return hash.get(hash.keySet().stream().max((a, b) -> a - b).get());
    }

    // 官方解答
    public int countGoodRectangles(int[][] rectangles) {
        int res = 0, maxLen = 0;
        for (int[] rectangle : rectangles) {
            int l = rectangle[0], w = rectangle[1];
            int k = Math.min(l, w);
            if (k == maxLen) {
                ++res;
            } else if (k > maxLen) {
                res = 1;
                maxLen = k;
            }
        }
        return res;
    }

}
