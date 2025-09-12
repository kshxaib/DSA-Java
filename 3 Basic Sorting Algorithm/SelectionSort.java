/*
    Selection Sort:
    - Finds the minimum element in the unsorted part of the array
      and places it at the correct position in each iteration.
    - Repeats this process until the array is sorted.
*/

public class SelectionSort {

    // Selection Sort function
    public static void SS(int arr[]) {
        // Outer loop -> moves the boundary of the unsorted part
        for (int i = 0; i < arr.length - 1; i++) {

            // Assume the current index has the minimum element
            int minElementIndex = i;

            // Inner loop -> find the actual minimum element in the unsorted part
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minElementIndex] > arr[j]) {
                    minElementIndex = j; // update min index
                }
            }

            // Swap the found minimum element with the first element of the unsorted part
            int temp = arr[minElementIndex];
            arr[minElementIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        int arr[] = {4, 1, 6, 2, 9};

        // Call Selection Sort
        SS(arr);

        // Print the sorted array
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

/*
------------------ COMPLEXITY ANALYSIS ------------------

1️⃣ Time Complexity:
   - Best Case: O(n^2) → still scans the unsorted part completely.
   - Worst Case: O(n^2) → reverse sorted input.
   - Average Case: O(n^2)

   Explanation:
   Outer loop runs (n-1) times.
   Inner loop runs (n-i-1) times.
   Total comparisons = n*(n-1)/2 ≈ O(n^2).

2️⃣ Space Complexity:
   - O(1) → only one temporary variable used for swapping.

3️⃣ Stability:
   - ❌ Not stable by default.
     Example: If equal elements exist, their original order might change.

---------------------------------------------------------
*/
