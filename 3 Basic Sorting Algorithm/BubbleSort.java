/*
    Optimized Bubble Sort:
    - Bubble Sort repeatedly compares adjacent elements in an array/list and 
      swaps them if they are in the wrong order.
    - After each pass, the largest element moves to the end.
    - Optimization: If no swap occurs in a pass → array is already sorted → stop early.
*/

public class BubbleSort {

    // Optimized Bubble Sort function
    public static void BS(int arr[]) {
        // Outer loop -> runs n-1 times at most
        for (int turn = 0; turn < arr.length - 1; turn++) {
            boolean swapped = false; // Track if swapping happened in this pass

            // Inner loop -> compares adjacent elements
            for (int j = 0; j < arr.length - 1 - turn; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap if elements are in wrong order
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swapped = true; // Mark swap occurred
                }
            }

            // If no swapping happened in this pass → array is already sorted
            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String args[]) {
        int arr[] = {5, 4, 1, 3, 2};

        // Call Bubble Sort
        BS(arr);

        // Print the sorted array
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

/*
------------------ COMPLEXITY ANALYSIS ------------------

1️⃣ Time Complexity:
   - Best Case: O(n) 
        → If the array is already sorted (only 1 pass, no swaps).
   - Worst Case: O(n^2) 
        → When the array is in reverse order.
   - Average Case: O(n^2)

   Explanation:
   Outer loop runs (n-1) times in worst case.
   Inner loop comparisons reduce each pass → ~ n*(n-1)/2 ≈ O(n^2).
   Optimization reduces best case to O(n).

2️⃣ Space Complexity:
   - O(1) → Only one temporary variable used for swapping.

3️⃣ Stability:
   - Bubble Sort is stable 
     (equal elements retain their original relative order).

---------------------------------------------------------
*/
