class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int maxSubarraySum = Integer.MIN_VALUE;

        for(int i=0; i<nums.length; i++){
            sum += nums[i];

            maxSubarraySum = Math.max(maxSubarraySum, sum);

            if(sum < 0){
                sum = 0;
            }
        }

        return maxSubarraySum;
    }
}

// Time: O(n)
// Space: O(1)