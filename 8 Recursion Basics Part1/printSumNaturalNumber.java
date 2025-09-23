// printSumNaturalNumber.java
// Topic: Recursion - Sum of first n natural numbers

public class printSumNaturalNumber {

    // Recursive function to calculate sum of natural numbers
    public static int sum(int n) {
        // Base Case → when n = 1
        if (n == 1) {
            return 1;
        }

        // Recursive Case → sum(n) = n + sum(n-1)
        return n + sum(n - 1);
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.print("Sum of first " + n + " natural numbers = " + sum(n));
    }
}

/*
📌 Dry Run for n = 4:
sum(4) 
= 4 + sum(3)
= 4 + (3 + sum(2))
= 4 + (3 + (2 + sum(1)))
= 4 + 3 + 2 + 1
= 10

Output (for n=10): 55

------------------------------------------------
📌 Complexity Analysis:

1. Time Complexity: O(n)
   - Function is called n times until base case is reached.

2. Space Complexity: O(n)
   - Because of recursive call stack storing n frames.

------------------------------------------------
📌 Quick Revision Notes:
- Problem → Find sum of first n natural numbers.
- Formula approach → n * (n+1) / 2  (better in efficiency: O(1))
- Recursive approach:
   ✅ Base Case → n == 1 → return 1
   ✅ Recursive Case → n + sum(n-1)
- Example: sum(5) = 5 + 4 + 3 + 2 + 1 = 15
*/
