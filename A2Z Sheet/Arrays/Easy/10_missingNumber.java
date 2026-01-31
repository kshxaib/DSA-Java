class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int actualSum = 0;
        for(int i=0; i<n; i++){
            actualSum += nums[i];
        }

        int exactSum = n * (n +1)/2;

        int missing = exactSum - actualSum;
        return missing;
    }
}

// Time: O(n)
// Space: O(1)