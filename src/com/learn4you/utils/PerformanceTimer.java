package com.learn4you.utils;

public class PerformanceTimer {

    /**
     * Measures the execution time of a given task and logs the result.
     *
     * <p>This method executes the provided {@link Runnable} task, calculates
     * the duration using {@code System.nanoTime()}, and prints the result
     * along with the given task name.</p>
     *
     * <p>Behavior:</p>
     * <ul>
     *   <li>The duration is always measured and logged, even if the task throws an exception.</li>
     *   <li>If a runtime exception occurs, it is propagated to the caller.</li>
     * </ul>
     *
     * @param taskName a descriptive name of the task (used for logging)
     * @param task     the {@link Runnable} task to execute
     * @return execution time in milliseconds
     */
    public static long getDuration(String taskName, Runnable task) {
        long startTime = System.nanoTime();
        long duration;

        try {
            task.run();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            duration = (System.nanoTime() - startTime) / 1_000_000;
            System.out.println("Task '" + taskName + "' took " + duration + "(ms).");

        }

        return duration;
    }
}