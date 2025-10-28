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
        if (n == 0) {
            return 1;
        }

        if(n == 1 || n == 2 || n == 3){
            return n;  // Only 1 way to arrange
        }
        return tilingProblem(n-1) + tilingProblem(n-2);
    }

    public static void main(String[] args) {
        System.out.println(tilingProblem(6));  
    }
}
