public class Question3 {
    public static void transposeOfMatrix(int matrix[][]){
        int rows = matrix.length;
        int colums = matrix[0].length;

        int transpose [][] = new int[colums][rows];
        for(int i=0; i<rows; i++){
            for(int j=0; j<colums; j++){
                transpose[j][i] = matrix[i][j];
            }
        }
    }

    public static void main(String args[]){
        int matrix[][] = {
            {1,2,3}, 
            {4,5,6}
        };
        transposeOfMatrix(matrix);
    }
}
