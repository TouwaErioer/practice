package leetcode;

/**
 * @description: Excel 表列序号
 * @author: chobit
 * @created: 2021/07/30 14:00
 */

public class No171 {

    public static int titleToNumber(String title) {
        int ans = 0;
        for (char c : title.toCharArray()) {
            int num = c - 'A' + 1;
            ans = ans * 26 + num;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(titleToNumber("AA"));
    }
}