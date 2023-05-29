import java.util.HashSet;
import java.util.Set;

public class Test1684 {
    public int countConsistentStrings1(String allowed, String[] words) {
        // 建立哈希表
        Set<Character> hash = new HashSet<>();
        for (int i = 0; i < allowed.length(); i++) {
            hash.add(allowed.charAt(i));
        }

        int res = 0;

        // 遍历words查看每个字符是否在哈希表中
        for (int i = 0; i < words.length; i++) {
            // 假设是一致字符串
            boolean flag = true;
            for (int j = 0; j < words[i].length(); j++) {
                if (!hash.contains(words[i].charAt(j))) {
                    flag = false;
                    break;
                }
            }

            // 如果是一致字符串
            if (flag) {
                res++;
            }

        }
        return res;
    }

    // 官方题解
    public int countConsistentStrings(String allowed, String[] words) {
        int mask = 0;
        for (int i = 0; i < allowed.length(); i++) {
            char c = allowed.charAt(i);
            mask |= 1 << (c - 'a');
        }
        int res = 0;
        for (String word : words) {
            int mask1 = 0;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                mask1 |= 1 << (c - 'a');
            }
            if ((mask1 | mask) == mask) {
                res++;
            }
        }
        return res;
    }

}
