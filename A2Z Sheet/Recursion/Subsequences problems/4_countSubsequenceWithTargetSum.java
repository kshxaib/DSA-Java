class Solution {
    public int countSubsequenceWithTargetSum(int[] nums, int k) {
        int index = 0;
        int sum = 0;
        return findCount(nums, index, sum, k);
    }

    public int findCount(int[] nums, int index, int sum, int k) {
        if (index == nums.length) {
            if(sum == k){
                return 1;
            } else {
                return 0;
            }
        }

        // pick
        int left = findCount(nums, index + 1, sum + nums[index], k);

        // not pick
        int right = findCount(nums, index + 1, sum, k);

        return left + right;
    }
}