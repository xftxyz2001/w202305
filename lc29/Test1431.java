import java.util.ArrayList;
import java.util.List;

/**
 * Test1431
 */
public class Test1431 {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        // 找到最大值
        int max = Integer.MIN_VALUE;
        for (int i : candies) {
            if (i > max) {
                max = i;
            }
        }
        List<Boolean> res = new ArrayList<>();
        for (int i : candies) {
            // if (i + extraCandies >= max) {
            // res.add(true);
            // } else {

            // res.add(false);
            // }
            res.add(i + extraCandies >= max);
        }
        return res;
    }
}