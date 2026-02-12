class Solution {
    public int search(int[] nums, int target) {
       int start = 0;
       int end = nums.length -1;

       return BS(nums, start, end, target);
    }

    private int BS(int nums[], int start, int end, int target){
        if(start > end){
            return -1;
        }

        int mid = start + (end - start) / 2;
        if(nums[mid] == target){
            return mid;
        }

        if(nums[mid] < target){
            return BS(nums, mid+1, end, target);
        } else {
            return BS(nums, start, mid-1, target);
        }
    }
}

// Time: O(nlogn)
// Space: O(1)
