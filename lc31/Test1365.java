package lc31;

import java.util.Arrays;

public class Test1365 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        // 排序
        int[] newNums = nums.clone();
        Arrays.sort(newNums);

        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = Arrays.binarySearch(newNums, nums[i]);
            while (res[i] - 1 >= 0 && newNums[res[i]] == newNums[res[i] - 1]) {
                res[i]--;
            }
        }

        return res;
    }

}
