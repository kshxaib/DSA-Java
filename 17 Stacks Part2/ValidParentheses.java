import java.util.*;

// Problem: Valid Parentheses Checker

public class ValidParentheses {

    // Function to check if a string has valid parentheses
    public static boolean isValid(String str) {
        Stack<Character> stack = new Stack<>();  // Stack to store opening brackets

        for (int i = 0; i < str.length(); i++) {
            char bracket = str.charAt(i);

            // If it's an opening bracket, push to stack
            if (bracket == '(' || bracket == '{' || bracket == '[') {
                stack.push(bracket);
            } else {
                // If stack is empty, there's no matching opening bracket
                if (stack.isEmpty()) {
                    return false;
                }

                char topBracket = stack.peek(); // Top of stack

                // Check if top of stack matches current closing bracket
                if ((bracket == ')' && topBracket == '(') ||
                    (bracket == '}' && topBracket == '{') ||
                    (bracket == ']' && topBracket == '[')) {
                    stack.pop(); // Matching pair found, remove from stack
                } else {
                    return false; // Mismatched brackets
                }
            }
        }

        // If stack is empty, all brackets matched; otherwise, invalid
        return stack.isEmpty();
    }

    public static void main(String args[]) {
        String str = "({})[]";  

        if (isValid(str)) {
            System.out.println("It's valid parentheses.");
        } else {
            System.out.println("It's not valid parentheses.");
        }
    }
}

/*
📊 Time Complexity:
O(n) — Each character is processed once.

📊 Space Complexity:
O(n) — Stack space for storing opening brackets.
*/
