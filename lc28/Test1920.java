public class Test1920 {
    public int[] buildArray(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = nums[nums[i]];
        }
        return res;
    }
}
