class Solution {
    public long subArrayRanges(int[] nums) {
        return findSumSubarrayMaxs(nums) - findSumSubarrayMins(nums);
    }

    private long findSumSubarrayMaxs(int[] nums) {
        int n = nums.length;
        int[] pgee = findPGEE(nums);
        int[] nge = findNGE(nums);

        long sum = 0;

        for (int i = 0; i < n; i++) {
            long left = i - pgee[i];
            long right = nge[i] - i;

            long freq = left * right;
            sum += freq * nums[i];
        }

        return sum;
    }

    private long findSumSubarrayMins(int[] nums) {
        int n = nums.length;
        int[] psee = findPSEE(nums);
        int[] nse = findNSE(nums);

        long sum = 0;

        for (int i = 0; i < n; i++) {
            long left = i - psee[i];
            long right = nse[i] - i;

            long freq = left * right;
            sum += freq * nums[i];
        }

        return sum;
    }

    private int[] findNSE(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                st.pop();
            }

            ans[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        return ans;
    }

    private int[] findNGE(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] <= nums[i]) {
                st.pop();
            }

            ans[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        return ans;
    }

    private int[] findPSEE(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] > nums[i]) {
                st.pop();
            }

            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        return ans;
    }

    private int[] findPGEE(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] < nums[i]) {
                st.pop();
            }

            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        return ans;
    }
}