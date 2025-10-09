import java.util.*;

// Problem: Next Greater Element (NGE)
/*
📌 Problem Statement:
Given an array `arr[]`, find the **next greater element** for each element.
The next greater element for an element x is the first greater element 
on the **right side** of x in the array. If no greater element exists, use -1.

Example:
Input  → [6, 8, 0, 1, 3]
Output → [8, -1, 1, 3, -1]

👉 Concept:
- Traverse the array **from right to left**.
- Use a **stack** to keep track of potential "next greater elements".
- If current element is greater than or equal to the top of stack, pop the stack.
- The top of stack (if exists) becomes the NGE for the current element.
*/

public class NextGreaterElement {

    // 🔹 Function to find next greater element for all array elements
    public static void findNextGreater(int arr[], int nextGreater[]) {
        Stack<Integer> stack = new Stack<>(); // Stack stores indices
        int n = arr.length;

        // Last element has no element to its right → NGE = -1
        nextGreater[n - 1] = -1;
        stack.push(n - 1); // Push index of last element

        // Traverse array from second-last to first element
        for (int i = n - 2; i >= 0; i--) {
            // 🔹 Pop all elements smaller than or equal to current
            while (!stack.isEmpty() && arr[i] >= arr[stack.peek()]) {
                stack.pop();
            }

            // 🔹 Assign NGE based on stack status
            if (stack.isEmpty()) {
                nextGreater[i] = -1; // No greater element
            } else {
                nextGreater[i] = arr[stack.peek()]; // Top element is next greater
            }

            // 🔹 Push current element index for future comparisons
            stack.push(i);
        }
    }

    public static void main(String[] args) {
        int arr[] = {6, 8, 0, 1, 3};
        int nextGreater[] = new int[arr.length];

        // Find next greater elements
        findNextGreater(arr, nextGreater);

        // Print NGE array
        System.out.println("Next Greater Elements:");
        for (int nge : nextGreater) {
            System.out.print(nge + " ");
        }
    }
}

/*
📌 Dry Run:
Input: [6, 8, 0, 1, 3]

Step-by-step:
- i=4 → 3 → NGE = -1 (no elements to right)
- i=3 → 1 → NGE = 3
- i=2 → 0 → NGE = 1
- i=1 → 8 → NGE = -1
- i=0 → 6 → NGE = 8

Output: [8, -1, 1, 3, -1]

---

📊 Time Complexity:
O(n) — Each element is pushed and popped at most once.

📊 Space Complexity:
O(n) — Stack stores indices.

✅ Concept Used:
Stack + "Next Greater Element" logic (Monotonic Stack)
*/
