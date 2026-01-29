// Problem: Merge Sort
/*
📌 Problem Statement:
Given an array of integers, sort it in ascending order using
the Merge Sort algorithm.

👉 Idea (Divide and Conquer):
   - Merge Sort recursively splits the array into two halves,
     sorts each half, and then merges the sorted halves.
   - The merging step combines two sorted subarrays into
     one sorted subarray.

Steps:
   1. Divide → Split array into two halves.
   2. Conquer → Recursively sort both halves.
   3. Combine → Merge the two sorted halves.
*/

public class MergeSort {
    public static void printArr(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    /*
     * Recursive function to perform Merge Sort.
     * arr[]     → the array to be sorted
     * startIdx  → starting index of the subarray
     * endIdx    → ending index of the subarray
     */
    public static void performMS(int arr[], int startIdx, int endIdx){
        // Base case: if the subarray has 1 or 0 elements → already sorted
        if(startIdx >= endIdx){
            return;
        }

        // Step 1: Find the mid index to split array into two halves
        int mid = startIdx + (endIdx - startIdx) / 2;

        // Step 2: Recursively sort the left half
        performMS(arr, startIdx, mid);

        // Step 3: Recursively sort the right half
        performMS(arr, mid+1, endIdx);

        // Step 4: Merge the two sorted halves
        merge(arr, startIdx, mid, endIdx);
    }

    /*
     * Function to merge two sorted subarrays into one sorted subarray.
     * First subarray : arr[startIdx ... mid]
     * Second subarray: arr[mid+1 ... endIdx]
     */
    public static void merge(int arr[], int startIdx, int mid, int endIdx){
        // Temporary array to hold merged result
        int temp[] = new int[endIdx - startIdx + 1];

        int i = startIdx;  // Pointer for left subarray
        int j = mid + 1;   // Pointer for right subarray
        int k = 0;         // Pointer for temp array

        // Compare elements from both halves and pick the smaller one
        while(i <= mid && j <= endIdx){
            if(arr[i] < arr[j]){
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        // Copy remaining elements from left subarray (if any)
        while(i <= mid){
            temp[k++] = arr[i++];
        }

        // Copy remaining elements from right subarray (if any)
        while(j <= endIdx){
            temp[k++] = arr[j++];
        }

        /*
         * Copy merged elements back to original array.
         * Note: We start from arr[startIdx], not arr[0],
         * because merge is operating only on a subarray.
         */
        for(i = startIdx; i <= endIdx; i++){
            arr[i] = temp[i - startIdx];
        }
    }

    public static void main(String args[]){
        int arr[] = {6, 3, 9, 5, 2, 8};
        performMS(arr, 0, arr.length - 1); 
        printArr(arr); 
    }
}

/*
📌 Dry Run (arr = [6, 3, 9, 5, 2, 8]):

Step 1: Split into halves → [6, 3, 9] and [5, 2, 8]

Step 2: Sort left half [6, 3, 9]:
    - Split into [6, 3] and [9]
    - Sort [6, 3]:
        - Split into [6] and [3]
        - Merge → [3, 6]
    - Merge [3, 6] and [9] → [3, 6, 9]
    
Step 3: Sort right half [5, 2, 8]:
    - Split into [5, 2] and [8]
    - Sort [5, 2]:
        - Split into [5] and [2]
        - Merge → [2, 5]
    - Merge [2, 5] and [8] → [2, 5, 8]

Step 4: Merge [3, 6, 9] and [2, 5, 8] → [2, 3, 5, 6, 8, 9]

✅ Final Sorted Array: [2, 3, 5, 6, 8, 9]

---

📊 Time Complexity Analysis:
   - Each merge step takes O(n) time (comparing and copying).
   - The array is split into halves → log₂n levels of recursion.
   - Total = O(n log n)

📊 Space Complexity:
   - O(n) for the temporary array during merging.
   - O(log n) for recursion stack depth.
   - Overall → O(n)
*/
