// Recursion in Java

/* 
📌 Definition:
Recursion is a process where a method (function) 
calls itself directly or indirectly to solve a problem.

👉 Mostly used when a problem can be divided into 
smaller sub-problems of the same type.
*/

public class Recursion {
    public static void main(String[] args) {
        int num = 5;

        // Example 1 → Factorial using recursion
        System.out.println("Factorial of " + num + " = " + factorial(num));

        // Example 2 → Fibonacci using recursion
        System.out.println("Fibonacci of " + num + " = " + fibonacci(num));
    }

    // ---------------- Factorial Example ----------------
    static int factorial(int n) {
        // Base Case (stopping condition)
        if (n == 0 || n == 1) {
            return 1;
        }
        // Recursive Call (method calling itself)
        return n * factorial(n - 1);
    }

    // ---------------- Fibonacci Example ----------------
    static int fibonacci(int n) {
        // Base Cases
        if (n == 0) return 0;
        if (n == 1) return 1;

        // Recursive Call
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}

/*
📌 Quick Revision Notes:

1. Recursion = Function calling itself.
2. Must have a Base Case → otherwise infinite loop → StackOverflowError.
3. Each recursive call → new frame is added in Call Stack.
4. Examples:
   ✅ Factorial → n * factorial(n-1)
   ✅ Fibonacci → fib(n-1) + fib(n-2)
   ✅ Tree/Graph traversal, Divide & Conquer algorithms (MergeSort, QuickSort).
5. Pros:
   - Code becomes simple and elegant.
6. Cons:
   - Uses more memory (stack calls).
   - Sometimes slower than iterative approach.
*/
