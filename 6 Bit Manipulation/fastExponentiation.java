public class fastExponentiation {
    // Function to calculate a^n using fast exponentiation
    public static int findPowerN(int n, int a) {
        int ans = 1;

        // Loop until exponent n becomes 0
        while (n > 0) {
            // If the current LSB (least significant bit) of n is 1
            // Multiply ans by current base (a)
            if ((n & 1) != 0) {
                ans = ans * a;
            }

            // Square the base for the next bit
            a = a * a;

            // Right shift n (move to next bit)
            n = n >> 1;
        }

        return ans;
    }
    
    public static void main(String[] args) {
        int a = 3, n = 5;
        System.out.println(a + "^" + n + " = " + findPowerN(n, a));
    }    
}
