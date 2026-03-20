package com.learn4you.parallel.multithreading;

class TRunner1 implements Runnable {
    @Override
    public void run() {
        for(int i = 0; i < 10; i++) {
            System.out.println(this.getClass().getSimpleName() + ": " + i);
        }
    }
}

class TRunner2 implements Runnable {
    @Override
    public void run() {
        for(int i = 0; i < 10; i++) {
            System.out.println(this.getClass().getSimpleName() + ": " + i);
        }
    }
}

public class ThreadRunnable {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new TRunner1());
        Thread thread2 = new Thread(new TRunner2());

        long startTime = System.nanoTime();

        try {
            thread1.start();
            thread2.start();

            // wait for both threads to finish
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println("Total time taken: " + totalTime/1000000 + "ms");
    }
}