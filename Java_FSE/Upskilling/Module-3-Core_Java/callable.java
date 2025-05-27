import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class callable {
    
    public static void main(String[] args) {
        
        // Create an ExecutorService with a fixed thread pool of 3 threads
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        
        // Create a list of Callable tasks
        Callable<String> task1 = () -> {
            Thread.sleep(2000);  // Simulate some work
            return "Result from Task 1";
        };
        
        Callable<String> task2 = () -> {
            Thread.sleep(1000);  // Simulate some work
            return "Result from Task 2";
        };
        
        Callable<String> task3 = () -> {
            Thread.sleep(1500);  // Simulate some work
            return "Result from Task 3";
        };
        
        // Submit tasks to the ExecutorService
        Future<String> future1 = executorService.submit(task1);
        Future<String> future2 = executorService.submit(task2);
        Future<String> future3 = executorService.submit(task3);
        
        try {
            // Get the results of each task (blocking call until each task finishes)
            System.out.println("Task 1: " + future1.get());
            System.out.println("Task 2: " + future2.get());
            System.out.println("Task 3: " + future3.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Shutdown the ExecutorService
        executorService.shutdown();
    }
}
