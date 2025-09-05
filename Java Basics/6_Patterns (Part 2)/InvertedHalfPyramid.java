public class InvertedHalfPyramid {
    public static void printInvertedHalfPyramid(int rows){
        for(int i=1; i<=rows; i++){
            for(int j=1; j<=(rows -i); j++){
                System.out.print(" ");
            }
            for(int k=1; k<=i; k++){
                System.out.print("*");
            }
            System.out.println();
        }
    }  
    
    public static void main(String args[]){
        printInvertedHalfPyramid(4);
    }
}
