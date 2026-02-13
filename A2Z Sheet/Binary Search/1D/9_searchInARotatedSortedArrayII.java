class Solution {
    public boolean searchInARotatedSortedArrayII(int[] nums, int k) {
        int start = 0;
        int end = nums.length -1;

        while(start <= end){
            int mid = start + (end - start)/2;

            if(nums[mid] == k){
                return true;
            }

            if(nums[start] == nums[mid] && nums[mid] == nums[end]){
                start++;
                end--;
                continue;
            }

            if(nums[start] <= nums[mid]){
                if(nums[start] <= k && k <= nums[mid]){
                    end = mid -1;
                } else {
                    start = mid +1;
                }
            } else {
                if(nums[start] <= k && k <= nums[end]){
                    start = mid +1;
                } else {
                    end = mid -1;
                }
            }
        }

        return false;
    }
}

// Time: O(logn)
// Space: O(1)