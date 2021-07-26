package sort;

import java.util.Arrays;

/**
 * @description: 快速排序
 * @author: chobit
 * @created: 2021/07/12 11:38
 */
public class Quick {

    public static void sort(int[] array, int left, int right) {
        if (left > right) return;
        int i = left, j = right;
        int temp = array[i];
        while (i < j) {
            while (array[j] > temp && i < j) {
                j--;
            }
            if (i < j) {
                array[i] = array[j];
                i++;
            }
            while (array[i] < temp && i < j) {
                i++;
            }
            if (i < j) {
                array[j] = array[i];
                j--;
            }
        }
        array[i] = temp;
        sort(array, left, i - 1);
        sort(array, i + 1, right);
    }

    public static void main(String[] args) {
        int[] array = new int[]{6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        sort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }
}
