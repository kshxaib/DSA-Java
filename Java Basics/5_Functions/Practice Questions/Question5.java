public class Question5 {
    public static void checkSum(int number){
        int sum = 0;

        while(number > 0){
            int lastDigit = number % 10;
            sum = sum + lastDigit;

            number = number / 10;
        }
        System.out.printf("Sum of number is: %d", sum);
    }    

    public static void main(String args[]){
        checkSum(1234);
    }
}
