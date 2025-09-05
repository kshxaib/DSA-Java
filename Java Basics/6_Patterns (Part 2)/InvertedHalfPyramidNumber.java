public class InvertedHalfPyramidNumber {
    public static void printInvertedHalfPyramidNumber(int rows){
        int number = 1;
        for(int i=1; i<=rows; i++){
            for(int j=1; j<=rows-i+1; j++){
                System.out.print(number);
                number++;
            }
            number = 1;
            System.out.println();
        }
    }

    public static void main(String args[]){
        printInvertedHalfPyramidNumber(5);
    }    
}
