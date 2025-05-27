public class Virtual {
    
    public static void main(String[] args) {
        // Measure performance for virtual threads
        long startTimeVirtualThreads = System.nanoTime();
        
        // Launch 100,000 virtual threads
        for (int i = 0; i < 100000; i++) {
            Thread.startVirtualThread(() -> {
                System.out.println("Virtual thread " + Thread.currentThread().getName());
            });
        }
        
        // Wait a moment to ensure threads complete (as an example, may be improved)
        try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
        
        long endTimeVirtualThreads = System.nanoTime();
        System.out.println("Time taken to start 100,000 virtual threads: " 
                + (endTimeVirtualThreads - startTimeVirtualThreads) / 1_000_000 + " ms");
        
        // Measure performance for traditional threads
        long startTimeTraditionalThreads = System.nanoTime();
        
        // Launch 100,000 traditional threads
        for (int i = 0; i < 100000; i++) {
            new Thread(() -> {
                System.out.println("Traditional thread " + Thread.currentThread().getName());
            }).start();
        }
        
        // Wait a moment to ensure threads complete (as an example, may be improved)
        try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
        
        long endTimeTraditionalThreads = System.nanoTime();
        System.out.println("Time taken to start 100,000 traditional threads: " 
                + (endTimeTraditionalThreads - startTimeTraditionalThreads) / 1_000_000 + " ms");
    }
}
