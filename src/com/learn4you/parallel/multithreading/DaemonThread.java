package com.learn4you.parallel.multithreading;

class DaemonWorker implements Runnable{
    @Override
    public void run() {
        try {
            while(true){
                Thread.sleep(1000);  // 1s
                System.out.println("DaemonWorker is running...");
            }
        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//            e.printStackTrace();
            Thread.currentThread().interrupt();
            System.out.println("DaemonWorker is interrupted");
        }
    }
}

class NormalWorker implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(3000);  // 3s
        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
            Thread.currentThread().interrupt();
            System.out.println("NormalWorker is interrupted");
        }
        System.out.println("NormalWorker is running...");
    }
}

public class DaemonThread {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new DaemonWorker());
        Thread t2 = new Thread(new NormalWorker());

        t1.setDaemon(true);

        t1.start();
        t2.start();
    }
}