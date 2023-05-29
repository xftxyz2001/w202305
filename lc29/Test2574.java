import java.util.Arrays;

/**
 * Test2574
 */
public class Test2574 {

    public int[] leftRightDifference1(int[] nums) {
        // 初始化左右两侧元素和
        int[] leftSum = new int[nums.length];
        int[] rightSum = new int[nums.length];

        for (int i = 1; i < nums.length; i++) {
            leftSum[i] = leftSum[i - 1] + nums[i - 1];
            rightSum[nums.length - i - 1] = rightSum[nums.length - i] + nums[nums.length - i];
        }

        int[] res = new int[nums.length];

        for (int i = 0; i < res.length; i++) {
            res[i] = Math.abs(leftSum[i] - rightSum[i]);
        }
        return res;
    }

    public int[] leftRightDifference(int[] nums) {
        // 求和
        int rsum = 0;
        for (int i = 0; i < nums.length; i++) {
            rsum += nums[i];
        }
        // 存放结果
        int[] res = new int[nums.length];

        int lsum = 0;
        for (int i = 0; i < nums.length; i++) {
            lsum += nums[i];
            res[i] = Math.abs(lsum - rsum);
            rsum -= nums[i];
        }

        return res;
    }

    public static void main(String[] args) {
        Test2574 test2574 = new Test2574();
        int[] leftRightDifference = test2574.leftRightDifference(new int[] { 10, 4, 8, 3 });
        System.out.println(Arrays.toString(leftRightDifference));
    }
}