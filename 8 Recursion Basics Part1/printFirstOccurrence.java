// Program to find the first occurrence of an element in an array using recursion
public class printFirstOccurrence {
    
    // Recursive function
    public static int firstOcc(int arr[], int key, int i){
        // Base case: reached end of array → element not found
        if(i == arr.length){
            return -1;
        }

        // If current element matches key → return index
        if(arr[i] == key){
            return i;
        }

        // Recursive call to check in the remaining array
        return firstOcc(arr, key, i+1);
    }

    public static void main(String[] args) {
        int arr[] = {1,2,4,8,2,9};
        System.out.println(firstOcc(arr, 2, 0));  
        // Expected Output → 1 (first occurrence of 2 at index 1)
    }
}

/*
📌 Dry Run:
    arr = {1,2,4,8,2,9}, key = 2
    firstOcc(arr, 2, 0) → arr[0] = 1 ≠ 2 → call firstOcc(arr, 2, 1)
    firstOcc(arr, 2, 1) → arr[1] = 2 ✅ match → return 1

➡️ Final Answer = 1

📌 Another Example:
    arr = {5,6,7}, key = 10
    firstOcc(arr, 10, 0) → no match → eventually i == arr.length → return -1

➡️ Final Answer = -1

✅ Time Complexity: O(n) → in worst case, we scan the whole array  
✅ Space Complexity: O(n) → due to recursion stack (n recursive calls)
*/
