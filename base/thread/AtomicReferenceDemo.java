package base.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @description: 用 AtomicReference 实现自旋锁
 * @author: chobit
 * @created: 2021/07/29 14:57
 */
public class AtomicReferenceDemo {

    private static int ticket = 10;

    public static void main(String[] args) {
        threadSafe();
    }

    private static void threadSafe() {
        SpinLock lock = new SpinLock();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 5; i++) {
            executorService.execute(new Task(lock));
        }
        executorService.shutdown();
    }

    static class SpinLock {

        private AtomicReference<Thread> atomicReference = new AtomicReference<>();

        public void lock() {
            Thread current = Thread.currentThread();
            while (!atomicReference.compareAndSet(null, current)) {
            }
        }

        public void unlock() {
            Thread current = Thread.currentThread();
            atomicReference.compareAndSet(current, null);
        }
    }

    static class Task implements Runnable {

        private SpinLock lock;

        public Task(SpinLock lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            while (ticket > 0) {
                lock.lock();
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + " 卖出了第 " + ticket + " 张票");
                    ticket--;
                }
                lock.unlock();
            }
        }
    }
}
