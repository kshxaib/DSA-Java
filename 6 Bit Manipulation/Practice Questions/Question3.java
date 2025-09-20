// Add 1 to an integer using Bit Manipulation
public class Question3 {
    public static void main(String[] args) {
        // We want to compute 10 + 1 without using '+' operator

        // Step 1: Take bitwise NOT of 10
        // 10 in binary: 0000 1010
        // ~10 in binary: 1111 0101  (this is -11 in decimal, due to 2's complement representation)
        // So, ~10 = -11
        int x = -(~10);

        // Step 2: Negate the result
        // -(~10) = -(-11) = 11

        // NOTE:
        // Formula: -(~n) = n + 1
        // Proof:
        // ~n = -(n+1)   → property of bitwise NOT
        // -(~n) = -(-(n+1)) = n+1

        // Hence, -(~10) = 10 + 1 = 11
        System.out.print(x); // Output: 11
    }
}
