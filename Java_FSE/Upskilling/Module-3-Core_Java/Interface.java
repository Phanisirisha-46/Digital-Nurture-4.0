// Define the Playable interface
interface Playable {
    // Method signature for play
    void play();
}

// Class Guitar implementing the Playable interface
class Guitar implements Playable {
    // Implement the play method for Guitar
    @Override
    public void play() {
        System.out.println("Playing the guitar");
    }
}

// Class Piano implementing the Playable interface
class Piano implements Playable {
    // Implement the play method for Piano
    @Override
    public void play() {
        System.out.println("Playing the piano");
    }
}

public class Interface {
    public static void main(String[] args) {
        // Instantiate the Guitar and Piano objects
        Playable guitar = new Guitar();
        Playable piano = new Piano();

        // Call the play method on both objects
        guitar.play();  // Outputs: Playing the guitar
        piano.play();   // Outputs: Playing the piano
    }
}
