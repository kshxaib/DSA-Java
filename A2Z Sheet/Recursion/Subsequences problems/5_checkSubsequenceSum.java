class Solution {
    public boolean checkSubsequenceSum(int[] nums, int k) {
        int index = 0;
        int sum = 0;
        if(checkSum(nums, index, sum, k) == true){
            return true;
        }

        return false;
    }

    public boolean checkSum(int nums[], int index, int sum, int k){
        if(index == nums.length){
            if(sum == k){
                return true;
            }
            return false;
        }

        sum += nums[index];
        if(checkSum(nums, index +1, sum, k) == true){
            return true;
        }

        sum -= nums[index];
        if(checkSum(nums, index +1, sum, k) == true){
            return true;
        }

        return false;
    }
}