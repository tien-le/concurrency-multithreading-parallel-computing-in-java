package com.learn4you.parallel.multithreading;

class TRunnerClass1 extends Thread {
    @Override
    public void run() {
        long startTime = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            System.out.println(this.getClass().getSimpleName() + ": " + i);
        }
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println(this.getClass().getSimpleName() + "--Total Time : " + totalTime/1000000 + "ms");
    }
}

class TRunnerClass2 extends Thread {
    @Override
    public void run() {
        long startTime = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            System.out.println(this.getClass().getSimpleName() + ": " + i);
        }
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println(this.getClass().getSimpleName() + "--Total Time : " + totalTime/1000000 + "ms");
    }
}

public class ThreadClass {
    public static void main(String[] args) throws InterruptedException {
        long startTime = System.nanoTime();

        Thread t1 = new TRunnerClass1();
        Thread t2 = new TRunnerClass2();

        t1.start();
        t2.start();

        t1.join();
        t2.join();

/*
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
*/

        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println("Total Time : " + totalTime/1000000 + "ms");
    }
}