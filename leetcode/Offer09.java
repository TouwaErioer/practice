package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @description: https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 * @author: chobit
 * @created: 2021/08/06 10:26
 */
public class Offer09 {

    Stack<Integer> in;
    Stack<Integer> out;

    public Offer09() {
        in = new Stack<>();
        out = new Stack<>();
    }

    public void appendTail(int value) {
        in.add(value);
    }

    public int deleteHead() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }

        if (out.isEmpty()) {
            return -1;
        }

        return out.pop();
    }
}
