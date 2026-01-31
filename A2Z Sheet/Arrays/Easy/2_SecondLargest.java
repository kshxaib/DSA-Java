class Solution {
    public int secondLargestElement(int[] nums) {
        int largest = nums[0];
        int secondL = -1;

        for(int i=1; i<nums.length; i++){
            if(nums[i] == largest){
                continue;
            }

            if(nums[i] > largest){
                secondL = largest;
                largest = nums[i];
            } else if(nums[i] > secondL){
                secondL = nums[i];
            }
        }

        return secondL;
    }
}

// Time: O(n)
// Space: O(1)