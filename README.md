# Java Parallel Computing & Concurrency Examples
Learn how concurrency, multithreading, and parallel computing work in Java through practical examples.

# Useful functions

## getClass().getSimpleName()
This gives only the class name without the package.

```java
// Method 1: Inside a class
this.getClass().getSimpleName();  // Returns the current class name

// Method 2: Using an object
Runner1 runner = new Runner1();
runner.getClass().getSimpleName(); // Output: "Runner1"

// Method 3: Using the class directly
Runner1.class.getSimpleName();    // Output: "Runner1"
```

**Notes:**

* `this.getClass().getSimpleName()` returns the **actual runtime class name**, which is useful when inheritance is involved.
* `Runner1.class.getSimpleName()` returns the **static class name**, independent of any object.


## `ClassName.class.getName()`

This method returns the **fully qualified class name**, including the package. You can use it in a few ways:

```java
// Method 1: Inside a class
this.getClass().getName();   // Returns the fully qualified name of the current object

// Method 2: Using an object
Runner1 runner = new Runner1();
runner.getClass().getName(); // Output: "com.example.Runner1"

// Method 3: Using a class directly
Runner1.class.getName();    // Output: "com.example.Runner1" (if in package com.example)
```

**Notes:**

* `ClassName.class.getName()` is **static**, independent of any object.
* `this.getClass().getName()` or `object.getClass().getName()` returns the **runtime class name**, useful with inheritance.

# Measure how long a process or a thread takes

```java
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
```