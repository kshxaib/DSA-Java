// Topic: Shallow Copy vs Deep Copy in Java

/*
📌 Shallow Copy:
    - Copies only the reference of object, not actual data.
    - Both objects refer to the SAME memory location.
    - Change in one object reflects in the other.
    - Done using assignment (=).

📌 Deep Copy:
    - Copies actual data into a new object.
    - Both objects are independent (separate memory).
    - Change in one object does NOT affect the other.
    - Done using copy constructor / cloning.

👉 Used in Encapsulation & Object Cloning.
*/

public class ShallowAndDeepCopy {
    public static void main(String[] args) {
        // ---------- Shallow Copy Example ----------
        Student s1 = new Student("Khan Shoaib", 22);
        
        // Shallow Copy → new reference, same object
        Student s2 = s1;  

        // Changing s2 will also affect s1
        s2.name = "Changed Name";
        System.out.println("Shallow Copy:");
        System.out.println("s1 Name: " + s1.name); // Changed
        System.out.println("s2 Name: " + s2.name); // Changed

        // ---------- Deep Copy Example ----------
        Student s3 = new Student(s1);  // Copy Constructor

        s3.name = "Deep Copy Name";  // only s3 changes
        System.out.println("\nDeep Copy:");
        System.out.println("s1 Name: " + s1.name); // Unchanged
        System.out.println("s3 Name: " + s3.name); // Changed
    }
}

// ---------------- Student Class ----------------
class Student {
    String name;
    int age;

    // Parameterized Constructor
    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Copy Constructor (Deep Copy)
    Student(Student other) {
        this.name = other.name;
        this.age = other.age;
    }
}

/*
📌 Quick Revision Notes:
1. Shallow Copy:
   - Same memory reference.
   - Faster but risky (changes reflect everywhere).
   - Example: Student s2 = s1;

2. Deep Copy:
   - Different memory reference, independent objects.
   - Safe but slightly slower.
   - Example: using copy constructor or clone() method.

Destructor: A destructor is a method that is automatically called when 
an object is destroyed or garbage collected.
*/
