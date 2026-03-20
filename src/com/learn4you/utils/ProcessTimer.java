package com.learn4you.utils;

public class ProcessTimer {
    static Runnable estimateSquareRoot(long n) {
        return () -> {
            for (long i = 0; i < n; i++) {
                Math.sqrt(i);
            }
        };
    }

    static Runnable estimateSquareRoot2(long n) {
        return new Runnable() {
            @Override
            public void run() {
                for (long i = 0; i < n; i++) {
                    Math.sqrt(i);
                }
            }
        };
    }

    public static void main(String[] args) {
        long totalTime = PerformanceTimer.getDuration(
                "Estimate Square Root", () -> {
                    for (long i = 1; i <= 1_000_000_000L; i++) {
                        Math.sqrt(i);
                    }
                });

        System.out.println("Duration: " + totalTime + " ms");

        System.out.println("-".repeat(36));
        totalTime = PerformanceTimer.getDuration(
            "Estimate Square Root 2",
            estimateSquareRoot(1_000_000_000L)
        );

        System.out.println("-".repeat(36));
        totalTime = PerformanceTimer.getDuration(
                "Estimate Square Root 3",
                estimateSquareRoot2(2_000_000_000L)
        );
    }
}