package leetcode;

/**
 * @description: https://leetcode-cn.com/problems/squares-of-a-sorted-array/
 * @author: chobit
 * @created: 2021/08/10 15:58
 */
public class No977 {

    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0, j = n - 1, pos = n - 1; i <= j; ) {
            int l = nums[i], r = nums[j];
            if (l * l > r * r) {
                ans[pos] = l * l;
                ++i;
            } else {
                ans[pos] = r * r;
                --j;
            }
            --pos;
        }
        return ans;
    }
}
