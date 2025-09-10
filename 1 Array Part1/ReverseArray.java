public class ReverseArray {

    // Method to reverse the array in-place
    public static void RA(int numbers[]) {
        int start = 0, end = numbers.length - 1; // Pointers at beginning and end

        // Keep swapping until start crosses end
        while (start < end) {
            // Swap elements at start and end
            int temp = numbers[start];
            numbers[start] = numbers[end];
            numbers[end] = temp;

            // Move pointers towards the center
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        // Original array
        int numbers[] = {1, 2, 3, 4, 5, 6, 7};

        // Call reverse method
        RA(numbers);

        // Print reversed array
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)
