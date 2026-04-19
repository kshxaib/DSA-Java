class Solution {
    public int sumSubarrayMins(int[] arr) {
        int mod = 1000000007;
        int n = arr.length;
        int sum = 0;

        int nse[] = findNSE(arr);
        int psee[] = findPSEE(arr);

        for(int i=0; i<n; i++){
            int left = i - nse[i];
            int right = psee[i] - i;

            int freq = left * right;
            int value = (int) ((freq * arr[i]) % mod);

            sum = ((sum + value) % mod);
        }

        return sum;
    }

    private int[] findNSE(int arr[]){
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int ans[] = new int[n];

        for(int i=n-1; i>=0; i--){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }

            if(stack.isEmpty()){
                ans[i] = n;
            }

            else {
                ans[i] = stack.peek();
            }

            stack.push(i);
        }

        return ans;
    }

    private int[] findPSEE(int arr[]){
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int ans[] = new int[n];

        for(int i=0; i<n; i++){
            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]){
                stack.pop();
            }

            if(stack.isEmpty()){
                ans[i] = -1;
            } 

            else {
                ans[i] = stack.peek();
            }

            stack.push(i);
        }

        return ans;
    }
}