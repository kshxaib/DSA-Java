// Topic: Getters, Setters & 'this' keyword in Java

// ✅ 'this' keyword → refers to the current object of the class
// 👉 Commonly used when local variable names are same as instance variables

public class GettersAndSetters {
    public static void main(String[] args) {
        // Create object of Student class
        Student s1 = new Student();

        // Using setter methods to set values
        s1.setName("Khan Shoaib");
        s1.setAge(22);

        // Using getter methods to fetch values
        System.out.println("Name: " + s1.getName());
        System.out.println("Age: " + s1.getAge());
    }
}

// ---------------- Student Class ----------------
class Student {
    // Private fields (instance variables)
    private String name;
    private int age;

    // ----- Setter Methods -----
    // 'this' is used to differentiate between instance variable & parameter
    public void setName(String name) {
        this.name = name;  
        // left side → instance variable of object
        // right side → method parameter
    }

    public void setAge(int age) {
        if(age > 0) {
            this.age = age;  
        }
    }

    // ----- Getter Methods -----
    public String getName() {
        return this.name; // 'this' optional, but can be used for clarity
    }

    public int getAge() {
        return this.age; // same as return age;
    }
}

/*
📌 Quick Revision Notes:
1. this keyword:
   - Refers to the current object.
   - Used when local variable names (parameters) are same as instance variables.
   - Helps avoid ambiguity.

2. Getter → returns value of private variable.
3. Setter → sets/updates value of private variable.
4. Encapsulation → making variables private + accessing them via getters/setters.
*/
