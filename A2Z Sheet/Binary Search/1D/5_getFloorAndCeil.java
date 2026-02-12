class Solution {
    public int[] getFloorAndCeil(int[] nums, int x) {
        int start = 0;
        int end = nums.length -1;

        int flr = floor(nums, start, end, x);
        int cl = ceil(nums, start, end, x);

        return new int[] {flr, cl};
    }

    private int floor(int nums[], int start, int end, int x){
        int ans = -1;
        while(start <= end){
            int mid = start + (end - start) /2;

            if(nums[mid] <= x){
                ans = nums[mid];
                start = mid +1;
            } else {
                end = mid -1;
            }
        }

        return ans;
    }

    private int ceil(int nums[], int start, int end, int x){
        int ans = -1;
        while(start <= end){
            int mid = start + (end - start) /2;

            if(nums[mid] >= x){
                ans = nums[mid];
                end = mid -1;
            } else {
                start = mid +1;
            }
        }

        return ans;
    }
}

// Time: O(nlogn)
// Space: O(1)
