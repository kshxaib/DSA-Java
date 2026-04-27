class Solution {
    public int kthLargestElement(int[] nums, int k) {
        Arrays.sort(nums);

        return nums[nums.length -k];
    }


    public int kthLargestElement(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<k; i++){
            pq.add(nums[i]);
        }

        for(int i=k; i<nums.length; i++){
            int ele = nums[i];
            if(ele > pq.peek()){
                pq.remove();
                pq.add(ele);
            }
        }

        return pq.peek();
    }
}