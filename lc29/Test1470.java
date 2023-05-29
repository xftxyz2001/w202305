import java.util.Arrays;

/**
 * Test1470
 */
public class Test1470 {

    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[nums.length];
        int i = 0, j = n;
        for (int k = 0; k < res.length; k++) {
            res[k] = k % 2 == 0 ? nums[i++] : nums[j++];
        }
        return res;
    }

    public static void main(String[] args) {
        Test1470 test1470 = new Test1470();
        int[] shuffle = test1470.shuffle(new int[] { 2, 5, 1,
                                                     3, 4, 7 }, 3);
        System.out.println(Arrays.toString(shuffle));
    }
}