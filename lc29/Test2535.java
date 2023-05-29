public class Test2535 {
    // 1 <= nums[i] <= 2000
    public int differenceOfSum(int[] nums) {
        int res = 0;
        for (int i : nums) {
            if (i < 10) {
                continue;
            }
            // res += i - sum(i);
            // res += i - (i % 10 + i / 10 % 10 + i / 100 % 10 + i / 1000 % 10);
            res += i - i % 10 - i / 10 % 10 - i / 100 % 10 - i / 1000 % 10;
        }
        // for (int i = 0; i < nums.length; i++) {
        // res += nums[i] - nums[i] % 10 - nums[i] / 10 % 10 - nums[i] / 100 % 10 -
        // nums[i] / 1000 % 10;
        // }

        return res;
    }

    // private int sum(int i) {
    // return i % 10 +
    // i / 10 % 10 +
    // i / 100 % 10 +
    // i / 1000 % 10;
    // }
}
