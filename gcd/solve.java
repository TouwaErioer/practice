package gcd;

/**
 * @description: 最大公约数
 * @author: chobit
 * @created: 2021/04/17 22:40
 */
public class solve {

    public static int GCD(int a, int b) {
        return b == 0 ? a : GCD(b, a % b);
    }


    public static void main(String[] args) {
        System.out.println(GCD(2, 3));
    }
}