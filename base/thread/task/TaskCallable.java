package base.thread.task;

import java.util.concurrent.Callable;

/**
 * @description: 通过实现Callable接口实现线程的任务类
 * @author: chobit
 * @created: 2021/07/29 10:38
 */
public class TaskCallable implements Callable<Long> {

    private int ticket = 5;

    @Override
    public Long call() {
        long begin = System.nanoTime();
        while (ticket > 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + "被终止");
            }
            System.out.println(String.format("%s卖出了第%d张票", Thread.currentThread().getName(), ticket));
            ticket--;
        }
        long end = System.nanoTime();
        return (end - begin);
    }
}
