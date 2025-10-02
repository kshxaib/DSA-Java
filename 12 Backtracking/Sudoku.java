// Problem: Solve a Sudoku puzzle using Backtracking
/*
📌 Problem Statement:
We are given a partially filled 9x9 Sudoku grid. The task is to fill
all empty cells (represented by 0) such that:
1. Each row contains digits 1–9 without repetition.
2. Each column contains digits 1–9 without repetition.
3. Each 3x3 subgrid contains digits 1–9 without repetition.

👉 Idea (Backtracking):
- Find the first empty cell (0).
- Try placing digits 1–9 in that cell.
- For each digit, check if it's safe (row, column, and 3x3 box).
- If safe → place digit → recursively solve next cells.
- If placing a digit leads to no solution → backtrack (reset to 0).
- Continue until either solved or no valid configuration exists.
*/

public class Sudoku {

    // Function to check if placing "digit" at sudoku[row][column] is safe
    public static boolean isSafe(int sudoku[][], int row, int column, int digit) {
        // ✅ Check column
        for (int i = 0; i < 9; i++) {
            if (sudoku[i][column] == digit) {
                return false; // same digit already present in column
            }
        }

        // ✅ Check row
        for (int j = 0; j < 9; j++) {
            if (sudoku[row][j] == digit) {
                return false; // same digit already present in row
            }
        }

        // ✅ Check 3x3 subgrid
        int startingRow = (row / 3) * 3;      // top-left corner row of subgrid
        int startingColumn = (column / 3) * 3; // top-left corner col of subgrid

        for (int i = startingRow; i < startingRow + 3; i++) {
            for (int j = startingColumn; j < startingColumn + 3; j++) {
                if (sudoku[i][j] == digit) {
                    return false; // same digit already present in 3x3 box
                }
            }
        }

        return true; // Safe to place digit
    }

    // Recursive Backtracking Solver
    public static boolean sudokuSolver(int sudoku[][], int row, int column) {
        // ✅ Base case: If row = 9, board is filled successfully
        if (row == 9) {
            return true;
        }

        // ✅ Calculate next cell (move left-to-right, then top-to-bottom)
        int nextRow = row;
        int nextColumn = column + 1;
        if (column + 1 == 9) {   // if end of row, move to next row
            nextRow = row + 1;
            nextColumn = 0;
        }

        // ✅ Skip already filled cells
        if (sudoku[row][column] != 0) {
            return sudokuSolver(sudoku, nextRow, nextColumn);
        }

        // ✅ Try digits 1–9 in empty cell
        for (int digit = 1; digit <= 9; digit++) {
            if (isSafe(sudoku, row, column, digit)) { // safe placement
                sudoku[row][column] = digit;          // place digit

                // Recursively solve rest of the grid
                if (sudokuSolver(sudoku, nextRow, nextColumn)) {
                    return true;
                }

                // ❌ Backtrack: remove digit if it doesn’t lead to solution
                sudoku[row][column] = 0;
            }
        }

        // No valid digit → return false
        return false;
    }

    // Function to print Sudoku board
    public static void printSudoku(int sudoku[][]) {
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0 && i != 0) {
                System.out.println("------+-------+------"); // visual separator
            }
            for (int j = 0; j < 9; j++) {
                if (j % 3 == 0 && j != 0) {
                    System.out.print("| "); // column separator
                }
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        int sudoku[][] = {
                { 0, 0, 8, 0, 0, 0, 0, 0, 0 },
                { 4, 9, 0, 1, 5, 7, 0, 0, 2 },
                { 0, 0, 3, 0, 0, 4, 1, 9, 0 },
                { 1, 8, 5, 0, 6, 0, 0, 2, 0 },
                { 0, 0, 0, 0, 2, 0, 0, 6, 0 },
                { 9, 6, 0, 4, 0, 5, 3, 0, 0 },
                { 0, 3, 0, 0, 7, 2, 0, 0, 4 },
                { 0, 4, 9, 0, 3, 0, 0, 5, 7 },
                { 8, 2, 7, 0, 0, 9, 0, 1, 3 }
        };

        // Solve Sudoku
        if (sudokuSolver(sudoku, 0, 0)) {
            System.out.println("Solution exists:");
            printSudoku(sudoku);
        } else {
            System.out.println("No solution exists.");
        }
    }
}

/*
📌 Dry Run (Steps):
1. Start at (0,0). Empty → try digits 1–9.
2. Place valid digit, move to next cell.
3. If at some point no digit fits → backtrack.
4. Continue until either all cells filled → solution OR no possibility → no solution.

✅ Time Complexity:
- O(9^(n*n)) in worst case (all cells empty).
- But with pruning (isSafe), it is much faster in practice.

✅ Space Complexity:
- O(n*n) for board.
- O(n*n) recursion stack in worst case.
*/
