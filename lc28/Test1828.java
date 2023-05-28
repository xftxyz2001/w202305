public class Test1828 {
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] res = new int[queries.length];
        // 遍历所有圆
        // for (int i = 0; i < queries.length; i++) {
        for (int i = 0; i < queries.length; ++i) {
            // 遍历所有点
            // for (int j = 0; j < points.length; j++) {
            for (int j = 0; j < points.length; ++j) {
                // 如果点在圆里
                if ((points[j][0] - queries[i][0]) * (points[j][0] - queries[i][0]) +
                        (points[j][1] - queries[i][1]) * (points[j][1]
                                - queries[i][1]) <= queries[i][2] * queries[i][2]) {
                    // res[i]++;
                    ++res[i];
                }
            }
        }
        return res;
    }
}
