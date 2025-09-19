public class checkIfNumberIsPowerOf2 {

    // Function to check if a number is a power of 2
    public static boolean isPowerOf2(int n){
        // Property:
        // A number n is a power of 2 if it has only ONE bit set in binary.
        // Example: 1 (0001), 2 (0010), 4 (0100), 8 (1000), ...
        //
        // Trick:
        // n & (n-1) → removes the rightmost set bit
        // If result == 0 → only one bit was set → power of 2

        if((n & (n-1)) == 0){
            return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
        System.out.print(isPowerOf2(16));
    }    
}
