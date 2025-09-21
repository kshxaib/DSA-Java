// Topic: Types of Inheritance in Java
    
/*
📌 Inheritance in Java:
Inheritance allows a class (child) to acquire properties and methods from another class (parent).
- Parent class → Superclass
- Child class → Subclass
- Syntax: class Child extends Parent {}
*/

// ---------------- 1️⃣ Single Inheritance ----------------
class SingleInheritance {
    public static void main(String[] args) {
        System.out.println("----Single Inheritance----");
        Fish shark = new Fish();
        shark.eat();   // inherited method
        shark.swim();  // own method
    }
}

class Animal {
    void eat() {
        System.out.println("Animal eats");
    }
}

class Fish extends Animal {
    void swim() {
        System.out.println("Fish swims");
    }
}

// ---------------- 2️⃣ Multilevel Inheritance ----------------
class MultilevelInheritance {
    public static void main(String[] args) {
        System.out.println("\n----Multilevel Inheritance----");
        Shark bigShark = new Shark();
        bigShark.eat();    // inherited from Animal
        bigShark.swim();   // inherited from Fish
        bigShark.attack(); // own method
    }
}

class Fish2 extends Animal {
    void swim() {
        System.out.println("Fish2 swims");
    }
}

class Shark extends Fish2 {
    void attack() {
        System.out.println("Shark attacks");
    }
}

// ---------------- 3️⃣ Hierarchical Inheritance ----------------
class HierarchicalInheritance {
    public static void main(String[] args) {
        System.out.println("\n----Hierarchical Inheritance----");
        Dog dog = new Dog();
        Cat cat = new Cat();
        dog.eat();  // inherited from Animal
        cat.eat();  // inherited from Animal
        dog.bark();
        cat.meow();
    }
}

class Animal2 {
    void eat() {
        System.out.println("Animal2 eats");
    }
}

class Dog extends Animal2 {
    void bark() {
        System.out.println("Dog barks");
    }
}

class Cat extends Animal2 {
    void meow() {
        System.out.println("Cat meows");
    }
}

// ---------------- 4️⃣ Multiple Inheritance via Interface ----------------
class MultipleInheritance {
    public static void main(String[] args) {
        System.out.println("\n----Multiple Inheritance via Interface----");
        Bird parrot = new Bird();
        parrot.eat();   // from AnimalBehavior
        parrot.fly();   // from Flyable
    }
}

// Parent behavior as Interface
interface Flyable {
    void fly();
}

interface AnimalBehavior {
    void eat();
}

class Bird implements Flyable, AnimalBehavior {
    public void fly() {
        System.out.println("Bird flies");
    }

    public void eat() {
        System.out.println("Bird eats");
    }
}

/*
📌 Quick Revision Notes:
1. Single Inheritance → One child, one parent.
2. Multilevel Inheritance → Chain of inheritance (Grandparent → Parent → Child).
3. Hierarchical Inheritance → Multiple children, single parent.
4. Multiple Inheritance → Java uses interfaces to achieve this (no multiple classes inheritance).
5. Hybrid Inheritance → Combination of types (via interfaces).
*/
