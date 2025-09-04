// Write a method named isEven that accepts an int argument. The method
// should return true if the argument is even, or false otherwise. Also write a program to test your
// method

public class Question2 {
    public static boolean checkEven(int n){
        if (n%2 == 0){
            return true;
        }
        return false;
    } 

    public static void main(String args[]){
        if(checkEven(9)){
            System.out.print("The number is Even");
        } else {
            System.out.print("The number is Odd");
        }
    }
}
