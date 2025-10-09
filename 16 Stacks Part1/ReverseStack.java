import java.util.*;

// Problem: Reverse a Stack using Recursion
/*
📌 Problem Statement:
Given a stack of integers, reverse it **using recursion only**.
You are not allowed to use any extra data structure like another stack or array.

Example:
Input  → Top → [3, 2, 1]
Output → Top → [1, 2, 3]

👉 Concept:
- Recursively pop all elements from the stack.
- When the stack becomes empty, start inserting each element
  back **at the bottom** (using a helper function).

✅ Two helper methods:
1. pushAtBottom() → Inserts an element at the bottom of the stack.
2. reverseStack() → Recursively reverses the stack.
*/

public class ReverseStack {

    // Helper function to print stack elements
    public static void printStack(Stack<Integer> stack) {
        while (!stack.isEmpty()) {
            System.out.println(stack.peek());
            stack.pop();
        }
    }

    // 🔹 Function to insert element at the bottom of stack
    public static void pushAtBottom(Stack<Integer> stack, int data) {
        // ✅ Base case: If stack is empty, push data
        if (stack.isEmpty()) {
            stack.push(data);
            return;
        }

        // 🔹 Step 1: Pop top element
        int top = stack.pop();

        // 🔹 Step 2: Recursively insert at bottom
        pushAtBottom(stack, data);

        // 🔹 Step 3: Push popped element back
        stack.push(top);
    }

    // 🔹 Function to reverse stack using recursion
    public static void reverseStack(Stack<Integer> stack) {
        // ✅ Base case: If stack is empty, stop recursion
        if (stack.isEmpty()) {
            return;
        }

        // 🔹 Step 1: Pop top element
        int top = stack.pop();

        // 🔹 Step 2: Reverse remaining stack
        reverseStack(stack);

        // 🔹 Step 3: Insert popped element at bottom
        pushAtBottom(stack, top);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        // Push elements into stack
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // Reverse the stack
        reverseStack(stack);

        // Print the reversed stack
        printStack(stack);
    }
}

/*
📌 Dry Run:
Initial Stack (top → bottom): [3, 2, 1]

Step 1: Pop 3 → reverse [2,1]
Step 2: Pop 2 → reverse [1]
Step 3: Pop 1 → reverse [] (base case)
→ pushAtBottom(1)
→ pushAtBottom(2)
→ pushAtBottom(3)

Final Stack (top → bottom): [1, 2, 3]

Output:
1
2
3

---

📊 Time Complexity:
O(n²) — Each recursive call performs O(n) work inside pushAtBottom().

📊 Space Complexity:
O(n) — Due to recursion stack depth.

✅ Concept Used:
Recursion + Stack Backtracking
*/
