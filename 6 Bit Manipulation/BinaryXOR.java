public class BinaryXOR {
    public static void main(String[] args) {
        // Numbers:
        // 5 in binary = 0101
        // 6 in binary = 0110

        // Bitwise XOR (^) → Exclusive OR
        // Rule: 1 ^ 1 = 0, 0 ^ 0 = 0, 1 ^ 0 = 1, 0 ^ 1 = 1
        //
        //   0101   (5)
        // ^ 0110   (6)
        // --------
        //   0011   (3)

        System.out.print(5 ^ 6); // Output: 3
    } 
}
