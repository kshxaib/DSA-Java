class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;

        int lb = lowerBound(nums, target);
        if(lb == n || nums[lb] != target){
            return new int[] {-1, -1};
        }

        int up = upperBound(nums, target) -1;
        return new int[] {lb, up};
    }

    private int lowerBound(int nums[], int target){
        int start = 0;
        int end = nums.length -1;
        int ans = nums.length;

        while(start <= end){
            int mid = start + (end - start)/2;

            if(nums[mid] >= target){
                ans = mid;
                end = mid -1;
            } else {
                start = mid +1;
            }
        }

        return ans;
    }

    private int upperBound(int nums[], int target){
        int start = 0;
        int end = nums.length -1;
        int ans = nums.length;

        while(start <= end){
            int mid = start + (end - start)/2;

            if(nums[mid] > target){
                ans = mid;
                end = mid -1;
            } else {
                start = mid +1;
            }
        }

        return ans;
    }
}

// Time: O(logn)
// Space: O(1)