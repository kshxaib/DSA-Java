public class BinaryToDecimal {
    public static void ConvertBinaryToDecimal(int binaryNumber){
        int pow = 0;
        int decimalNumber = 0;
        int inputBinaryNumber = binaryNumber;

        while(binaryNumber > 0){
            int lastDigit = binaryNumber % 10;
            decimalNumber = decimalNumber + (lastDigit * (int) Math.pow(2, pow));

            pow++;
            binaryNumber = binaryNumber / 10;
        }
        System.out.printf("Binary number: %d is converted to decimal binary number: %d", inputBinaryNumber, decimalNumber);
    }

    public static void main(String args[]){
        ConvertBinaryToDecimal(1011);
    }
}