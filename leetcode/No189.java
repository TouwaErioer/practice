package leetcode;

/**
 * @description: https://leetcode-cn.com/problems/rotate-array/
 * @author: chobit
 * @created: 2021/08/10 16:12
 */
public class No189 {

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] newArray = new int[n];
        for (int i = 0; i < n; i++) {
            newArray[(i + k) % k] = nums[i];
        }
        System.arraycopy(newArray, 0, nums, 0, n);
    }
}