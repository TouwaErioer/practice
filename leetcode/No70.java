package leetcode;

/**
 * @description: https://leetcode-cn.com/problems/climbing-stairs/
 * @author: chobit
 * @created: 2021/08/02 10:56
 */

public class No70 {

    public int solve(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        int z, x = 0, c = 1;
        for (int i = 1; i <= n; i++) {
            z = x;
            x = c;
            c = z + x;
        }
        return c;
    }
}