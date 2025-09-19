public class clearRangeOfBits {

    // Function to clear bits from index i to j (inclusive) in number n
    public static int clearRangeOfBitsValue(int n, int i, int j){
        // Step 1: Create "a"
        // -1 in binary = ...11111111
        // Left shift (j+1) places: (-1 << (j+1))
        // Example: j = 4 → (-1 << 5) = ...11100000
        // This clears all bits from (j+1) to the right (sets them to 0).
        int a = -1 << (j + 1);

        // Step 2: Create "b"
        // (1 << i) → gives a binary number with 1 at ith position
        // Subtract 1 → gives a mask of i ones
        // Example: i = 2 → (1<<2) = 100 → 100-1 = 011
        // So b = 000...011
        int b = (1 << i) - 1;

        // Step 3: Combine both masks
        // a = ...11100000
        // b = ...00000011
        // a | b = ...11100011  (bits from i to j are 0, rest are 1)
        int bitMask = a | b;

        // Step 4: AND with n
        // This clears bits in the range [i, j]
        return n & bitMask;
    }

    public static void main(String[] args) {
        int n = 10;  // Binary: 1010
        int i = 2, j = 4;

        // Example: n = 10 (01010)
        // i=2, j=4 → clear bits from index 2 to 4
        // Result → 00010 = 2
        System.out.print(clearRangeOfBitsValue(n, i, j)); // Output: 2
    }
}
