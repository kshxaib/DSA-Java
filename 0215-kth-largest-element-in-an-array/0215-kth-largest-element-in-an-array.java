class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<k; i++){
            pq.add(nums[i]);
        }

        for(int i=k; i<nums.length; i++){
            int curr = nums[i];

            if(curr > pq.peek()){
                pq.remove();
                pq.add(curr);
            }
        }

        return pq.peek();
    }
}