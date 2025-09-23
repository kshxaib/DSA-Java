// Program to calculate x^n using recursion
public class printXPowerN {
    
    // ---------------- Simple Recursion ----------------
    // Recursive function to calculate x^n
    public static int printPower(int x, int n){
        // Base case: any number raised to power 0 = 1
        if(n == 0){
            return 1;
        }

        // Recursive step: x^n = x * x^(n-1)
        return x * printPower(x, n-1);
    }

    // ---------------- Optimized Recursion ----------------
    // Using Exponentiation by Squaring → reduces O(n) → O(log n)
    public static int printPowerOptimized(int x, int n){
        // Base case
        if(n == 0){
            return 1;
        }

        // Recursive call for half power
        int halfPower = printPowerOptimized(x, n / 2);

        // If n is even → multiply half powers
        if(n % 2 == 0){
            return halfPower * halfPower;
        } 
        // If n is odd → multiply half powers and x
        else {
            return x * halfPower * halfPower;
        }
    }

    public static void main(String[] args) {
        System.out.println("Simple Recursion: " + printPower(2, 10));  
        System.out.println("Optimized Recursion: " + printPowerOptimized(2, 10));
    }
}

/*
📌 Dry Run (Simple Recursion):
x = 2, n = 4
printPower(2,4) = 2 * printPower(2,3)
                = 2 * (2 * printPower(2,2))
                = 2 * (2 * (2 * printPower(2,1)))
                = 2 * (2 * (2 * (2 * printPower(2,0))))
                = 16

✅ Time Complexity (Simple Recursion): O(n)
✅ Space Complexity (Simple Recursion): O(n) → recursion stack

📌 Dry Run (Optimized Recursion):
x = 2, n = 10
printPowerOptimized(2,10) → calculates halfPower = printPowerOptimized(2,5)
→ calculates halfPower = printPowerOptimized(2,2)
→ calculates halfPower = printPowerOptimized(2,1)
→ base case n=0 reached → returns 1
Backtracking:
2^1 = 2
2^2 = 4
2^5 = 32
2^10 = 1024

✅ Time Complexity (Optimized Recursion): O(log n)
✅ Space Complexity (Optimized Recursion): O(log n) → recursion stack
*/
