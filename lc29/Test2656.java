public class Test2656 {
    public int maximizeSum(int[] nums, int k) {
        // 找到最大元素
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return (max + (max + k - 1)) * k / 2;

    }
}
