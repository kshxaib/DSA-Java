// Topic: Constructors and types of Constructor in Java

/*
📌 Definition:
A constructor in Java is a special method that is automatically called 
when an object of a class is created.
- It has the same name as the class.
- It does NOT have a return type (not even void).
- Used to initialize object values at the time of object creation.

Types:
    1. Non-parameterized Constructor
    2. Parameterized Constructor
    3. Copy Constructor (user-defined in Java)
*/

public class Constructors {
    public static void main(String[] args) {
        // 1️⃣ Non-parameterized Constructor
        Student s1 = new Student();
        System.out.println("Student1 Name: " + s1.name + ", Roll: " + s1.roll);

        // 2️⃣ Parameterized Constructor
        Student s2 = new Student("Khan Shoaib", 101);
        System.out.println("Student2 Name: " + s2.name + ", Roll: " + s2.roll);

        // 3️⃣ Copy Constructor
        Student s3 = new Student(s2); // copying s2 into s3
        System.out.println("Student3 Name: " + s3.name + ", Roll: " + s3.roll);
    }    
}

// ---------------- Student Class ----------------
class Student {
    String name;
    int roll;

    // 1️⃣ Non-parameterized Constructor
    Student() {
        this.name = "Default Name";
        this.roll = 0;
    }

    // 2️⃣ Parameterized Constructor
    Student(String name, int roll) {
        this.name = name;   // 'this' → current object
        this.roll = roll;
    }

    // 3️⃣ Copy Constructor (user-defined)
    Student(Student s) {
        this.name = s.name;
        this.roll = s.roll;
    }
}

/*
📌 Quick Revision Notes:
1. Constructor → Special method to initialize objects.
2. Types of Constructors:
   ✅ Non-parameterized → No arguments, assigns default values.
   ✅ Parameterized → Takes arguments and assigns custom values.
   ✅ Copy Constructor → Creates a new object by copying values of another object.
3. Constructor vs Method:
   - Constructor has same name as class, no return type.
   - Method can have any name and must have return type (void/int/etc).
4. 'this' keyword → refers to current object (used when local variable name = instance variable).
*/
