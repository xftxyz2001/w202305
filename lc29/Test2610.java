import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test2610 {
    public List<List<Integer>> findMatrix(int[] nums) {
        // 记录每个数字出现的次数
        // int[] hash = new int[nums.length];
        int[] hash = new int[nums.length + 1];
        // 出现次数最多的数字出现的次数
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            // if (++hash[nums[i] - 1] > max) {
            // max = hash[nums[i] - 1];
            // }
            if (++hash[nums[i]] > max) {
                max = hash[nums[i]];
            }
        }

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < max; i++) {
            List<Integer> grp = new ArrayList<>();
            for (int j = 0; j < hash.length; j++) {
                if (hash[j] > 0) {
                    // grp.add(j + 1);
                    grp.add(j);
                    hash[j]--;
                }
            }
            res.add(grp);
        }

        return res;
    }

    // 简洁的题解
    public List<List<Integer>> findMatrix0(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Integer> cnts = new HashMap<>();
        for (int num : nums) {
            // num 第 idx + 1 次出现
            int idx = cnts.getOrDefault(num, 0);
            cnts.put(num, idx + 1);
            if (res.size() <= idx) {
                // 需要用新的列来装 num
                res.add(new ArrayList<>());
            }
            res.get(idx).add(num);
        }
        return res;
    }
}
