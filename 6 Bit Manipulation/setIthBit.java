public class setIthBit {
    // Function to set (make 1) the ith bit of number n
    public static int setIthBitValue(int n, int i){
        // Step 1: Create bitMask by shifting 1 to the left i times
        // Example: i = 2 → (1 << 2) = 100 (binary) = 4
        int bitMask = 1 << i;

        // Step 2: Perform OR operation
        // OR rule: 0|1 = 1, 1|0 = 1, 1|1 = 1
        // This ensures the ith bit becomes 1, no matter what it was

        // Example 1: n = 10 (binary 1010), i = 2
        // bitMask = 0100
        //   1010 (n = 10)
        // | 0100 (bitMask = 4)
        //   ----
        //   1110 = 14 (decimal)
        //
        // Example 2: n = 10 (1010), i = 1
        // bitMask = 0010
        //   1010
        // | 0010
        //   ----
        //   1010 = 10 (unchanged, since bit was already 1)

        return n | bitMask;
    }

    public static void main(String[] args) {
        int n = 10;  // binary: 1010
        int i = 2;   // set 2nd bit (0-indexed from right)

        System.out.println("Original number: " + n);
        System.out.println("After setting " + i + "th bit: " + setIthBitValue(n, i));
    }    
}
