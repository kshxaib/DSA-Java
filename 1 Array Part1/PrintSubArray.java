public class PrintSubArray {
    // Method to print all possible subarrays of an array
    public static void subArry(int array[]) {
        // Outer loop for starting index of subarray
        for (int i = 0; i < array.length; i++) {
            // Middle loop for ending index of subarray
            for (int j = i; j < array.length; j++) {
                // Inner loop prints elements from i to j
                for (int k = i; k <= j; k++) {
                    System.out.print(array[k] + " ");
                }
                System.out.println(); // New line after printing one subarray
            }
            System.out.println(); // Blank line for readability
        }

        // Formula for total subarrays = n(n+1)/2
        System.out.printf("Total subarray: %d", (array.length * (array.length + 1)) / 2);
    }

    public static void main(String[] args) {
        int Array[] = {2, 4, 6, 8, 10}; 
        subArry(Array);
    }
}
