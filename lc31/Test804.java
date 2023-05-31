package lc31;

import java.util.HashSet;
import java.util.Set;

public class Test804 {
    public int uniqueMorseRepresentations(String[] words) {
        String[] mos = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--",
                "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.." };

        Set<String> hash = new HashSet<>();
        // 遍历每个单词
        for (String word : words) {
            // 遍历每个字母
            String tmp = "";
            for (int i = 0; i < word.length(); i++) {
                tmp += mos[word.charAt(i) - 'a'];
            }
            hash.add(tmp);

        }
        return hash.size();
    }
}
