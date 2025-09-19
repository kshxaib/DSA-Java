public class Binary1sComplement {
    public static void main(String[] args) {
        int num = 5;

        // 5 in binary = 0000 0101  (32-bit representation)
        // ~5 → flips all bits
        //   1111 1010  (which is -6 in decimal due to 2's complement representation)

        System.out.print(~num); // Output: -6
    }     
}
    