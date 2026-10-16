package Threads;

public class MultiThreading extends Thread {
    private int thread_number;

    public MultiThreading(int t) {
        this.thread_number = t;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 5; i++) {
            System.out.println("Thread number is " + thread_number + ":" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}