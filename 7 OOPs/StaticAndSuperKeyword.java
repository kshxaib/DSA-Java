// Topic: Static and Super Keywords in Java

/*
📌 Static Keyword:
- Belongs to the class, not to object.
- Shared among all objects of the class.
- Accessed using ClassName.variable or directly if in same class.
- Example: static String SchoolName;
*/

public class StaticAndSuperKeyword {
    public static void main(String[] args) {
        // Object 1
        Student s1 = new Student();
        s1.setName("Khan Shoaib");

        // Setting static variable using object (not recommended but works)
        s1.SchoolName = "XYZ";

        // Object 2
        Student s2 = new Student();
        System.out.println("s2 SchoolName: " + s2.SchoolName); 
        // Output: XYZ → shared by all objects

        // ---------------- Using Super Keyword ----------------
        Dog dog = new Dog();
        dog.printInfo(); 
        // Output:
        // Animal eats
        // Dog barks
    }
}

// ---------------- Student Class (Static example) ----------------
class Student {
    String name;
    int rollNo;

    static String SchoolName; // Static → shared by all Student objects

    void setName(String name){
       this.name = name; 
    }

    String getName(){
        return this.name;
    }
}

// ---------------- Super Keyword Example ----------------
class Animal {
    void sound() {
        System.out.println("Animal makes sound");
    }

    void eat() {
        System.out.println("Animal eats");
    }
}

class Dog extends Animal {
    void sound() {
        System.out.println("Dog barks");
    }

    void printInfo() {
        super.eat();  // super → calls parent class method
        this.sound(); // current class method
    }
}

/*
📌 Quick Revision Notes:

1. Static Keyword:
   - Belongs to class, not object.
   - Shared across all instances.
   - Can be variables, methods, blocks, nested classes.

2. Super Keyword:
   - Refers to parent class object.
   - Used to:
     ✅ Access parent class methods
     ✅ Access parent class variables
     ✅ Call parent class constructor (super(...))
*/
