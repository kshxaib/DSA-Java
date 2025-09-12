/*
    Insertion Sort:
    - Builds the final sorted array one element at a time.
    - Works similar to sorting playing cards in your hand.
    - At each iteration, takes the current element and 
      inserts it into its correct position in the sorted part.
*/

public class InsertionSort {

    // Insertion Sort function
    public static void IS(int arr[]) {
        // Start from index 1 (since arr[0] is already "sorted")
        for (int i = 1; i < arr.length; i++) {
            int currentElement = arr[i]; // element to be placed
            int prevIdx = i - 1;

            // Shift larger elements to the right to make space
            while (prevIdx >= 0 && arr[prevIdx] > currentElement) {
                arr[prevIdx + 1] = arr[prevIdx];
                prevIdx--;
            }

            // Insert the current element into the correct position
            arr[prevIdx + 1] = currentElement;
        }
    }

    public static void main(String[] args) {
        int arr[] = {4, 1, 6, 2, 9};

        // Call Insertion Sort
        IS(arr);

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
        → If array is already sorted (only one comparison per element).
   - Worst Case: O(n^2) 
        → If array is reverse sorted (shifts for every element).
   - Average Case: O(n^2)

   Explanation:
   Outer loop runs (n-1) times.
   Inner loop (shifting) can take up to i comparisons in worst case.
   Total operations ≈ O(n^2).

2️⃣ Space Complexity:
   - O(1) → Sorting is done in-place (only one temp variable used).

3️⃣ Stability:
   - ✅ Stable (equal elements retain their relative order).

---------------------------------------------------------
*/
