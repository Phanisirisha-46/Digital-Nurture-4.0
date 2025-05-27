// Implementing multithreading by extending the Thread class
public class Threads {
    public static void main(String[] args) {
        // Creating instances of the Thread subclasses
        Thread thread1 = new Thread1();
        Thread thread2 = new Thread2();

        // Starting both threads
        thread1.start();
        thread2.start();
    }
}

// Thread class 1 that prints a message multiple times
class Thread1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Thread 1 is running");
            try {
                Thread.sleep(1000); // Sleep for 1 second
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

// Thread class 2 that prints a message multiple times
class Thread2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Thread 2 is running");
            try {
                Thread.sleep(1000); // Sleep for 1 second
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}
