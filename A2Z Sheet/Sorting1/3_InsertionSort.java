class Solution {
    public int[] insertionSort(int[] nums) {
        int n = nums.length;
        
        for(int i=1; i<n; i++){
            int curr = nums[i];
            int prev = i -1;

            while(prev >= 0 && nums[prev] > curr){
                nums[prev+1] = nums[prev];
                prev--;
            }

            nums[prev+1] = curr;
        }
        
    return nums;
    }
}

// Time: O(n^2)
// Space: O(1)