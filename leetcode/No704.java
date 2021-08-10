package leetcode;

/**
 * @description: https://leetcode-cn.com/problems/binary-search/
 * @author: chobit
 * @created: 2021/08/09 15:08
 */
public class No704 {

    public int search(int[] nums, int target) {
        int pivot, left = 0, right = nums.length - 1;
        while (left <= right) {
            pivot = left + (right - left) / 2;
            if(nums[pivot] == target) return pivot;
            else if(target < nums[pivot]) right = pivot - 1;
            else left = pivot + 1;
        }
        return -1;
    }


    public static void main(String[] args) {
        System.out.println(new No704().search(new int[]{5}, 5));
    }

}
