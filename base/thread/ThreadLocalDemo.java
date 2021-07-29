package base.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description: ThreadLocal实例
 * @author: chobit
 * @created: 2021/07/29 15:21
 */
public class ThreadLocalDemo {

    private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 0);

    static class Task implements Runnable {

        @Override
        public void run() {
            int count = threadLocal.get();
            for (int i = 0; i < 10; i++) {
                count++;
            }
            threadLocal.set(count);
            // 避免内存泄漏
            threadLocal.remove();
            System.out.println(Thread.currentThread().getName() + " : " + count);
        }
    }


    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; i++) {
            executorService.execute(new Task());
        }
        executorService.shutdown();
    }
}