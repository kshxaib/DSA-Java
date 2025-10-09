import java.util.*;

// Problem: Push an element at the bottom of the stack using recursion
/*
📌 Problem Statement:
Given a stack and an integer `data`, insert `data` at the **bottom** of the stack
(using only stack operations and recursion).

Example:
Input stack (top → bottom): 3, 2, 1
Insert: 4
Output stack (top → bottom): 3, 2, 1, 4

👉 Constraint:
- You cannot use any extra data structure (only recursion and stack operations).

✅ Idea (Recursion):
1. If the stack is empty → push `data` (base case).
2. Otherwise:
   - Pop the top element.
   - Recursively call `pushAtBottom` for remaining stack.
   - Push the popped element back on top.

This ensures the new element goes to the **bottom**, 
and all others are restored above it.
*/

public class PushAtTheBottomOfStack {

    // Recursive function to insert element at the bottom
    public static void pushAtBottom(Stack<Integer> stack, int data) {
        // ✅ Base case: If stack is empty, push data
        if (stack.isEmpty()) {
            stack.push(data);
            return;
        }

        // 🔹 Step 1: Pop the top element
        int top = stack.pop();

        // 🔹 Step 2: Recursively call for the rest of the stack
        pushAtBottom(stack, data);

        // 🔹 Step 3: Push the stored element back on top
        stack.push(top);
    }

    public static void main(String[] args) {
        // Create a stack and push elements
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // Insert 4 at the bottom
        pushAtBottom(stack, 4);

        // Print stack elements (top → bottom)
        while (!stack.isEmpty()) {
            System.out.println(stack.peek());
            stack.pop();
        }
    }
}

/*
📌 Dry Run:

Initial Stack (top → bottom): [3, 2, 1]
Insert data = 4

Step-by-step recursion:
1. pop 3 → call pushAtBottom([2,1],4)
2. pop 2 → call pushAtBottom([1],4)
3. pop 1 → call pushAtBottom([],4)
4. stack empty → push(4)
   Now stack: [4]
5. push(1) → stack: [1,4]
6. push(2) → stack: [2,1,4]
7. push(3) → stack: [3,2,1,4]

Output:
3
2
1
4

---

📊 Time Complexity:
O(n) — Each recursive call processes one element.

📊 Space Complexity:
O(n) — Due to recursion stack (n elements deep).

✅ Concept Used:
Recursion + Stack Backtracking
*/
