package base.thread.task;

/**
 * @description: 通过实现Runnable接口实现线程的任务类
 * @author: chobit
 * @created: 2021/07/29 10:29
 */
public class TaskRunnable implements Runnable {

    private int ticket = 5;

    @Override
    public void run() {
        while (ticket > 0) {
            System.out.println(String.format("%s卖出了第%d张票", Thread.currentThread().getName(), ticket));
            ticket--;
        }
    }
}
