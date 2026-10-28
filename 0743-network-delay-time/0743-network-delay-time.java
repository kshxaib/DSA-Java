class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // [[u] -> [v, w]]
        List<List<int []>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
        }

        for(int edge[] : times){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            adj.get(u).add(new int[] {v, wt});
        }

        int dist[] = new int[n +1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        // [distance, node]
        PriorityQueue<int []> pq = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );
        pq.offer(new int[] {0, k});

        while(!pq.isEmpty()){
            int pair[] = pq.poll();
            int currDistance = pair[0];
            int node = pair[1];

            for(int neighbor[] : adj.get(node)){
                int v = neighbor[0];
                int wt = neighbor[1];

                if(currDistance + wt < dist[v]){
                    dist[v] = currDistance + wt;
                    pq.offer(new int[] {dist[v], v});
                }
            }
        }

        int answer = 0;
        for(int i=1; i<=n; i++){
            if(dist[i] == Integer.MAX_VALUE){
                return -1;
            }

            answer = Math.max(answer, dist[i]);
        }

        return answer;
    }
}