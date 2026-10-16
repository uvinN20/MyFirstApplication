package Threads;

public class MultiThreadingRunnable implements Runnable {
    private int thread_number;

    public MultiThreadingRunnable(int t) {
        this.thread_number = t;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Thread number is " + thread_number + ":" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}