class Solution {
    public String postToPre(String postfix) {
        Stack<String> stack = new Stack<>();

        for(int i=0; i<postfix.length(); i++){
            char ch = postfix.charAt(i);

            if(Character.isLetterOrDigit(ch)){
                stack.push(ch + "");
            } else {
                String op2 = stack.pop();
                String op1 = stack.pop();

                String expr = ch + op1 + op2;
                stack.push(expr);
            }
        }

        return stack.pop();
    }
}