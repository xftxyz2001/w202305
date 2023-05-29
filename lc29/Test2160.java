import java.util.Arrays;

public class Test2160 {
    // public int minimumSum(int num) {
    // int min = Integer.MAX_VALUE;
    // int h = num / 1000, l = num % 1000; // 1 234
    // if (h + l < min) {
    // min = h + l;
    // }

    // h = h * 10 + l / 100; // 12
    // l = l % 100; // 34
    // if (h + l < min) {
    // min = h + l;
    // }

    // h = h * 10 + l / 10; // 123
    // l = l % 10; // 4
    // if (h + l < min) {
    // min = h + l;
    // }
    // return min;

    // }

    public int minimumSum(int num) {
        int[] qbsg = new int[4];
        // for (int i = qbsg.length - 1; i >= 0; i--) {
        for (int i = 0; i < qbsg.length; i++) {
            qbsg[i] = num % 10;
            num /= 10;
        }
        // System.out.println(Arrays.toString(qbsg));
        Arrays.sort(qbsg);
        return qbsg[0] * 10 + qbsg[1] * 10 + qbsg[2] + qbsg[3];
    }

    public static void main(String[] args) {
        Test2160 test2160 = new Test2160();
        int minimumSum = test2160.minimumSum(2932);
        System.out.println(minimumSum);
    }
}
