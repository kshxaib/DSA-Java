import java.util.*;

public class Creation {
    public static void main(String args[]) {
        int matrix[][] = new int[3][3];
        Scanner sc = new Scanner(System.in);

        // Input
        for (int i = 0; i < matrix.length; i++) { // number of rows
            for (int j = 0; j < matrix[i].length; j++) { // number of cols
                matrix[i][j] = sc.nextInt();
            }
        }

        // Output
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
