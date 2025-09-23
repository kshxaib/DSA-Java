// Program to check if an array is sorted (in ascending order) using recursion
public class checkArrayIsSorted {

    // Recursive function to check if array is sorted
    public static boolean isSorted(int arr[], int i){
        // Base case: if we reach the last element, array is sorted
        if(i == arr.length - 1){
            return true;
        }

        // If current element is greater than the next → array is not sorted
        if(arr[i] > arr[i+1]){
            return false;
        }

        // Recursive check for the rest of the array
        return isSorted(arr, i+1);
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};  // Sorted array
        System.out.println(isSorted(arr, 0));  // Output → true
    }
}

/*
📌 Dry Run Example:
    arr = {1, 2, 3, 4, 5}, i = 0
    isSorted(arr, 0) → checks (1 < 2) → true → calls isSorted(arr, 1)
    isSorted(arr, 1) → checks (2 < 3) → true → calls isSorted(arr, 2)
    isSorted(arr, 2) → checks (3 < 4) → true → calls isSorted(arr, 3)
    isSorted(arr, 3) → checks (4 < 5) → true → calls isSorted(arr, 4)
    isSorted(arr, 4) → base case reached → returns true

➡️ Final Answer = true ✅

📌 Another Example:
    arr = {1, 3, 2, 4}, i = 0
    isSorted(arr, 0) → (1 < 3) → true → call isSorted(arr, 1)
    isSorted(arr, 1) → (3 < 2) ❌ → returns false

➡️ Final Answer = false ❌

✅ Time Complexity: O(n) → each element checked once  
✅ Space Complexity: O(n) → recursion stack depth
*/
