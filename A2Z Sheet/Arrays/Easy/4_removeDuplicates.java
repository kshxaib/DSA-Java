class Solution {
    public int removeDuplicates(int[] nums) {
        int i=0;
        for(int j=1; j<nums.length; i++){
            if(nums[j] != nums[i]){
                i++;
                nums[i] = nums[j];
            }
        }

        return i+1;
    }
}

// Time: O(n)
// Space: O(1)