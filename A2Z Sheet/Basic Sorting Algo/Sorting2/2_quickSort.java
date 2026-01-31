class Solution {
    public int[] quickSort(int[] nums) {
        int start = 0;
        int end = nums.length -1;
        
        performQS(nums, start, end);
        return nums;
    }

    private int partition(int nums[], int start, int end){
        int pivot = nums[end];
        int i = start -1;

        for(int j=start; j<end; j++){
            if(nums[j] <= pivot){
                i++;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }

        i++;
        nums[end] = nums[i];
        nums[i] = pivot;

        return i;
    }

    private void performQS(int nums[], int start, int end){
        if(start >= end){
            return;
        }

        int pIdx = partition(nums, start, end);
        performQS(nums, start, pIdx -1);
        performQS(nums, pIdx +1, end);
    }
}

// Time: O(nlogn)
// Space: O(1)
