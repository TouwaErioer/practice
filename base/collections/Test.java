package base.collections;

import base.collections.List.ArrayList;
import base.collections.List.LinkedList;
import base.collections.List.List;

/**
 * @description:
 * @author: chobit
 * @created: 2021/07/28 17:34
 */
public class Test {

    public static void main(String[] args) {
        List<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            linkedList.add(i);
        }
        System.out.println("在第1个位置添加元素0：" + linkedList.add(0, 1));
        System.out.println("删除第10个位置上的元素：" + linkedList.remove(10));
        System.out.println("设置第1个元素为0：" + linkedList.set(0, 1));
        System.out.println("第一个元素为：" + linkedList.get(0));
        System.out.println("数组的长度为：" + linkedList.getSize());
        System.out.println("元素1的首次出现位置为：" + linkedList.indexOf(1));
        linkedList.print();
    }
}
