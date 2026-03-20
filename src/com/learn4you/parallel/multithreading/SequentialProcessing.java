package com.learn4you.parallel.multithreading;

class Runner1 {
    public void execute() {
        for (int i = 0; i < 10; i++) {
            // runner.getClass().getSimpleName() --> Runner1
            // runner.getClass().getName() --> com.learn4you.parallel.multithreading.Runner1
            System.out.println(this.getClass().getSimpleName() + " : " + i);
        }
    }
}

class Runner2 {
    public void execute() {
        for (int i = 0; i < 10; i++) {
            // runner.getClass().getSimpleName() --> Runner2
            // runner.getClass().getName() --> com.learn4you.parallel.multithreading.Runner2
            System.out.println(this.getClass().getSimpleName() + " : " + i);
        }
    }
}

public class SequentialProcessing {

    public static void main(String[] args) {

        Runner1 runner1 = new Runner1();
        Runner2 runner2 = new Runner2();

        runner1.execute();
        runner2.execute();
    }
}