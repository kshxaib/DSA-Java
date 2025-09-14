public class DiagonalSum {
    // Brute-force approach: Check all elements and add diagonals
    public static void printDiagonalSum(int matrix[][]){
        int sum = 0;

        // Traverse the entire matrix
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                // Primary diagonal condition (row == col)
                if(i == j){
                    sum += matrix[i][j]; 
                } 
                // Secondary diagonal condition (row + col == n-1)
                else if(i + j == matrix.length - 1){
                    sum += matrix[i][j];
                }
            }
        }

        System.out.printf("Sum of diagonal is: %d\n", sum);
    }

    // Optimized approach: O(n) instead of O(n^2)
    public static void printDiagonalSumOptimized(int matrix[][]){
        int sum = 0;
        
        for(int i = 0; i < matrix.length; i++){
            // Add primary diagonal element
            sum += matrix[i][i];

            // Index for secondary diagonal element
            int j = matrix.length - 1 - i;

            // Avoid double counting when i == j (middle element in odd-sized matrix)
            if(i != j){
                sum += matrix[i][j];
            }
        }

        System.out.printf("Sum of diagonal is: %d\n", sum);
    }
    
    public static void main(String[] args) {
        int matrix[][] = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };

        printDiagonalSum(matrix);           // Brute force O(n^2)
        printDiagonalSumOptimized(matrix); // Optimized O(n)
    }
}
