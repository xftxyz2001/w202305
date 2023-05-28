public class Test2011 {
    public int finalValueAfterOperations(String[] operations) {
        int res = 0;
        for (int i = 0; i < operations.length; i++) {
            res += operations[i].charAt(1) == '+' ? 1 : -1;
        }
        return res;
    }
}
