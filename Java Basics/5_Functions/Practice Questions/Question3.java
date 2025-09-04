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
