import java.util.*;

public class InbuiltSort {
    public static void main(String[] args) {
        int arr[] = {4, 1, 6, 2, 9};

        // ✅ Inbuilt Sorting
        // Arrays.sort() automatically sorts the array in ascending order
        // For primitive types (int, char, double, etc.):
        //    → Uses Dual-Pivot QuickSort (average O(n log n))
        // For objects (Integer, String, etc.):
        //    → Uses Timsort (hybrid of Merge Sort + Insertion Sort)

        Arrays.sort(arr);

        // Print the sorted array
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

/*
------------------ NOTES ------------------

1️⃣ Arrays.sort():
   - Primitive types → Dual-Pivot QuickSort (faster than normal QuickSort).
   - Objects (Integer, String, etc.) → Timsort (used in Java 7+).

2️⃣ Complexity:
   - Best Case: O(n log n)
   - Worst Case: O(n log n)
   - Average Case: O(n log n)

3️⃣ Space Complexity:
   - For primitives → O(1) (in-place QuickSort).
   - For objects → O(n) (Timsort uses extra space for merging).

4️⃣ Custom Sorting:
   - For objects, we can use:
        Arrays.sort(arr, Collections.reverseOrder());
        Arrays.sort(arr, Comparator.comparing(...));

---------------------------------------------------------
*/
