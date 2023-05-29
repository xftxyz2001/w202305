import java.util.ArrayList;
import java.util.List;

public class Test2194 {
    // 01 2 34
    // K1 : L2
    public List<String> cellsInRange(String s) {
        List<String> res = new ArrayList<>();
        // for (char i = s.charAt(0); i <= s.charAt(3); i++) {
        // for (char j = s.charAt(1); j <= s.charAt(4); j++) {
        char[] charArray = s.toCharArray();
        for (char i = charArray[0]; i <= charArray[3]; i++) {
            for (char j = charArray[1]; j <= charArray[4]; j++) {
                res.add(new StringBuilder().append(i).append(j).toString());
            }
        }
        return res;
    }

    public static void main(String[] args) {
        // System.out.println((char) 1 + (char) 1);
    }
}
