public class Question4 {
    public static void main(String[] args) {

        // Convert uppercase characters ('A'–'Z') to lowercase ('a'–'z') using bits
        for (char ch = 'A'; ch <= 'Z'; ch++) {

            // Trick: OR with space ' ' (ASCII 32 = binary 0010 0000)
            // In ASCII, uppercase letters differ from lowercase letters
            // only in the 6th bit (from right).
            //
            // Example: 
            // 'A' = 65 → binary 0100 0001
            // 'a' = 97 → binary 0110 0001
            //
            // Difference: The 6th bit (32) is set in lowercase.
            //
            // So, (ch | ' ') sets that bit → converts uppercase to lowercase.

            System.out.println((char)(ch | ' '));

            // Output sequence:
            // abcdefghijklmnopqrstuvwxyz   
        }
    }
}
