package leetcode;

/**
 * @description: https://leetcode-cn.com/problems/hamming-distance/
 * @author: chobit
 * @created: 2021/08/02 14:28
 */
public class No461 {

    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }


    public static void main(String[] args) {
        System.out.println(new No461().hammingDistance(680142203, 1111953568));
    }
}
