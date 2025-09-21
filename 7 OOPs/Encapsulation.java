// Topic: Encapsulation in Java

/*
📌 Definition:
Encapsulation is defined as the wrapping up of data (variables) and methods 
(functions) into a single unit (class). 
It also implements data hiding by making variables private 
and providing controlled access through public getters and setters.
*/

public class Encapsulation {
    public static void main(String[] args) {
        // Creating object of BankAccount
        BankAccount acc1 = new BankAccount();

        // Setting values using setter methods (not direct access)
        acc1.setAccountHolder("Khan Shoaib");
        acc1.setBalance(5000);

        // Getting values using getter methods
        System.out.println("Account Holder: " + acc1.getAccountHolder());
        System.out.println("Balance: " + acc1.getBalance());

        // Updating balance safely
        acc1.deposit(2000);
        System.out.println("Updated Balance: " + acc1.getBalance());

        acc1.withdraw(3000);
        System.out.println("Balance after withdrawal: " + acc1.getBalance());
    }
}

// ---------------- Encapsulated Class ----------------
class BankAccount {
    // private fields → hidden from outside (data hiding)
    private String accountHolder;
    private double balance;

    // ----- Setter Methods (write access) -----
    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder; // 'this' → current object
    }

    public void setBalance(double balance) {
        if(balance >= 0) {
            this.balance = balance;
        }
    }

    // ----- Getter Methods (read access) -----
    public String getAccountHolder() {
        return this.accountHolder;
    }

    public double getBalance() {
        return this.balance;
    }

    // ----- Business Methods (data handling) -----
    public void deposit(double amount) {
        if(amount > 0) {
            this.balance += amount;
        }
    }

    public void withdraw(double amount) {
        if(amount > 0 && amount <= balance) {
            this.balance -= amount;
        } else {
            System.out.println("Insufficient balance!");
        }
    }
}

/*
📌 Quick Revision Notes:
1. Encapsulation = Data (fields) + Methods (behaviors) under one unit (class).
2. Data hiding → use 'private' for variables.
3. Controlled access → use 'public' getters and setters.
4. Advantages:
   ✅ Better security of data
   ✅ Code reusability & maintainability
   ✅ Control over data (validation before setting values)
*/
