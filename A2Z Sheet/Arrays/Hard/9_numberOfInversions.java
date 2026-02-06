class Solution {
    private long merge(int nums[], int low, int mid, int high){
        int temp[] = new int[high - low + 1];

        int i = low;
        int j = mid +1;
        int k = 0;

        long count = 0;

        while(i<=mid && j<=high){
            if(nums[i] <= nums[j]){
                temp[k] = nums[i];
                i++;
            } else {
                temp[k] = nums[j];
                count += (mid - i + 1);
                j++;
            }
            k++;
        }

        while(i<=mid){
            temp[k] = nums[i];
            i++;
            k++;
        }

        while(j<=high){
            temp[k] = nums[j];
            j++;
            k++;
        }

        for(int x=low; x<=high; x++){
            nums[x] = temp[x-low];
        }

        return count;
    }

    private long mergeSort(int nums[], int low, int high){
        long count = 0;

        if(low >= high){
            return count;
        }

        int mid = low + (high - low)/2;
        count += mergeSort(nums, low, mid);
        count += mergeSort(nums, mid+1, high);
        count += merge(nums, low, mid, high);

        return count;
    }

    public long numberOfInversions(int[] nums) {
        int n = nums.length;

        return mergeSort(nums, 0, n-1);
    }
}

// Time: O(nlogn)
// Space: O(1)
