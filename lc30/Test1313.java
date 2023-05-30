package lc30;

import java.util.Arrays;

public class Test1313 {
    public int[] decompressRLElist(int[] nums) {
        // 确定结果长度
        int len = 0;
        for (int i = 0; i < nums.length; i += 2) {
            len += nums[i];
        }
        int[] res = new int[len];
        int k = 0;
        for (int i = 0; i < nums.length; i += 2) {
            // for (int j = 0; j < nums[i]; j++) {
            // res[k++] = nums[i + 1];
            // }
            Arrays.fill(res, k, k + nums[i], nums[i + 1]);
            k += nums[i];
        }
        return res;

    }

}
