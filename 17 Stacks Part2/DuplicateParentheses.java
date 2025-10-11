import java.util.*;

// ✅ Problem: Duplicate Parentheses Checker
/*
📌 Problem Statement:
Given a valid expression string, check if it contains **duplicate (redundant) parentheses**.
Duplicate parentheses mean there is a pair of brackets with **nothing or no useful expression inside**.

Examples:
Input  → "(a)"        → false (not duplicate)
Input  → "((a+b))"    → true  (outer parentheses are redundant)
Input  → "(a+(b)/c)"  → false
Input  → "((a))"      → true

👉 Approach:
- Use a stack to track characters of the expression.
- Push every character to the stack **except closing parentheses `)`**.
- When we encounter `)`, check how many characters are inside the corresponding `(`.
  - If **zero**, it's duplicate like `"()"`.
  - If only a variable or a single operand (like `"a"`), it's **not duplicate** if we want to be strict.
*/

public class DuplicateParentheses {

    // 🔹 Function to detect duplicate parentheses
    public static boolean isDuplicate(String str) {
        Stack<Character> stack = new Stack<>();

        // 🔁 Traverse the expression one character at a time
        for (int i = 0; i < str.length(); i++) {
            char currentChr = str.charAt(i);

            // 🔸 Push all characters except ')'
            if (currentChr != ')') {
                stack.push(currentChr);
            } else {
                // 🔸 On encountering ')', check content inside the matching '('
                int countElement = 0;

                // ❗ BUG FIX: must check stack is not empty before accessing peek()
                // ❗ Also, peek should be updated in the loop
                while (!stack.isEmpty() && stack.peek() != '(') {
                    stack.pop();
                    countElement++;
                }

                // 🔸 If no characters inside '()', then it's a duplicate
                if (countElement == 0) {
                    return true;
                }

                // 🔸 Pop the matching '('
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
        }

        // 🔸 If no duplicate parentheses found
        return false;
    }

    public static void main(String args[]) {
        // ✅ Test case: should return false (not duplicate)
        String str = "(a)";
        System.out.println("Duplicate parentheses? " + isDuplicate(str)); // Output: false

        // You can try other test cases:
        // String str = "((a+b))";  // Expected: true
        // String str = "(a+(b)/c)"; // Expected: false
        // String str = "((a))";     // Expected: true
    }
}

/*
📌 Dry Run: str = "(a)"
Stack process:
- Push '(' → stack = ['(']
- Push 'a' → stack = ['(', 'a']
- Encounter ')' → pop 'a' (count = 1), then pop '(' → count != 0 → not duplicate

✅ Result: false

---

📊 Time Complexity:
O(n) — Each character is pushed and popped from the stack at most once.

📊 Space Complexity:
O(n) — Stack uses space proportional to input size.

🔁 Revision Tips:
- Focus on when you pop from the stack: what are you checking?
- Be cautious about using `peek()` — avoid calling it before checking `isEmpty()`.
- Try modifying to detect **only empty** brackets `"()"`, or **outer redundant** brackets separately.

✅ Concepts Used:
- Stack
- Bracket matching
- Expression parsing
*/
