class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<n; i++){
            char digit = num.charAt(i);

            while(!stack.isEmpty() && (k>0) && stack.peek() > digit){
                stack.pop();
                k--;
            }

            stack.push(digit);
        }
        while(k>0){
                stack.pop();
                k--;
            }

            if(stack.isEmpty()) return "0";
            
            StringBuilder ans = new StringBuilder();
            while(!stack.isEmpty()){
                ans.append(stack.pop());
            }

            while(ans.length() > 0 && (ans.charAt(ans.length() -1) == '0')){
                ans.deleteCharAt(ans.length() -1);
            }

            ans.reverse();

            if(ans.length() == 0) return "0";

        return ans.toString();
    }
}