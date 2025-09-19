public class getIthBit {
    // Function to get the ith bit of number n
    public static int getIthBitValue(int n, int i){
        // Step 1: Create a bit mask by shifting 1 to the left by i places
        // Example: i = 2 → (1 << 2) = 100 (binary) = 4
        int bitMask = 1 << i;

        // Step 2: Perform AND operation between n and bitMask
        // Example: n = 10 (binary 1010), i = 2 → bitMask = 0100
        //  1010 (n)
        //& 0100 (bitMask)
        //  ----
        //  0000 → result = 0 → bit is 0
        //
        // Another example: n = 10 (1010), i = 1 → bitMask = 0010
        //  1010
        //& 0010
        //  ----
        //  0010 → result != 0 → bit is 1
        if ((n & bitMask) == 0) {
            return 0;  // ith bit is 0
        } else {
            return 1;  // ith bit is 1
        }
    }

    public static void main(String args[]){
        int n = 10;   // Binary: 1010
        int i = 2;    // Check the 2nd bit (0-indexed from right)

        System.out.println("The " + i + "th bit of " + n + " is: " + getIthBitValue(n, i));
    }
}
