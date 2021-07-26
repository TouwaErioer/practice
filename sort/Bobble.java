package sort;

import java.util.Arrays;

/**
 * @description: 冒泡排序
 * @author: chobit
 * @created: 2021/07/10 14:53
 */
public class Bobble {

    public static void sort(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 5, 2};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}