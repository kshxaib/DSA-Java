public class CountSetBitsInNumber {

    // Function to count the number of set bits (1s) in binary representation of n
    public static int countSetBits(int n) {
        int count = 0;

        // Keep shifting n until it becomes 0
        while(n > 0){
            // Check the Least Significant Bit (LSB)
            // (n & 1) == 1 → means the last bit is set
            if((n & 1) != 0){
                count++;
            }

            // Right shift the number by 1 (drop the last bit)
            n = n >> 1;
        }
        return count;
    }
    
    public static void main(String[] args) {
        System.out.print(countSetBits(15));
    }
}
