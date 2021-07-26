package dfs;

/**
 * @description: 岛屿数量 https://leetcode-cn.com/problems/number-of-islands/
 * @author: chobit
 * @created: 2021/04/17 22:01
 */
public class islands {

    public static int numIslands(char[][] island) {
        if (island == null || island[0].length == 0 || island.length == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < island.length; i++) {
            for (int j = 0; j < island[i].length; j++) {
                if (island[i][j] == '1') {
                    res += 1;
                    dfs(island, i, j);
                }
            }
        }
        return res;
    }

    public static void dfs(char[][] island, int i, int j) {
        if (i < 0 || i == island.length || j < 0 || j == island[i].length || island[i][j] != '1') {
            return;
        }
        island[i][j] = '0';
        dfs(island, i + 1, j);
        dfs(island, i - 1, j);
        dfs(island, i, j + 1);
        dfs(island, i, j - 1);
    }
}
