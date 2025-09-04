public class DecimalToBinary {
    public static void ConvertDecimalToBinary(int decimalNumber){
        int pow = 0;
        int binaryNumber = 0;
        int inputDecimalNumber = decimalNumber;

        while(decimalNumber > 0){
            int remainder = decimalNumber % 2;
            binaryNumber = binaryNumber + (remainder * (int) Math.pow(10, pow));

            pow++;
            decimalNumber = decimalNumber / 2;
        }
        System.out.printf("Decimal number: %d is converted to binary number: %d ", inputDecimalNumber, binaryNumber);
    }

    public static void main(String args[]){
        ConvertDecimalToBinary(7);
    }
}
