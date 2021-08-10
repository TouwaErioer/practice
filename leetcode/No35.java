package leetcode;

/**
 * @description: https://leetcode-cn.com/problems/search-insert-position/
 * @author: chobit
 * @created: 2021/08/09 15:29
 */
public class No35 {

    public int searchInsert(int[] nums, int target) {
        int len = nums.length - 1;
        int r = len;
        for (int l = 0; l <= len; l++) {
            if (nums[l] == target) {
                return l;
            } else if (nums[r] == target) {
                return r;
            }
            r--;
        }
        return r;
    }
}
