package base;

/**
 * @description: 利用for打印菱形
 * @author: chobit
 * @created: 2021/07/23 09:23
 */

public class PrintRhombus {

    /**
     * 利用for打印指定行数的菱形
     *
     * @param n 打印菱形的行数
     */
    public static void run(int n) {
        // 前置检查行数
        if(n % 2 != 0){
            throw new IllegalArgumentException("行数不能为奇数");
        }
        // 打印上半部分
        for (int i = 1; i <= n / 2; i++) {
            helper(i, n);
        }
        // 打印下半部分
        for (int i = n / 2 - 1; i >= 1; i--) {
            helper(i, n);
        }
    }

    /**
     * 辅助打印方法
     *
     * @param i 行数
     * @param n 当前部分总行数
     */
    public static void helper(int i, int n) {
        // 打印空格
        for (int j = 1; j <= n - i; j++) {
            System.out.print(" ");
        }
        // 打印占位符*
        for (int j = n - i + 1; j < n + i; j++) {
            System.out.print("*");
        }
        // 换行
        System.out.println(" ");
    }

    public static void main(String[] args) {
        run(6);
    }
}