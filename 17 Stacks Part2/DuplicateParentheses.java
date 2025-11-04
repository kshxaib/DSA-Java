import java.util.*;

// Problem: Duplicate Parentheses Checker

public class DuplicateParentheses {

    // Function to detect duplicate parentheses
    public static boolean isDuplicate(String str) {
        Stack<Character> stack = new Stack<>();

        // Traverse the expression one character at a time
        for (int i = 0; i < str.length(); i++) {
            char currentChr = str.charAt(i);

            // Push all characters except ')'
            if (currentChr != ')') {
                stack.push(currentChr);
            } else {
                // On encountering ')', check content inside the matching '('
                int countElement = 0;

                while (!stack.isEmpty() && stack.peek() != '(') {
                    stack.pop();
                    countElement++;
                }

                // If no characters inside '()', then it's a duplicate
                if (countElement == 0) {
                    return true;
                }

                // Pop the matching '('
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
        }

        // If no duplicate parentheses found
        return false;
    }

    public static void main(String args[]) {
        String str = "((a+b))";
        System.out.println("Duplicate parentheses? " + isDuplicate(str)); // Output: false
    }
}

/*
📊 Time Complexity:
O(n) — Each character is pushed and popped from the stack at most once.

📊 Space Complexity:
O(n) — Stack uses space proportional to input size.
*/
