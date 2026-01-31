class Solution {
    public int largestElement(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            if(nums[i] > max){
                max = nums[i];
            }
        }

        return max;
    }
}

// Time: O(n)
// Space: O(1)