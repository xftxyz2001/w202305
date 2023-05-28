// error
public class Test1439 {
    public int kthSmallest(int[][] mat, int k) {
        // 记录第i行取到的下标
        int[] mati = new int[mat.length];

        while (k-- > 0) {
            // 找到最小增量的行
            int minDiff = Integer.MAX_VALUE;
            int minDiffIndex = -1;
            for (int i = 0; i < mat.length; i++) {
                if (mati[i] + 1 < mat[i].length) {
                    int diff = mat[i][mati[i] + 1] - mat[i][mati[i]];
                    if (diff < minDiff) {
                        minDiff = diff;
                        minDiffIndex = i;
                    }
                }
            }
            mati[minDiffIndex]++;
        }

        int res = 0;
        for (int i = 0; i < mat.length; i++) {
            res += mat[i][mati[i]];
        }
        return res;
    }

    public static void main(String[] args) {
        new Test1439().kthSmallest(new int[][] {
                { 1, 3, 11 },
                { 2, 4, 6 }
        }, 4);
    }

}