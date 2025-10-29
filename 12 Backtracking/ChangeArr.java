// Problem: Demonstrate Backtracking with Array Modification
/*
📌 Backtracking (Simple Definition):
Backtracking is a problem-solving technique that uses recursion
to explore all possible solutions by making a choice,
recursively exploring further, and then undoing the choice (backtrack).

👉 Example:
- Place → Check → Undo → Try next

---
📌 Problem Statement:
We are given an empty array of size n.
We need to:
  1. Fill the array sequentially with values (1, 2, 3, … n) using recursion.
  2. On returning (backtracking), modify the array elements.

👉 Key Idea (Backtracking in this code):
   - Move forward (recursion): Assign values (arr[index] = index+1).
   - Move backward (backtrack): Undo or modify the values (arr[index] = arr[index]-2).
   - This helps us explore *all states* of the array across recursion calls.
*/

public class ChangeArr {

    // Recursive function to modify array values
    public static void changeArrValues(int arr[], int index, int value){
        // Base case: If we reach end of array → print current state
        if(index == arr.length){
            printArr(arr);
            return;
        }

        // Step 1: Assign value at current index (going forward)
        arr[index] = value;

        // Recursive call for next index
        changeArrValues(arr, index+1, value+1);

        // Step 2: Backtracking step (undo/modify the change)
        arr[index] = arr[index] - 2;
    }

    // Utility function to print the array
    public static void printArr(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = new int[5];
        changeArrValues(arr, 0, 1);  // Start recursion
        printArr(arr); // Final array after complete recursion + backtracking
    }
}

/*
📌 Dry Run (arr of size 3 for simplicity):

Step 1: index=0 → arr[0]=1
Step 2: index=1 → arr[1]=2
Step 3: index=2 → arr[2]=3
Step 4: index=3 → Base Case → print [1,2,3]

Backtrack:
- Modify arr[2] = 3-2=1 → print [1,2,1]
- Modify arr[1] = 2-2=0 → print [1,0,1]
- Modify arr[0] = 1-2=-1 → print [-1,0,1]

✅ Shows how forward recursion builds values
✅ Shows how backtracking modifies them on the way back

---
📊 Time Complexity:
   - O(n) per recursion depth.
   - Each recursive call processes one element.
   - Total calls = n → O(n).

📊 Space Complexity:
   - O(n) for recursion stack.

---
⚡ Backtracking Recap:
- **Definition**: Backtracking = recursion + undo step.
- **In this code**:
   - Forward recursion → arr[index] = index+1
   - Undo step → arr[index] = arr[index]-2
- Used in problems like:
   - N-Queens
   - Rat in a Maze
   - Sudoku solver
   - Word search
*/
