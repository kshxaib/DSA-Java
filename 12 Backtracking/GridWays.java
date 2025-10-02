// Problem: Count number of ways to reach bottom-right corner of a grid
/*
📌 Problem Statement:
We are given an n×m grid. Starting from the top-left cell (0,0), 
you can only move:
   - Down (i+1, j)
   - Right (i, j+1)
Find the total number of unique paths to reach the bottom-right cell (n-1, m-1).

👉 Idea (Recursion):
- If we reach the destination → count 1 way.
- If we go out of bounds → count 0 ways.
- Otherwise → total ways = ways moving down + ways moving right.
*/

public class GridWays {

    // Recursive function to count paths
    public static int gridWays(int i, int j, int n, int m){
        // ✅ Base case 1: Reached bottom-right cell
        if(i == n-1 && j == m-1){
            return 1;
        }

        // ✅ Base case 2: Out of grid boundaries
        if(i == n || j == m){
            return 0;
        }

        // 🔹 Move down (i+1, j)
        int w1 = gridWays(i+1, j, n, m);

        // 🔹 Move right (i, j+1)
        int w2 = gridWays(i, j+1, n, m);

        // Total paths from current cell = down + right
        return w1 + w2;
    }

    public static void main(String[] args) {
        int n = 3, m = 3; // 3x3 grid
        System.out.println(gridWays(0, 0, n, m));
        // Expected output: 6 (paths in a 3x3 grid)
    }
}

/*
📌 Dry Run (n=3, m=3):

Start (0,0):
 → Down → (1,0) → (2,0) → (2,1) → (2,2) ✅
 → Down → (1,0) → (1,1) → (1,2) → (2,2) ✅
 → ...
 → Right → (0,1) → (0,2) → (1,2) → (2,2) ✅
 → ...

Total = 6 unique paths.

---
📊 Time Complexity:
- O(2^(n+m)) → exponential, since each cell branches into 2 recursive calls.

📊 Space Complexity:
- O(n+m) → recursion stack depth.
*/
