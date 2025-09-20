public class clearLastIBits {

    // Function to clear (set to 0) the last i bits of number n
    public static int clearLastIBits(int n, int i){
        // Step 1: Create a bitmask
        // (-1) in binary is ...11111111 (all 1s in two’s complement)
        // Left shift by i → (-1 << i) makes the last i bits 0, rest remain 1
        //
        // Example: i = 2
        // (-1)      = ...11111111
        // (-1 << 2) = ...11111100   <-- last 2 bits are now 0
        int bitMask = (-1 << i);

        // Step 2: AND with n
        // This clears the last i bits of n
        return n & bitMask;
    }

    public static void main(String[] args) {
        int n = 15;  // Binary: 1111
        int i = 2;   // We want to clear last 2 bits

        // 1111 (15)
        // & 1100 (mask)
        // = 1100 (12)
        System.out.println(clearLastIBits(n, i));
    }
}