public class clearIthBit {
    // Function to clear (make 0) the ith bit of number n
    public static int clearIthBitValue(int n, int i){
        // Step 1: Create bitMask
        // (1 << i) shifts 1 to the ith position
        // Example: i = 2 → (1 << 2) = 0100 (binary)
        // Then take NOT (~): ~(0100) = 1011 (in 4 bits)

        int bitMask = ~(1 << i);

        // Step 2: Perform AND with n
        // AND rule: 1&1=1, 0&1=0
        // So ith bit will become 0, all other bits stay same

        // Example 1: n = 10 (binary 1010), i = 1
        // bitMask = ~(0010) = 1101
        //   1010 (10 in binary)
        // & 1101
        //   ----
        //   1000 = 8 (decimal)

        // Example 2: n = 10 (1010), i = 3
        // bitMask = ~(1000) = 0111
        //   1010
        // & 0111
        //   ----
        //   0010 = 2

        return n & bitMask;
    }

    public static void main(String[] args) {
        int n = 10;  // binary: 1010
        int i = 1;   // clear 1st bit (0-indexed from right)

        System.out.println("Original number: " + n);
        System.out.println("After clearing " + i + "th bit: " + clearIthBitValue(n, i));
    }
}
