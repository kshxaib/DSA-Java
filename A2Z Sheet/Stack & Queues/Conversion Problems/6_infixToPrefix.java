class Solution {

    public String infixToPrefix(String s) {

        // Step 1: reverse string
        s = reverse(s);

        // Step 2: swap brackets
        s = swapBrackets(s);

        // Step 3: convert to postfix
        String postfix = infixToPostfix(s);

        // Step 4: reverse postfix → prefix
        return reverse(postfix);
    }

    // reverse string
    private String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    // swap '(' and ')'
    private String swapBrackets(String s) {
        StringBuilder res = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (ch == '(') res.append(')');
            else if (ch == ')') res.append('(');
            else res.append(ch);
        }

        return res.toString();
    }

    // infix → postfix (same as before)
    private String infixToPostfix(String s) {
        StringBuilder ans = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {

            // operand
            if (Character.isLetterOrDigit(ch)) {
                ans.append(ch);
            }

            // opening bracket
            else if (ch == '(') {
                stack.push(ch);
            }

            // closing bracket
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    ans.append(stack.pop());
                }
                stack.pop();
            }

            // operator
            else {
                if(ch == '^'){
                    while(!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())){
                        ans.append(stack.pop());
                    }  
                } else {
                    while(!stack.isEmpty() && precedence(ch) < precedence(stack.peek())){
                        ans.append(stack.pop());
                    }
                }
                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) {
            ans.append(stack.pop());
        }

        return ans.toString();
    }

    private int precedence(char ch) {
        if (ch == '+' || ch == '-') return 1;
        if (ch == '*' || ch == '/') return 2;
        if (ch == '^') return 3;
        return -1;
    }
}