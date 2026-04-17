class Solution {
    public String prefixToInfix(String s) {
        Stack<String> stack = new Stack<>();

        // traverse from right to left
        for(int i = s.length() - 1; i >= 0; i--){
            char ch = s.charAt(i);

            // operand
            if(Character.isLetterOrDigit(ch)){
                stack.push(ch + "");
            }
            // operator
            else{
                String op1 = stack.pop();
                String op2 = stack.pop();

                String expr = "(" + op1 + ch + op2 + ")";
                stack.push(expr);
            }
        }

        return stack.peek();
    }
}