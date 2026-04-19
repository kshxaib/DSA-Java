class Solution {
    public int[] stockSpan(int[] arr, int n) {
        int ans[] = new int[n];
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<n; i++){
            while(!stack.isEmpty() && arr[stack.peek()] <= arr[i]){
                stack.pop();
            }

            if(stack.isEmpty()){
                ans[i] = i+1;
            }
            else{
                ans[i] = i - stack.peek();
            }
            
            stack.push(i);
        }

        return ans;
    }
}

