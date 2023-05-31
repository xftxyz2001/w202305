package lc31;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test1436 {
    public String destCity(List<List<String>> paths) {
        Map<String, Integer> hash = new HashMap<>();
        for (List<String> list : paths) {
            if (hash.containsKey(list.get(0))) {
                hash.remove(list.get(0));
            } else {
                hash.put(list.get(0), -1);
            }
            if (hash.containsKey(list.get(1))) {
                hash.remove(list.get(1));
            } else {
                hash.put(list.get(1), 1);
            }
            // hash.put(list.get(0), hash.getOrDefault(list.get(0), 0) - 1);
            // hash.put(list.get(1), hash.getOrDefault(list.get(1), 0) + 1);

        }
        // 找到度为1的key
        return hash.entrySet().stream().filter(t -> t.getValue() == 1).findFirst().get().getKey();
    }

    public static void main(String[] args) {
        Test1436 test1436 = new Test1436();
        List<List<String>> paths = new ArrayList<>();
        // [["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]]
        paths.add(List.of("London", "New York"));
        paths.add(List.of("New York", "Lima"));
        paths.add(List.of("Lima", "Sao Paulo"));

        String destCity = test1436.destCity(paths);
        System.out.println(destCity);
    }

}
