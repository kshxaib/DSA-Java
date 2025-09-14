public class SpiralMatrix {
    // Function to print matrix elements in spiral order
    public static void printSpiral(int matrix[][]){
        // Define boundaries of the matrix
        int startRow = 0;
        int endRow = matrix.length - 1;         // last row index
        int startCol = 0;
        int endCol = matrix[0].length - 1; // last column index

        // Loop until we cover all rows and columns
        while(startRow <= endRow && startCol <= endCol){

            // 1️⃣ Traverse Top Row (left → right)
            for(int j = startCol; j <= endCol; j++){
                System.out.print(matrix[startRow][j] + " ");
            }

            // 2️⃣ Traverse Right Column (top → bottom)
            for(int i = startRow + 1; i <= endRow; i++){
                System.out.print(matrix[i][endCol] + " ");
            }

            // 3️⃣ Traverse Bottom Row (right → left) [only if more than 1 row left]
            for(int j = endCol - 1; j >= startCol; j--){
                if(startRow == endRow){ // avoid double printing same row
                    break;
                }
                System.out.print(matrix[endRow][j] + " ");
            }

            // 4️⃣ Traverse Left Column (bottom → top) [only if more than 1 col left]
            for(int i = endRow - 1; i >= startRow + 1; i--){
                if(startCol == endCol){ // avoid double printing same column
                    break;
                }
                System.out.print(matrix[i][startCol] + " ");
            }

            // Move boundaries inward for next spiral layer
            startRow++;
            endRow--;
            startCol++;
            endCol--;
        }
    }

    public static void main(String[] args) {
        int matrix[][] = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };
        
        printSpiral(matrix);
        // Time Complexity: O(n × m) → O(n²) for square matrix.
        // Space Complexity: O(1) (ignoring output).
    }
}
