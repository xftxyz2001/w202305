import java.util.HashSet;
import java.util.Set;

public class Test1832 {
    public boolean checkIfPangram1(String sentence) {
        if (sentence.length() < 26) {
            return false;
        }
        Set<Character> hash = new HashSet<>(26);
        for (int i = 0; i < sentence.length(); i++) {
            hash.add(sentence.charAt(i));
        }
        return hash.size() == 26;
    }

    // 官方题解，经典的int位存储字母表
    public boolean checkIfPangram(String sentence) {
        int state = 0;
        for (int i = 0; i < sentence.length(); i++) {
            char c = sentence.charAt(i);
            state |= 1 << (c - 'a');
        }
        return state == (1 << 26) - 1;
    }
}
