public class LinearSearch {

    // Method to perform Linear Search
    // Takes an array of numbers and a key (element to find) as input
    // Returns the index of the key if found, else returns -1
    public static int performLinearSearch(int numbers[], int key) {
        // Loop through the array from start to end
        for (int i = 0; i < numbers.length; i++) {
            // Check if current element matches the key
            if (numbers[i] == key) {
                return i; // Return index if element is found
            }
        }
        // If not found after full traversal, return -1
        return -1;
    }

    public static void main(String[] args) {
        // Array of numbers to search in
        int numbers[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // Element we want to search
        int key = 5;

        // Call linear search method
        int result = performLinearSearch(numbers, key);

        // Check the result and print accordingly
        if (result != -1) {
            System.out.printf("Number found at index %d", result);
        } else {
            System.out.print("Not found");
        }
    }
}
