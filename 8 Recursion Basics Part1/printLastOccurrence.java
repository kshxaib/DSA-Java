// Program to find the last occurrence of an element in an array using recursion
public class printLastOccurrence {
    
    // Recursive function
    public static int lastOcc(int arr[], int key, int i){
        // Base case: reached end of array
        if(i == arr.length){
            return -1;
        }

        // Recursive call → search in the rest of the array
        int foundIndex = lastOcc(arr, key, i+1);

        // If found in later part, return that index
        if(foundIndex != -1){
            return foundIndex;
        }

        // Else, check current element
        if(arr[i] == key){
            return i;
        }

        // Not found → return -1
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,4,8,2,9};
        System.out.println(lastOcc(arr, 2, 0));  
        // Expected Output → 4 (last occurrence of 2 at index 4)
    }
}

/*
📌 Dry Run:
    arr = {1,2,4,8,2,9}, key = 2
    lastOcc(arr, 2, 0)
        → calls lastOcc(arr, 2, 1)
        → calls lastOcc(arr, 2, 2) ...
        → until lastOcc(arr, 2, 6) → returns -1
        backtrack:
            i=5 → arr[5]=9 ≠ key → return -1
            i=4 → arr[4]=2 ✅ → return 4
            (previous calls just return 4)
    ➡️ Final Answer = 4

📌 Another Example:
    arr = {5,6,7}, key = 10
    → no match → return -1

✅ Time Complexity: O(n) (must check every element)
✅ Space Complexity: O(n) (recursion stack)
*/
