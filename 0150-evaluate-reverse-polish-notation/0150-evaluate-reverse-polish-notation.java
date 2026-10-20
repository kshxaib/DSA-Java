class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(String token : tokens){
            if(token.equals("+") || token.equals("-") || token.equals("/") || token.equals("*")){
                int b = stack.pop();
                int a = stack.pop();

                int val = operate(a, b, token);
                stack.push(val);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.peek();
    }

    private int operate(int a, int b, String operator){
        if(operator.equals("+")){
            return a + b;
        } else if (operator.equals("-")){
            return a - b;
        } else if(operator.equals("*")) {
            return a * b;
        } else {
            return a / b;
        }
    }
}