// Topic: Polymorphism in Java

/*
📌 Definition:
Polymorphism means "many forms" — the ability of an object to take multiple forms.
- Two types in Java:
  1️⃣ Compile-time Polymorphism (Method Overloading)
  2️⃣ Run-time Polymorphism (Method Overriding)
*/

// ---------------- 1️⃣ Compile-time Polymorphism (Method Overloading) ----------------
class CompileTime {
    public static void main(String[] args) {
        Calculator calc = new Calculator();

        // Method Overloading → same method name, different parameters
        System.out.println("Sum (2 ints): " + calc.add(5, 10));           // int, int
        System.out.println("Sum (3 ints): " + calc.add(5, 10, 15));       // int, int, int
        System.out.println("Sum (2 doubles): " + calc.add(5.5, 10.5));    // double, double
    }
}

class Calculator {
    // Method with 2 int parameters
    int add(int a, int b) {
        return a + b;
    }

    // Method with 3 int parameters
    int add(int a, int b, int c) {
        return a + b + c;
    }

    // Method with 2 double parameters
    double add(double a, double b) {
        return a + b;
    }
}

// ---------------- 2️⃣ Run-time Polymorphism (Method Overriding) ----------------
class RunTime {
    public static void main(String[] args) {
        Animal a;

        a = new Dog(); // Parent reference, child object
        a.sound();     // Calls overridden method in Dog class → Run-time polymorphism

        a = new Cat();
        a.sound();     // Calls overridden method in Cat class
    }
}

// Parent class
class Animal {
    void sound() {
        System.out.println("Animal makes sound");
    }
}

// Child class 1
class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}

// Child class 2
class Cat extends Animal {
    @Override
    void sound() {
        System.out.println("Cat meows");
    }
}

/*
📌 Quick Revision Notes:
1. Polymorphism = One entity, many forms.
2. Compile-time Polymorphism → Method Overloading
   - Same method name, different parameters
   - Resolved during compilation
3. Run-time Polymorphism → Method Overriding
   - Same method signature, different implementation in child class
   - Resolved at runtime (dynamic method dispatch)
4. Overriding requires:
   - Inheritance
   - Same method signature
   - Parent reference, child object
5. Keywords:
   - @Override → optional but recommended for clarity
*/
