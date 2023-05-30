package lc30;

public class Test2220 {
    public int minBitFlips1(int start, int goal) {
        int res = 0;
        while (start > 0 || goal > 0) {
            if ((start & 1) != (goal & 1)) {
                res++;
            }
            start >>= 1;
            goal >>= 1;
        }
        return res;
    }

    // 官方
    public int minBitFlips(int start, int goal) {
        int i = start ^ goal;

        int total = 0;
        while (i != 0) {
            total++;
            i &= i - 1; // 将i的二进制表示中的最低位为1的改为0。
        }
        return total;
    }

    public static void main(String[] args) {
        Test2220 test2220 = new Test2220();
        int minBitFlips = test2220.minBitFlips(10, 7);
        System.out.println(minBitFlips);
    }

}
