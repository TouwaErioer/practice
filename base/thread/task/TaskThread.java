package base.thread.task;

/**
 * @description: 通过继承Thread实现线程的任务类
 * @author: chobit
 * @created: 2021/07/29 10:29
 */
public class TaskThread extends Thread {

    private int ticket = 5;

    public TaskThread(String TreadName) {
        super(TreadName);
    }

    @Override
    public void run() {
        while (ticket > 0) {
            System.out.println(String.format("%s卖出了第%d张票", Thread.currentThread().getName(), ticket));
            ticket--;
        }
    }
}
