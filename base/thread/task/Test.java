package base.thread.task;

import base.thread.task.TaskCallable;
import base.thread.task.TaskRunnable;
import base.thread.task.TaskThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @description:
 * @author: chobit
 * @created: 2021/07/29 10:50
 */
public class Test {

    /**
     * 继承 Thread 为最基础的线程实现方式，因为 Java 只支持单继承，所以不灵活
     */
    public static void useThread() {
        TaskThread thread1 = new TaskThread("线程A");
        TaskThread thread2 = new TaskThread("线程B");
        thread1.start();
        thread2.start();
    }

    /**
     * 实现 Runnable 接口和继承 Thread 类实现线程差不多，但不能返回值
     */
    public static void useRunnable() {
        Thread thread1 = new Thread(new TaskRunnable(), "线程A");
        Thread thread2 = new Thread(new TaskRunnable(), "线程B");
        thread1.start();
        thread2.start();
    }

    /**
     * 实现 Callable 接口可以用 FutureTask 得到返回值
     */
    public static void useCallable() {
        Callable<Long> callableA = new TaskCallable();
        FutureTask<Long> futureA = new FutureTask<>(callableA);
        Callable<Long> callableB = new TaskCallable();
        FutureTask<Long> futureB = new FutureTask<>(callableB);
        Thread threadA = new Thread(futureA, "线程A");
        Thread threadB = new Thread(futureB, "线程B");
        // 设置线程优先级 范围为 1 ~ 10
        threadA.setPriority(10);
        threadA.start();
        threadB.start();
        threadA.interrupt();
        try {
            System.out.println("线程A任务耗时：" + (futureA.get() / 1000000) + "毫秒");
            System.out.println("线程B任务耗时：" + (futureB.get() / 1000000) + "毫秒");
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        useCallable();
    }
}
