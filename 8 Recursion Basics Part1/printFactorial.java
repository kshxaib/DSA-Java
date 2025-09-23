// printFactorial.java
// Topic: Recursion - Factorial of a number

public class printFactorial {

    // Recursive function to find factorial of n
    public static int findFac(int n) {
        // Base Case → factorial(1) = 1
        if (n == 1) {
            return 1;
        }

        // Recursive Case → n! = n * (n-1)!
        return n * findFac(n - 1);
    }

    public static void main(String[] args) {
        // Example → factorial of 5
        System.out.print(findFac(5));
    }
}

/*
📌 Dry Run for n = 5:
findFac(5) 
= 5 * findFac(4)
= 5 * (4 * findFac(3))
= 5 * (4 * (3 * findFac(2)))
= 5 * (4 * (3 * (2 * findFac(1))))
= 5 * 4 * 3 * 2 * 1
= 120

Output: 120

------------------------------------------------
📌 Complexity Analysis:

1. Time Complexity: O(n)
   - Function is called n times until base case is reached.

2. Space Complexity: O(n)
   - Due to recursive call stack storing n frames.

------------------------------------------------
📌 Quick Revision Notes:
- Factorial (n!) = n × (n-1) × (n-2) × ... × 1
- Recursion:
   ✅ Base Case → when n == 1, return 1
   ✅ Recursive Case → n * factorial(n-1)
- Without base case → infinite recursion → StackOverflowError
*/
