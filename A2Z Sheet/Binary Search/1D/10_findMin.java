class Solution {
    public int findMin(ArrayList<Integer> arr) {
        int min = Integer.MAX_VALUE;

        int start = 0;
        int end = arr.size() -1;

        while(start <= end){
            int mid = start + (end - start) /2;

            if(arr.get(start) <= arr.get(mid)){
                min = Math.min(arr.get(start), min);
                start = mid + 1;
            } else {
                min = Math.min(arr.get(mid), min);
                end = mid -1;
            }
        }

        return min;
    }
}

// Time: O(logn)
// Space: O(1)