class Solution {
    public int connectSticks(List<Integer> sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<sticks.size(); i++){
            pq.add(sticks.get(i));
        }

        int cost = 0;
        while(pq.size() > 1){
            int s1 = pq.remove();
            int s2 = pq.remove();

            int sum = s1 + s2;
            cost = cost + sum;
            pq.add(sum);
        }

        return cost;
    }
}