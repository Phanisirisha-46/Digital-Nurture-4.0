// Base class Animal
class Animal {
    // Method in the Animal class
    public void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

// Subclass Dog that inherits from Animal
class Dog extends Animal {
    // Override the makeSound method in the Dog class
    @Override
    public void makeSound() {
        System.out.println("Bark");
    }
}

public class Inheritance {
    public static void main(String[] args) {
        // Create an object of the Animal class
        Animal animal = new Animal();
        animal.makeSound();  // Outputs: Animal makes a sound

        // Create an object of the Dog class
        Dog dog = new Dog();
        dog.makeSound();  // Outputs: Bark
    }
}
