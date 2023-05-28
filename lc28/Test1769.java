public class Test1769 {
    public int[] minOperations(String boxes) {
        int[] res = new int[boxes.length()];
        for (int i = 0; i < boxes.length(); i++) {
            for (int j = 0; j < boxes.length(); j++) {
                // 有盘子
                if (i != j && boxes.charAt(j) == '1') {
                    res[i] += Math.abs(i - j);
                }

            }

        }
        return res;
    }
}
