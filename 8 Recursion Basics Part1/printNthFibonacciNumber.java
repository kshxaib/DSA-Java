// Program to find the nth Fibonacci number using recursion
public class printNthFibonacciNumber {

    // Recursive function to calculate nth Fibonacci number
    public static int printFibo(int n){
        // Base case: Fibonacci(0) = 0
        if(n == 0){
            return 0;
        }

        // Base case: Fibonacci(1) = 1
        if(n == 1){
            return 1;
        }

        // Recursive case: F(n) = F(n-1) + F(n-2)
        return printFibo(n-1) + printFibo(n-2);
    }

    public static void main(String[] args) {
        // Example: Find the 6th Fibonacci number
        System.out.println(printFibo(6));
    }
}

/*
📌 Fibonacci Sequence:
    F(0) = 0
    F(1) = 1
    F(2) = 1
    F(3) = 2
    F(4) = 3
    F(5) = 5
    F(6) = 8

➡️ Output for n = 6 → 8

📌 Dry Run for n = 4:
    printFibo(4) = printFibo(3) + printFibo(2)
                 = (printFibo(2) + printFibo(1)) + (printFibo(1) + printFibo(0))
                 = ((printFibo(1) + printFibo(0)) + 1) + (1 + 0)
                 = ((1 + 0) + 1) + (1 + 0)
                 = 3

✅ Time Complexity: O(2^n) → exponential, since it recalculates values many times  
✅ Space Complexity: O(n) → because of recursive call stack depth  
*/
