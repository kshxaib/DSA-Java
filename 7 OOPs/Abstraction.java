// Topic: Abstraction in Java

/*
📌 Definition:
Hiding all the unnecessary details and showing only the 
important features to the user is called Abstraction.

- Helps to focus on what an object does, not how it does it.
- Achieved in Java using:
   1️⃣ Abstract Classes
   2️⃣ Interfaces
*/

// ---------------- 1️⃣ Using Abstract Class ----------------
abstract class Vehicle {
    abstract void start(); // abstract method → no body, only declaration

    void fuel() { // regular method → can have body
        System.out.println("Vehicle is fueled");
    }
}

class Car extends Vehicle {
    void start() {
        System.out.println("Car starts with key");
    }
}

// ---------------- 2️⃣ Using Interface ----------------
interface RemoteControl {
    void turnOn();
    void turnOff();
}

class TV implements RemoteControl {
    public void turnOn() {
        System.out.println("TV is turned ON");
    }

    public void turnOff() {
        System.out.println("TV is turned OFF");
    }
}

// ---------------- Main Class ----------------
public class Abstraction {
    public static void main(String[] args) {
        // Abstract class example
        Vehicle myCar = new Car(); // abstraction → user only knows start()
        myCar.start();
        myCar.fuel(); 
        System.out.println();

        // Interface example
        RemoteControl myTV = new TV();
        myTV.turnOn();
        myTV.turnOff();
    }
}

/*
📌 Quick Revision Notes:
1. Abstraction = Hide unnecessary details, show essential features.
2. Abstract Class → contains abstract methods (without body) + regular methods.
3. Interface → contains only method declarations -blueprint of a class (Java 8+ can have default methods too).
*/
