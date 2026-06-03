class KthLargest {
    PriorityQueue<Integer> pq;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>();

        for(int i=0; i<nums.length; i++){
            add(nums[i]);
        }
    }
    
    public int add(int val) {
        if(pq.size() < k || val > pq.peek()){
            pq.add(val);

            if(pq.size() > k){
                pq.remove();
            }
        }

        return pq.peek();
    }
}
