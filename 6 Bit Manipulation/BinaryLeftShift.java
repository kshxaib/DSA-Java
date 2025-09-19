public class BinaryLeftShift {
    public static void main(String[] args) {
        int num = 5;

        // Binary of 5 = 0000 0101
        // Left shift by 2 (5 << 2):
        // Shift all bits 2 places to the left
        // 0000 0101 << 2 = 0001 0100

        // 0001 0100 in decimal = 20

        // 🔹 Formula:
        // a << b = a * (2^b)
        // Example: 5 << 2 = 5 * (2^2) = 5 * 4 = 20

        System.out.print(num << 2); // Output: 20
    }
}
