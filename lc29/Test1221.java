public class Test1221 {
    public int balancedStringSplit(String s) {
        int res = 0;
        int r = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'R') {
                r++;
            } else {
                r--;
            }
            if (r == 0) {
                res++;
            }
        }
        return res;
    }
}
