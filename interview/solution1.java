package interview;

import java.util.Arrays;

public class solution1 {

    public static void main(String[] args) {
        int[] data = new int[]{1, 5, 8, 17, 29, 33, 39, 11, 16};
        boolean[] flag = new boolean[data.length];
        Arrays.fill(flag, false);
        MultiSum(data, data.length, 33, flag, flag.length);
    }

    public static void MultiSum(int[] data, int length, int sum, boolean[] flag, int flag_size) {
        if (length <= 0 || sum <= 0)
            return;
        if (sum == data[length - 1]) {
            for (int i = 0; i < flag_size; i++) {
                if (flag[i])
                    System.out.print(String.format("%d,", i));
            }
            System.out.println(String.format("%d", length - 1));
        }
        flag[length - 1] = true;
        MultiSum(data, length - 1, sum - data[length - 1], flag, flag_size);
        flag[length - 1] = false;
        MultiSum(data, length - 1, sum, flag, flag_size);
    }
}