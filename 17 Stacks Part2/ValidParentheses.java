import java.util.*;

// ✅ Problem: Valid Parentheses Checker
/*
📌 Problem Statement:
Given a string containing just the characters `(`, `)`, `{`, `}`, `[` and `]`,
determine if the input string is **valid**.

An input string is valid if:
1. Open brackets are closed by the same type of brackets.
2. Open brackets are closed in the correct order.
3. Every closing bracket has a corresponding open bracket before it.

Example:
Input  → "({})[]"
Output → true (valid)

Input  → "([)]"
Output → false (invalid)

👉 Concept:
- Use a **stack** to keep track of opening brackets.
- When a **closing bracket** is encountered, check if the top of the stack
  contains the matching **opening bracket**.
- If it doesn't match, or the stack is empty, the string is invalid.
- In the end, the stack should be empty if all brackets matched correctly.
*/

public class ValidParentheses {

    // 🔹 Function to check if a string has valid parentheses
    public static boolean isValid(String str) {
        Stack<Character> stack = new Stack<>();  // Stack to store opening brackets

        for (int i = 0; i < str.length(); i++) {
            char bracket = str.charAt(i);

            // 🔸 If it's an opening bracket, push to stack
            if (bracket == '(' || bracket == '{' || bracket == '[') {
                stack.push(bracket);
            } else {
                // 🔸 If stack is empty, there's no matching opening bracket
                if (stack.isEmpty()) {
                    return false;
                }

                char topBracket = stack.peek(); // Top of stack

                // 🔸 Check if top of stack matches current closing bracket
                if ((bracket == ')' && topBracket == '(') ||
                    (bracket == '}' && topBracket == '{') ||
                    (bracket == ']' && topBracket == '[')) {
                    stack.pop(); // Matching pair found, remove from stack
                } else {
                    return false; // Mismatched brackets
                }
            }
        }

        // 🔸 If stack is empty, all brackets matched; otherwise, invalid
        return stack.isEmpty();
    }

    public static void main(String args[]) {
        String str = "({})[]";  // ✅ Try changing input to test different cases

        if (isValid(str)) {
            System.out.println("✅ It's valid parentheses.");
        } else {
            System.out.println("❌ It's not valid parentheses.");
        }
    }
}

/*
📌 Dry Run:
Input: "({})[]"

Stack process:
- '(' → push → stack: ['(']
- '{' → push → stack: ['(', '{']
- '}' → match with '{' → pop → stack: ['(']
- ')' → match with '(' → pop → stack: []
- '[' → push → stack: ['[']
- ']' → match with '[' → pop → stack: []

✅ Final stack: empty → valid string

---

📊 Time Complexity:
O(n) — Each character is processed once.

📊 Space Complexity:
O(n) — Stack space for storing opening brackets.

✅ Concept Used:
Stack + Bracket Matching
*/
