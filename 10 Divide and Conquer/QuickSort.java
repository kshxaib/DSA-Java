// Problem: Quick Sort
/*
📌 Problem Statement:
Given an array of integers, sort it in ascending order using
the Quick Sort algorithm.

👉 Idea (Divide and Conquer):
   - Choose a pivot element.
   - Partition the array into two parts:
       Left  → elements smaller than or equal to pivot
       Right → elements greater than pivot
   - Recursively sort both parts.

Steps:
   1. Divide  → Partition the array around a pivot.
   2. Conquer → Recursively apply QuickSort on left & right partitions.
   3. Combine → Since elements are placed correctly during partitioning,
                no extra combine step is required.
*/

public class QuickSort {
    public static void printArr(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    /*
     * Recursive function to perform Quick Sort.
     * arr[]     → the array to be sorted
     * startIdx  → starting index of subarray
     * endIdx    → ending index of subarray
     */
    public static void performQS(int arr[], int startIdx, int endIdx){
        // Base case: subarray with 0 or 1 element is already sorted
        if(startIdx >= endIdx){
            return;
        }

        // Step 1: Partition the array and get pivot index
        int partitionIdx = partition(arr, startIdx, endIdx);

        // Step 2: Recursively sort elements left of pivot
        performQS(arr, startIdx, partitionIdx - 1);

        // Step 3: Recursively sort elements right of pivot
        performQS(arr, partitionIdx + 1, endIdx);
    }   
    
    /*
     * Partition function to place pivot at its correct position.
     * Chooses the first element as pivot.
     * Rearranges elements such that:
     *    - All elements <= pivot are on the left
     *    - All elements > pivot are on the right
     */
    public static int partition(int arr[], int startIdx, int endIdx){
        int pivotElement = arr[startIdx]; // Choosing first element as pivot
        int i = startIdx;
        int j = endIdx;

        // Loop until pointers cross
        while(i < j){

            // Move i forward until we find an element greater than pivot
            while(i <= endIdx && arr[i] <= pivotElement){
                i++;
            }

            // Move j backward until we find an element smaller than or equal to pivot
            while(j >= startIdx && arr[j] > pivotElement){
                j--;
            }

            // Swap elements at i and j if misplaced
            if(i < j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Place pivot in its correct position
        arr[startIdx] = arr[j];
        arr[j] = pivotElement;

        // Return final position of pivot
        return j;
    }

    public static void main(String[] args) {
        int arr[] = {4, 6, 2, 5, 7, 9, 1, 3};
        performQS(arr, 0, arr.length - 1);
        printArr(arr); 
    }
}

/*
📌 Dry Run (arr = [4, 6, 2, 5, 7, 9, 1, 3]):

Step 1: Choose pivot = 4
   Partitioning → [3, 2, 1] [4] [7, 9, 6, 5]

Step 2: Recursively sort left [3, 2, 1]
   Pivot = 3 → [1, 2] [3]
   Sorted left = [1, 2, 3]

Step 3: Recursively sort right [7, 9, 6, 5]
   Pivot = 7 → [5, 6] [7] [9]
   Sorted right = [5, 6, 7, 9]

Step 4: Combine
   Left [1, 2, 3] + Pivot [4] + Right [5, 6, 7, 9]
   → [1, 2, 3, 4, 5, 6, 7, 9]

✅ Final Sorted Array: [1, 2, 3, 4, 5, 6, 7, 9]

---

📊 Time Complexity Analysis:
   - Best / Average Case: O(n log n)
     (Array gets divided approximately in half at each step)
   - Worst Case: O(n²) 
     (If pivot is always smallest/largest → highly unbalanced split)

📊 Space Complexity:
   - O(log n) recursion stack (for balanced partitions).
   - In-place sorting → no extra array needed.
   - Overall → O(log n)
*/
