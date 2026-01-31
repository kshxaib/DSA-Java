class Solution {
    public int[] mergeSort(int[] nums) {
        int start = 0;
        int end = nums.length -1;

        perforMS(nums, start, end);
        return nums;
    }

    private void perforMS(int nums[], int start, int end){
        if(start >= end){
            return;
        }

        int mid = start + (end - start)/2;
        perforMS(nums, start, mid);
        perforMS(nums, mid +1, end);
        merge(nums, start, mid, end);
    }

    private void merge(int nums[], int start, int mid, int end){
        int temp[] = new int[end - start + 1];
        int i = start;
        int j = mid +1;
        int k = 0;

        while(i<=mid && j<=end){
            if(nums[i] < nums[j]){
                temp[k] = nums[i];
                i++;
            } else {
                temp[k] = nums[j];
                j++;
            }
            k++;
        }

        while(i<=mid){
            temp[k] = nums[i];
            i++;
            k++;
        }

        while(j<=end){
            temp[k] = nums[j];
            j++;
            k++;
        }

        for(int x=start; x<=end; x++){
            nums[x] = temp[x-start];
        }
    }
}

// Time: O(nlogn)
// Space: O(n)