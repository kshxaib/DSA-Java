public class BinaryOR {
    public static void main(String[] args) {
        // Numbers:
        // 5 in binary = 0101
        // 6 in binary = 0110

        // Bitwise OR (|) → Compares each bit:
        // Rule: 1 | 1 = 1, 1 | 0 = 1, 0 | 1 = 1, 0 | 0 = 0
        //
        //   0101   (5)
        // | 0110   (6)
        // --------
        //   0111   (7)

        System.out.print(5 | 6); // Output: 7
    } 
}
