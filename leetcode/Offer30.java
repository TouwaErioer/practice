package leetcode;

import java.util.Stack;

/**
 * @description: https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/
 * @author: chobit
 * @created: 2021/08/06 10:39
 */

public class Offer30 {

    Stack<Integer> a, b;

    public Offer30() {
        a = new Stack<>();
        b = new Stack<>();
    }

    public void push(int x) {
        a.add(x);
        if (b.empty() || b.peek() >= x) {
            b.add(x);
        }
    }

    public void pop() {
        if (a.pop().equals(b.peek())) {
            b.pop();
        }
    }

    public int top() {
        return a.peek();
    }

    public int min() {
        return b.peek();
    }

    public void print() {
        System.out.println(a.toString());
    }

    public static void main(String[] args) {
        Offer30 offer = new Offer30();
        offer.push(-2);
        offer.push(0);
        offer.push(-3);
        System.out.println(offer.min());
        offer.pop();
        offer.pop();
        offer.print();
        System.out.println(offer.min());
    }
}
