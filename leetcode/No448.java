package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @description: https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/
 * @author: chobit
 * @created: 2021/08/02 13:57
 */
public class No448 {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for (int num : nums) {
            int x = (num - 1) % n;
            nums[x] += n;
        }
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                ret.add(i + 1);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new No448().findDisappearedNumbers(new int[]{1, 1}).toString());
    }
}
