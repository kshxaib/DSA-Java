public class BinaryRightShift {
    public static void main(String[] args) {
        int num = 20;

        // Binary of 20 = 0001 0100
        // Right shift by 2 (20 >> 2):
        // Shift all bits 2 places to the right
        // 0001 0100 >> 2 = 0000 0101

        // 0000 0101 in decimal = 5

        // 🔹 Formula:
        // a >> b = a / (2^b)   
        // Example: 20 >> 2 = 20 / (2^2) = 20 / 4 = 5

        System.out.print(num >> 2); // Output: 5
    }
}
