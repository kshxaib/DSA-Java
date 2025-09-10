public class MaxSubArray {

    // ---------------- Brute Force Approach ----------------
    public static void printMaxSubArry(int array[]) {
        int maxSumOfSubarray = Integer.MIN_VALUE; // Stores the maximum sum found so far
        int sumOfSubarray = 0; // Temporary variable to calculate subarray sum

        // Outer loop → choose starting index
        for (int i = 0; i < array.length; i++) {
            // Middle loop → choose ending index
            for (int j = i; j < array.length; j++) {
                // Inner loop → calculate sum of subarray from i..j
                for (int k = i; k <= j; k++) {
                    sumOfSubarray = sumOfSubarray + array[k];
                }

                // Update max if the current subarray sum is greater
                if (sumOfSubarray > maxSumOfSubarray) {
                    maxSumOfSubarray = sumOfSubarray;
                }

                // Reset sum before checking the next subarray
                sumOfSubarray = 0;
            }
        }

        // Print the maximum subarray sum
        System.out.printf("Maximum sum of subarray is: %d%n", maxSumOfSubarray);
    }

    // ---------------- Prefix Sum Approach ----------------
    // Optimization using prefix array
    public static void printMaxSubArryByPrefix(int array[]) {
        int maxSumOfSubarray = Integer.MIN_VALUE; // Stores the maximum sum
        int sumOfSubarray = 0; // Temporary variable for subarray sum

        // Step 1: Build prefix array → prefix[i] stores sum of array[0..i]
        int prefix[] = new int[array.length];
        prefix[0] = array[0];
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + array[i];
        }

        // Step 2: Check all subarrays using prefix sum formula
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                // Subarray sum from i..j
                sumOfSubarray = i == 0 ? prefix[j] : prefix[j] - prefix[i - 1];

                // Update maximum sum if needed
                if (sumOfSubarray > maxSumOfSubarray) {
                    maxSumOfSubarray = sumOfSubarray;
                }
            }
        }

        // Print result
        System.out.printf("Maximum sum of subarray is: %d%n", maxSumOfSubarray);
    }

    // ---------------- Kadane’s Algorithm ----------------
    public static void printMaxSubArryByKadane(int array[]) {
        int currentSum = 0; // Stores current running sum
        int maximumSum = array[0]; // Initialize with first element (handles negative arrays too)

        // Traverse array once
        for (int i = 0; i < array.length; i++) {
            currentSum = currentSum + array[i]; // Add current element to sum

            // If sum drops below 0, reset (don’t carry negative sum forward)
            if (currentSum < 0) {
                currentSum = 0;
            } 
            // Update maximum sum if currentSum is better
            else if (currentSum > maximumSum) {
                maximumSum = currentSum;
            }
        }

        System.out.printf("Maximum sum of subarray is: %d%n", maximumSum);
    }

    public static void main(String[] args) {
        int array[] = {2, 4, 6, 8, 10};

        // Brute Force: O(n³), Space O(1)
        // printMaxSubArry(array);

        // Prefix Sum: O(n²), Space O(n)
        // printMaxSubArryByPrefix(array);

        // Kadane’s Algorithm: O(n), Space O(1)
        printMaxSubArryByKadane(array);
    }
}
