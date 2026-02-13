class Solution {
    public int search(int[] nums, int k) {
       int start = 0;
       int end = nums.length - 1;

       while(start <= end){
            int mid = start + (end - start)/2;

            if(nums[mid] == k){
                return mid;
            }

            if(nums[start] <= nums[mid]) {   
                if(nums[start] <= k && k < nums[mid]){
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {                         
                if(nums[mid] < k && k <= nums[end]){
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
       }

       return -1;
    }
}

// Time: O(logn)
// Space: O(1)