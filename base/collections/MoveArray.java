package base.collections;

import java.util.Arrays;

/**
 * @description: 利用System.arrayCopy移动数组
 * @author: chobit
 * @created: 2021/07/23 13:43
 */
public class MoveArray {

    public static int[] add(int[] array, int index, int element) {
        // 扩容
        array = Arrays.copyOf(array, array.length + 1);
        System.arraycopy(array, index, array, index + 1, array.length - index - 1);
        array[index] = element;
        return array;
    }

    public static void main(String[] args) {
        int[] array = new int[10];
        for (int i = 0; i < 10; i++) {
            array[i] = i;
        }
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(add(array, 1, 1)));
    }
}
