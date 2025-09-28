// Problem: Search in Rotated Sorted Array
/*
📌 Problem Statement:
You are given a rotated sorted array (originally sorted in ascending order but rotated at some pivot).
Find the index of the target element if it exists, otherwise return -1.

Example:
   arr = [4, 5, 6, 7, 0, 1, 2], target = 0
   Output → 4

👉 Idea:
   - This is a variation of Binary Search.
   - At every step, one half of the array is always sorted.
   - We check which half is sorted, then decide whether the target lies in that half.
   - If yes → search in that half.
   - If no → search in the other half.

⚡ Key Point:
   - Normal binary search works only if the array is fully sorted.
   - Here, we use the property of "one half is sorted" to modify binary search.
*/

public class SearchInRotatedArray {

    /*
     * Function to search for a target in rotated sorted array.
     * arr[]     → rotated sorted array
     * target    → element to search
     * startIdx  → starting index of current search range
     * endIdx    → ending index of current search range
     * 
     * Returns:
     *    index of target element if found
     *    -1 if target does not exist
     */
    public static int search(int arr[], int target, int startIdx, int endIdx){
        // Base case: invalid range → target not found
        if(startIdx > endIdx){
            return -1;
        }

        // Step 1: Find mid index
        int mid = startIdx + (endIdx - startIdx) / 2;

        // Step 2: Check if mid element is the target
        if(arr[mid] == target){
            return mid;
        }

        /*
         * Step 3: Determine which half is sorted
         * Case 1: Left half [startIdx ... mid] is sorted
         */
        if(arr[startIdx] <= arr[mid]){
            // Check if target lies within left half
            if(arr[startIdx] <= target && target < arr[mid]){
                return search(arr, target, startIdx, mid - 1); // search left half
            } else {
                return search(arr, target, mid + 1, endIdx);   // search right half
            }
        } 
        /*
         * Case 2: Right half [mid ... endIdx] is sorted
         */
        else {
            // Check if target lies within right half
            if(arr[mid] <= target && target <= arr[endIdx]){
                return search(arr, target, mid + 1, endIdx);   // search right half
            } else {
                return search(arr, target, startIdx, mid - 1); // search left half
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println(search(arr, target, 0, arr.length - 1)); // ✅ Output: 4
    }
}

/*
📌 Dry Run (arr = [4, 5, 6, 7, 0, 1, 2], target = 0):

Step 1: startIdx=0, endIdx=6 → mid=3 → arr[mid]=7
   arr[startIdx]=4 <= arr[mid]=7 → Left half is sorted
   Target=0 not in [4...7] → Search in right half

Step 2: startIdx=4, endIdx=6 → mid=5 → arr[mid]=1
   arr[startIdx]=0 <= arr[mid]=1 → Left half is sorted
   Target=0 lies in [0...1] → Search in left half

Step 3: startIdx=4, endIdx=4 → mid=4 → arr[mid]=0
   Found target at index 4

✅ Output: 4

---

📊 Time Complexity:
   - Each step halves the search space → O(log n)

📊 Space Complexity:
   - Recursive calls take O(log n) space (recursion stack)
   - Iterative version would be O(1)
*/
