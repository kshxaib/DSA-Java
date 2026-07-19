import java.util.*;

class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> stack = new Stack<>();

        for (char ch : expression.toCharArray()) {
            if (ch == ',') continue;

            else if (ch != ')') stack.push(ch);

            else {
                int trueCount = 0;
                int falseCount = 0;

                while (stack.peek() != '(') {
                    char curr = stack.pop();

                    if (curr == 't') trueCount++;
                    else falseCount++;
                }
                stack.pop(); // remove '('

                char operator = stack.pop();

                if (operator == '!') {
                    if (falseCount == 1)
                        stack.push('t');
                    else
                        stack.push('f');

                } else if (operator == '&') {
                    if (falseCount > 0)
                        stack.push('f');
                    else
                        stack.push('t');

                } else {
                    if (trueCount > 0)
                        stack.push('t');
                    else
                        stack.push('f');
                }
            }
        }

        return stack.peek() == 't';
    }
}