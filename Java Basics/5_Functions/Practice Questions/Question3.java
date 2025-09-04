//  Write a Java program tocheckif a number is a palindrome in Java? ( 121 is a
//  palindrome, 321 is not)
//  Anumberis called a palindrome if the number is equal to the reverse of a number e.g., 121 is a
//  palindrome because the reverse of 121 is 121 itself. On the other hand, 321 is not a
//  palindrome because the reverse of 321 is 123, which is not equal to 321.

public class Question3 {
    public static void checkPalindrome(int number){
        int inputNumber = number;
        int reversedNumber = 0;

        while(number > 0){
            int lastDigit = number % 10; 
            reversedNumber = (reversedNumber * 10) + lastDigit;

            number = number / 10;
        }

        if(inputNumber == reversedNumber){
            System.out.print("The number is Plaindrome.");
        } else {
            System.out.print("The number is not Palindrome.");
        }
    }   
    
    public static void main(String agrs[]){
        checkPalindrome(121);
    }
}
