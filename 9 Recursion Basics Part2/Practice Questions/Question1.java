// Problem: Print all indices of an element in an array
/*
📌 Problem Statement:
Given an array and a key, print all indices where the key occurs.

👉 Approach:
- Traverse array recursively.
- At each step:
   - If current element matches key → print index.
   - Move to next index (index+1).
*/

public class Question1 {
    
    // Recursive function to print indices of 'key'
    public static void printIndices(int arr[], int key, int index){
        // Base case: if we reach end of array → stop
        if(index == arr.length){
            return;
        }

        // If current element matches the key → print its index
        if(arr[index] == key){
            System.out.print(index + " ");
        }

        // Recursive call for next element
        printIndices(arr, key, index+1);
    }

    public static void main(String[] args) {
        int arr[] = {3, 2, 4, 5, 6, 2, 7, 2, 2};
        printIndices(arr, 2, 0);  
        // Expected Output → 1 5 7 8
    }    
}

/*
📌 Dry Run:
arr = {3, 2, 4, 5, 6, 2, 7, 2, 2}, key=2

Step 1: index=0 → arr[0]=3 ≠ key → skip
Step 2: index=1 → arr[1]=2 = key → print 1
Step 3: index=2 → arr[2]=4 ≠ key → skip
Step 4: index=3 → arr[3]=5 ≠ key → skip
Step 5: index=4 → arr[4]=6 ≠ key → skip
Step 6: index=5 → arr[5]=2 = key → print 5
Step 7: index=6 → arr[6]=7 ≠ key → skip
Step 8: index=7 → arr[7]=2 = key → print 7
Step 9: index=8 → arr[8]=2 = key → print 8
→ End

✅ Output = 1 5 7 8

✅ Time Complexity: O(n) → each element is visited once
✅ Space Complexity: O(n) → recursion stack depth = n
*/
