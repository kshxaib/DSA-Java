class Solution {
    public int upperBound(int[] nums, int x) {
        int start = 0;
        int end = nums.length -1;
        int ans = nums.length;

        while(start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid] > x){
                ans = mid;
                end = mid -1;
            } else {
                start = mid +1;
            }
        }

        return ans;
    }
}

// Time: O(nlogn)
// Time: O(1)