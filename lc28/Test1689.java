public class Test1689 {
    public int minPartitions(String n) {
        char res = 0;
        for (int i = n.length() - 1; i >= 0; i--) {
            char tmp = n.charAt(i);
            if (tmp > res) {
                res = tmp;
            }
        }
        return res - '0';
    }
}
