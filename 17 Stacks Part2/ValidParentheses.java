import java.util.*;

public class ValidParentheses {
    public static boolean isValid(String str) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char bracket = str.charAt(i);
            
            if (bracket == '(' || bracket == '{' || bracket == '[') {
                stack.push(bracket);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char topBracket = stack.peek();
                if ((bracket == ')' && topBracket == '(') ||
                    (bracket == '}' && topBracket == '{') ||
                    (bracket == ']' && topBracket == '[')) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

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
