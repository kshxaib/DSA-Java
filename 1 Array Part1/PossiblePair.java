public class PossiblePair {
    // Method to print all possible unique pairs in an array
    public static void printPossiblePair(int numbers[]) {
        int totalPairs = 0; // To count pairs

        // Outer loop picks the first element
        for (int i = 0; i < numbers.length; i++) {
            // Inner loop picks the second element (j = i+1 to avoid duplicates)
            for (int j = i + 1; j < numbers.length; j++) {
                // Print the current pair
                System.out.printf("[%d %d] ", numbers[i], numbers[j]);
                totalPairs++;
            }
            System.out.println(); // New line after each i iteration
        }

        // Formula for total unique pairs = n(n-1)/2
        System.out.printf("Total Pairs: %d", (numbers.length * (numbers.length - 1)) / 2);
    }

    public static void main(String args[]) {
        int numbers[] = {2, 4, 6, 8, 10}; 
        printPossiblePair(numbers); 
    }
}

//Time Complexity: O(n²)
//Space Complexity: O(1)