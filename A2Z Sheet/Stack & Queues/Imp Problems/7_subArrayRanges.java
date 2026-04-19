/*
        SUM OF SUBARRAY RANGES

Definition:
For every subarray:

Range = Maximum Element - Minimum Element

Return sum of ranges of all subarrays.


Example

Input:
nums = [1,2,3]

Subarrays:

[1]       range = 0
[2]       range = 0
[3]       range = 0
[1,2]     range = 1
[2,3]     range = 1
[1,2,3]   range = 2

Total = 4

Output:
4


Core Idea (Contribution Technique)

Instead of generating all subarrays O(n²),

We calculate:

Total Contribution as Maximum
-
Total Contribution as Minimum


Time Complexity: O(n)
Each helper stack runs linear time

Space Complexity: O(n)
*/

class Solution {
    public long subArrayRanges(int[] nums) {
        return findSumSubarrayMaxs(nums) - findSumSubarrayMins(nums);
    }

    // sum of all subarray maximums
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

    // sum of all subarray minimums
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

    // next smaller element
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

    // next greater element
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

    // previous smaller or equal
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

    // previous greater or equal
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