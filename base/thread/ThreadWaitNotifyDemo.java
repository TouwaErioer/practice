package base.thread;

import base.thread.task.Consumer;
import base.thread.task.Producer;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @description: 用生产者消费者关系演示 wait notify 操作
 * @author: chobit
 * @created: 2021/07/29 11:20
 */
public class ThreadWaitNotifyDemo {

    public static final int QUEUE_SIZE = 10;
    public static final Queue<Integer> queue = new PriorityQueue<>();

    public static void main(String[] args) {
        new Producer("生产者A").start();
        new Producer("生产者B").start();
        new Consumer("消费者A").start();
        new Consumer("消费者B").start();
    }
}
