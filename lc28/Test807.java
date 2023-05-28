public class Test807 {
    public int maxIncreaseKeepingSkyline(int[][] grid) {

        // 获得每行、每列最高的建筑
        int[] rowMax = new int[grid.length];
        int[] colMax = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] > rowMax[i]) {
                    rowMax[i] = grid[i][j];
                }
                if (grid[i][j] > colMax[j]) {
                    colMax[j] = grid[i][j];
                }
            }
        }

        // 遍历，每个建筑最高增加行列最高建筑的小者
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                res += (rowMax[i] < colMax[j] ? rowMax[i] : colMax[j]) - grid[i][j];
            }
        }
        return res;
    }

}
