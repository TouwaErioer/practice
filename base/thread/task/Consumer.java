package base.thread.task;

import base.thread.ThreadWaitNotifyDemo;

/**
 * @description: 生产者
 * @author: chobit
 * @created: 2021/07/29 11:22
 */
public class Consumer extends Thread {

    public Consumer(String ThreadName) {
        super(ThreadName);
    }

    @Override
    public void run() {
        while (true) {
            synchronized (ThreadWaitNotifyDemo.queue) {
                while (ThreadWaitNotifyDemo.queue.size() == 0) {
                    try {
                        System.out.println("队列空，等待数据");
                        ThreadWaitNotifyDemo.queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        ThreadWaitNotifyDemo.queue.notifyAll();
                    }
                }
                ThreadWaitNotifyDemo.queue.poll();
                ThreadWaitNotifyDemo.queue.notifyAll();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(String.format("%s向队列取出1个元素，当前队列有%d个元素", Thread.currentThread().getName(), ThreadWaitNotifyDemo.queue.size()));
            }
        }
    }
}
