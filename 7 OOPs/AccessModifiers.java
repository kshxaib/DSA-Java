// AccessModifiers.java
// Topic: Access Modifiers in Java

public class AccessModifiers {
    public static void main(String[] args) {
        // Creating an object of BankAccount class
        BankAccount b1 = new BankAccount();

        // ✅ 'name' is public → accessible from anywhere (same class, other class, even outside package)
        b1.name = "Khan Shoaib";

        // ❌ 'password' is private → cannot be accessed directly (encapsulation)
        // b1.password = "123456789";  // ❌ This will give error

        // ✅ We can set password using a public method (setter)
        b1.setPassword("123456789");
    }
}

// ---------------- BankAccount Class ----------------
class BankAccount {
    // public → accessible from anywhere
    public String name;

    // private → only accessible inside this class
    private String password;

    // Public setter method to set private variable 'password'
    public void setPassword(String newPwd){
        password = newPwd;
    }
}

/*
📌 Quick Revision Notes on Access Modifiers:
1. public → accessible everywhere (same class, same package, different package).
2. private → accessible only within the same class.
3. default (no modifier) → accessible within the same package only.
4. protected → accessible in same package + subclasses (even in different package).

👉 Use private for sensitive data (e.g., password, account number).
👉 Use getters/setters (public methods) to access private data (Encapsulation principle).
*/
