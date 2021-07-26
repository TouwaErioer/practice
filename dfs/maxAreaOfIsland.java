package dfs;

/**
 * @description: 岛屿的最大面积 https://leetcode-cn.com/problems/max-area-of-island/
 * @author: chobit
 * @created: 2021/04/17 22:23
 */
public class maxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid[0].length == 0) {
            return 0;
        }

        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    res = Math.max(dfs(grid, i, j), res);
                }
            }
        }
        return res;
    }

    public int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i == grid.length || j < 0 || j == grid[i].length || grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = 0;
        int res = 1;
        res += dfs(grid, i + 1, j);
        res += dfs(grid, i - 1, j);
        res += dfs(grid, i, j + 1);
        res += dfs(grid, i, j - 1);
        return res;
    }
}
