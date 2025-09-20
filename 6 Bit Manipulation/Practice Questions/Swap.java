public class Swap {
    public static void main(String args[]){
        int x = 1, y = 2;
        System.out.printf("Before swap %d and %d", x, y);
        System.out.println();

        // Step 1: x = x ^ y
        // x = 01 (1 in binary)
        // y = 10 (2 in binary)
        // x = 01 ^ 10 = 11 (3 in binary)
        x = x ^ y;  
        // Now: x = 3 (11), y = 2 (10)

        // Step 2: y = x ^ y
        // x = 11 (3), y = 10 (2)
        // y = 11 ^ 10 = 01 (1 in binary)
        y = x ^ y;  
        // Now: x = 3 (11), y = 1 (01)

        // Step 3: x = x ^ y
        // x = 11 (3), y = 01 (1)
        // x = 11 ^ 01 = 10 (2 in binary)
        x = x ^ y;  
        // Now: x = 2 (10), y = 1 (01)

        System.out.printf("After swap %d and %d", x, y);
    }    
}
