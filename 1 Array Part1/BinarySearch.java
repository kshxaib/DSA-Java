import java.util.Arrays;

public class BinarySearch {
    // Binary Search method
    public static int BS(int numbers[], int key) {
        int start = 0, end = numbers.length - 1; // Correct end index

        while (start <= end) {
            int mid = (start + end) / 2; // Middle index

            if (numbers[mid] == key) {
                return mid; // Key found
            }

            if (numbers[mid] < key) {
                start = mid + 1; // Search in right half
            } else {
                end = mid - 1; // Search in left half
            }
        }

        return -1; // Key not found
    }

    public static void main(String[] args) {
        int numbers[] = {12, 4, 23, 91, 24, 9};
        int key = 23;

        // Sort array before applying Binary Search
        Arrays.sort(numbers);

        // Perform Binary Search
        int result = BS(numbers, key);

        if (result != -1) {
            System.out.printf("Number %d found at index %d", key, result);
        } else {
            System.out.print("Not found");
        }
    }
}

// Time Complexity: O(logn)
// Space Complexity: O(1)