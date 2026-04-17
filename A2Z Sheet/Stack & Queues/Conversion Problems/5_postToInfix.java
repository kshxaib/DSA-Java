class Solution {
    public String postToInfix(String postExp) {
        Stack<String> stack = new Stack<>();

        for(int i=0; i<postExp.length(); i++){
            char ch = postExp.charAt(i);

            if(Character.isLetterOrDigit(ch)){
                stack.push(ch + "");
            } else {
                String op2 = stack.pop();
                String op1 = stack.pop();

                String expr = "(" + op1 + ch + op2 + ")";
                stack.push(expr);
            }
        }

        return stack.peek();
    }
}
