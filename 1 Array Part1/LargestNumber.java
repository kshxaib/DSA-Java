public class LargestNumber {
    public static void main(String args[]) {
        // Array of numbers
        int numbers[] = {12, 43, 59, 92, 12, 24};

        // Initialize 'largest' with the smallest possible integer value
        // This ensures any number in the array will be greater
        int largest = Integer.MIN_VALUE;

        // Loop through the array
        for (int i = 0; i < numbers.length; i++) {
            // If current element is greater than 'largest'
            if (numbers[i] > largest) {
                // Update 'largest' with the current element
                largest = numbers[i];
            }
        }

        // Print the largest number found
        System.out.printf("Largest number is %d", largest);
    }
}
