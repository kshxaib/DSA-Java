class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        int sum = 0;
        boolean visited[] = new boolean[n];

        // [weight, node]
        PriorityQueue<int []> pq = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );

        pq.offer(new int[] {0, 0});

        while(!pq.isEmpty()){
            int curr[] = pq.poll();
            int wt = curr[0];
            int node = curr[1];

            if(visited[node]){
                continue;
            }

            visited[node] = true;
            sum += wt;

            for(int neighbor = 0; neighbor < n; neighbor++){
                if(!visited[neighbor]){
                    int edgeWt = Math.abs(points[node][0] - points[neighbor][0]) + Math.abs(points[node][1] - points[neighbor][1]);
                    pq.offer(new int[] {edgeWt, neighbor});
                }
            }
        }

        return sum;
    }
}