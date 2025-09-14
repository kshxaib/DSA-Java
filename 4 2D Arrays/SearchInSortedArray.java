public class SearchInSortedArray {
    public static boolean search(int matrix[][], int key){
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j] == key){
                    System.out.printf("Found key at (%d %d)", i, j);
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean stairCaseSearch(int matrix[][], int key){
        int row = 0, col = matrix.length -1;

        while(row < matrix.length && col >= 0){
            if(matrix[row][col] == key){
                System.out.printf("Found key at (%d %d)", row, col);
                return true;
            } else if (key < matrix[row][col]){
                col--;
            } else {
                row++;
            }
        }
        System.out.print("Key not found.");
        return false;
    }

    public static void main(String[] args) {
        int matrix[][] = {
            {10, 20, 30, 40},
            {15, 25, 35, 45},
            {27, 29, 37, 48},
            {32, 33, 39, 50}
        };
        int key = 33;

        System.out.println(search(matrix, key));

        stairCaseSearch(matrix, key);
    }
}
