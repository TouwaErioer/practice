package leetcode;

/**
 * @description: https://leetcode-cn.com/problems/counting-bits/
 * @author: chobit
 * @created: 2021/08/02 13:46
 */
public class No338 {

    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 0; i < n; i++) {
            ans[i] = countInt(Integer.toBinaryString(i));
        }
        return ans;
    }

    private int countInt(String str) {
        int ans = 0;
        for (char c : str.toCharArray()) {
            if (c == (char) 1) {
                ans++;
            }
        }
        return ans;
    }
}
