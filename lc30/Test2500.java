package lc30;

import java.util.Arrays;

public class Test2500 {
    public int deleteGreatestValue(int[][] grid) {
        int res = 0;
        // 每行排序
        for (int i = 0; i < grid.length; i++) {
            Arrays.sort(grid[i]);
        }
        // 按列遍历
        for (int i = 0; i < grid[0].length; i++) {
            int max = -Integer.MIN_VALUE;
            for (int j = 0; j < grid.length; j++) {
                if (grid[j][i] > max) {
                    max = grid[j][i];
                }
            }
            res += max;
        }
        return res;
    }

}
