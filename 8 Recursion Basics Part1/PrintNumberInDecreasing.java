// Topic: Recursion - Print numbers in decreasing order

public class PrintNumberInDecreasing {

    // Recursive method to print numbers in decreasing order
    public static void printNumber(int n) {
        // Base Case → stopping condition
        if (n == 1) {
            System.out.println(n); // print 1 and stop recursion
            return;
        }

        // Work → print current number
        System.out.println(n);

        // Recursive Call → function calls itself with n-1
        printNumber(n - 1);
    }

    public static void main(String[] args) {
        // Function call → prints numbers from 10 to 1
        printNumber(10);
    }
}

/*
📌 Dry Run for n = 3
printNumber(3) → prints 3 → calls printNumber(2)
printNumber(2) → prints 2 → calls printNumber(1)
printNumber(1) → prints 1 → returns

Output: 3 2 1

------------------------------------------------
📌 Complexity Analysis:

1. Time Complexity: O(n)
   - Each call prints one number
   - Total n calls → O(n)

2. Space Complexity: O(n)
   - Due to function call stack
   - At maximum, n function calls will be stored

------------------------------------------------
📌 Quick Revision Notes:
- Recursion = method calling itself.
- Must include Base Case to stop recursion.
- Here base case: if(n == 1).
- Without base case → infinite recursion → StackOverflowError.
*/
