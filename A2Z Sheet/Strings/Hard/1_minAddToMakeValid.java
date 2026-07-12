import java.util.*;

class Solution {
    public int minAddToMakeValidBrute(String s) {

        while (true) {
            String newStr = s.replace("()", "");
            if (newStr.equals(s))
                break;
            s = newStr;
        }

        return s.length();
    }

    public int minAddToMakeValidBetter(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == '(' && ch == ')') {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }

        return stack.size();
    }

    public int minAddToMakeValid(String s) {
        int open = 0;
        int close = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                open++;
            } else {
                if (open > 0) {
                    open--;
                } else {
                    close++;
                }
            }
        }

        return open + close;
    }
}
