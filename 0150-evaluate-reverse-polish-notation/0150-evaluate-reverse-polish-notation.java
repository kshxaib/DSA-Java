class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> operands = new Stack<>();

        for(int i=0; i<tokens.length; i++){
            String token = tokens[i];

            if(token.equals("+") || token.equals("-") || token.equals("/") || token.equals("*")){
                int b = operands.pop();
                int a = operands.pop();

                int val = caculate(a, b, token);
                operands.push(val);
            } else {
                operands.push(Integer.parseInt(token));
            }
        }

        return operands.peek();
    }

    private int caculate(int a, int b, String operator){
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