class Solution {
    public int findKRotation(ArrayList<Integer> nums) {
        int min = Integer.MAX_VALUE;
        int start = 0;
        int end = nums.size() -1;
        int minIdx = -1;

        while(start <= end){
            int mid = start + (end - start)/2;

            if(nums.get(start) <= nums.get(mid)){
                if(nums.get(start) < min){
                    min = nums.get(start);
                    minIdx = start;
                }
                start = mid +1;
            } else {
                if(nums.get(mid) < min){
                    min = nums.get(mid);
                    minIdx = mid;
                }
                end = mid -1;
            }
        }

        return minIdx;
    }
}

// Time: O(logn)
// Space: O(1)
