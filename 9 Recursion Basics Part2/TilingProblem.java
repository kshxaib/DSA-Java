// Problem: Tiling Problem (2 x n board with 2 x 1 tiles)

/*
📌 Problem Statement:
You are given a 2 x n board (floor) and 2 x 1 tiles.
You need to count the number of ways to tile the board.

👉 Choices:
- Place 1 vertical tile → reduces problem to size (n-1)
- Place 2 horizontal tiles → reduces problem to size (n-2)

So recurrence relation:
    f(n) = f(n-1) + f(n-2)
(Which is same as Fibonacci)
*/

public class TilingProblem {
    
    // Recursive function
    public static int tilingProblem(int n){
        // Base cases
        if(n == 0 || n == 1){
            return 1;  // Only 1 way to arrange
        }

        // Recursive calls
        int fnm1 = tilingProblem(n-1);  // Place vertical tile
        int fnm2 = tilingProblem(n-2);  // Place 2 horizontal tiles

        int totalWays = fnm1 + fnm2;
        return totalWays;
    }

    public static void main(String[] args) {
        System.out.println(tilingProblem(6));  
        // Expected Output → 13
    }
}

/*
📌 Dry Run (n=6):
    f(6) = f(5) + f(4)
    f(5) = f(4) + f(3)
    f(4) = f(3) + f(2)
    f(3) = f(2) + f(1)
    f(2) = f(1) + f(0)

    f(0) = 1
    f(1) = 1
    f(2) = 1 + 1 = 2
    f(3) = 2 + 1 = 3
    f(4) = 3 + 2 = 5
    f(5) = 5 + 3 = 8
    f(6) = 8 + 5 = 13

✅ Final Answer for n=6 → 13 ways

✅ Time Complexity: O(2^n) (exponential recursion, like Fibonacci)
✅ Space Complexity: O(n) (recursion stack)

⚡ Optimization:
We can use DP (memoization or tabulation) to reduce complexity to O(n).
*/
