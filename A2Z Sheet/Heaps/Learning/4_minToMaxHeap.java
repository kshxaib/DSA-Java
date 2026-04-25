class Solution {
    public int[] minToMaxHeap(int[] nums) {
        int n = nums.length;

        for(int i=n/2 -1; i>=0; i--){
            heapify(nums, n, i);
        }

        return nums;
    }

    public void heapify(int nums[], int n, int i){
        while(true){
            int largest = i;
            int left = 2 * i +1;
            int right = 2 * i +2;

            if(left < n && nums[left] > nums[largest]){
                largest = left;
            }

            if(right < n && nums[right] > nums[largest]){
                largest = right;
            }

            if(largest == i) break;

            swap(nums, i, largest);
            i = largest;
        }
    }

    public void swap(int nums[], int i, int largest){
        int temp = nums[i];
        nums[i] = nums[largest];
        nums[largest] = temp;
    }
}