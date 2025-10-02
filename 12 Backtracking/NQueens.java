// Problem: Solve the N-Queens problem using backtracking
/*
📌 Problem Statement:
Place N queens on an N×N chessboard such that no two queens attack each other.  
Queens can attack vertically, horizontally, and diagonally.

👉 Idea (Backtracking):
- Place queens row by row.
- At each row, try placing a queen in each column.
- Before placing, check if it's safe using the `isSafe` function.
- If safe → place queen → move to next row.
- If not safe or after exploring, backtrack (remove queen).
*/

public class NQueens {

    // Function to check if placing a queen at (row, column) is safe
    public static boolean isSafe(char board[][], int row, int column){
        // 🔹 Check vertically upwards
        for (int i = row-1; i >=0; i--) {
            if(board[i][column] == 'Q'){
                return false; // another queen in same column
            }
        }

        // 🔹 Check upper-left diagonal
        for(int i=row-1, j=column-1; i>=0 && j>=0; i--,j--){
            if(board[i][j] == 'Q'){
                return false; // queen on left diagonal
            }
        }

        // 🔹 Check upper-right diagonal
        for(int i=row-1, j=column+1; i>=0 && j<board.length; i--,j++){
            if(board[i][j] == 'Q'){
                return false; // queen on right diagonal
            }
        }

        return true; // ✅ Safe to place queen
    }

    // Recursive function to place queens row by row
    public static void nQueens(char board[][], int row){
        // ✅ Base case: if all rows filled → valid arrangement found
        if(row == board.length){
            printBoard(board); // Print the board configuration
            count++;           // Increase solution count
            return;
        }

        // 🔹 Try placing a queen in each column of the current row
        for(int j=0; j<board.length; j++){
            if(isSafe(board, row, j)) {   // check safety
                board[row][j] = 'Q';      // place queen
                nQueens(board, row+1);    // move to next row (recursive call)
                board[row][j] = 'X';      // backtrack → remove queen
            }
        }
    }

    // 🔹 To count total number of solutions
    static int count = 0;

    // Function to print the chessboard configuration
    public static void printBoard(char board[][]){
        System.out.println("------ Chess Board ------");
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n=5;  // 🔹 Board size (5x5)
        char board[][] = new char[n][n];

        // Initialize board with 'X' (empty cells)
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j] = 'X';
            }
        }

        // Start recursion from the 0th row
        nQueens(board, 0);
        System.out.println("Total ways to solve n queens: " + count);
    }
}

/*
📌 Dry Run (n = 4):

1. Row 0 → Try each column.
2. Row 1 → Place queen in safe position.
3. Row 2 → Repeat safety check.
4. Row 3 → If placed → print board.
5. Backtrack & try other positions.

✅ Output (for n=4):
------ Chess Board ------
X Q X X
X X X Q
Q X X X 
X X Q X

------ Chess Board ------
X X Q X
Q X X X
X X X Q
X Q X X

---
📊 Time Complexity:
- O(N!) → since we explore all possible arrangements.

📊 Space Complexity:
- O(N^2) → board
- O(N) → recursion stack depth
*/
