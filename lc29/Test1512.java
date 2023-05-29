import java.util.HashMap;
import java.util.Map;

public class Test1512 {
    public int numIdenticalPairs(int[] nums) {
        // 记录每个数字出现的次数
        Map<Integer, Integer> hash = new HashMap<>();
        for (int i : nums) {
            hash.put(i, hash.getOrDefault(i, 0) + 1);
        }

        int res = 0;
        for (Integer values : hash.values()) {
            // 计算每个重复数字的组合数
            if (values >= 2) {
                res += values * (values - 1) / 2;
            }
        }
        return res;
    }

}
