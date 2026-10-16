package Threads;

public class ThreadHandler {

    public static void main(String[] args) {
        MultiThreadingRunnable t1 = new MultiThreadingRunnable(1);
        Thread tt1 = new Thread(t1);

        MultiThreadingRunnable t2 = new MultiThreadingRunnable(2);
        Thread tt2 = new Thread(t2);

        MultiThreadingRunnable t3 = new MultiThreadingRunnable(3);
        Thread tt3 = new Thread(t3);

        tt1.start();
        try {
            tt1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        tt2.start();
        tt3.start();
    }
}