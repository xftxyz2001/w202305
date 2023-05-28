import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test1282 {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<List<Integer>>> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            // 找到对应尺寸的组集合
            List<List<Integer>> lists = map.getOrDefault(groupSizes[i], newArrayList());
            // 找到集合最后一个组
            List<Integer> list = lists.get(lists.size() - 1);
            // 该组没有空闲
            if (list.size() >= groupSizes[i]) {
                // 重新开一个组
                list = new ArrayList<>();
                lists.add(list);
            }
            // 添加进去
            list.add(i);
            map.put(groupSizes[i], lists);
        }

        List<List<Integer>> res = new ArrayList<>();
        // Collection<List<List<Integer>>> values = map.values();
        for (List<List<Integer>> list : map.values()) {
            res.addAll(list);
        }
        return res;

    }

    private List<List<Integer>> newArrayList() {
        List<Integer> i = new ArrayList<>();
        List<List<Integer>> o = new ArrayList<>();
        o.add(i);
        return o;
    }

}
