class Solution {
    public int countOccurrences(int[] arr, int target) {
        int n = arr.length;

        int start = starting(arr, target);
        if(start == n || arr[start] != target){
            return 0;
        }

        int end = ending(arr, target);
        int count = end - start;
        return count;
    }

    private int starting(int arr[], int target){
        int start = 0;
        int end = arr.length -1;
        int ans = arr.length;

        while(start <= end){
            int mid = start + (end - start)/2;
            if(arr[mid] >= target){
                ans = mid;
                end = mid -1;
            } else {
                start = mid +1;
            }
        }

        return ans;
    }

    private int ending(int arr[], int target){
        int start = 0;
        int end = arr.length -1;
        int ans = arr.length;

        while(start <= end){
            int mid = start + (end - start)/2;
            if(arr[mid] > target){
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
