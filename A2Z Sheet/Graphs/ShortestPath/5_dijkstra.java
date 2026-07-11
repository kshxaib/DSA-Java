import java.util.*;

class Solution {
    public int[] dijkstra(int V, ArrayList<ArrayList<Integer>> edges, int S){
        List<List<int[]>> adj = new ArrayList<>();  // adjacency list storing {node, weight}
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }

        // build undirected weighted graph
        for(ArrayList<Integer> edge : edges){
            int u = edge.get(0);
            int v = edge.get(1);
            int wt = edge.get(2);

            adj.get(u).add(new int[]{v, wt});
            adj.get(v).add(new int[]{u, wt});
        }

        int dist[] = new int[V];     // stores shortest distance
        Arrays.fill(dist, (int)1e9);

        dist[S] = 0;     // source distance

        // min heap storing {distance,node}
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> a[0] - b[0]
        );

        pq.offer(new int[]{0, S});

        while(!pq.isEmpty()){
            int pair[] = pq.poll();
            int distance = pair[0];
            int node = pair[1];

            // relaxation: found shorter path
            for(int neighbour[] : adj.get(node)){
                int adjNode = neighbour[0];
                int weight = neighbour[1];

                // relaxation
                if(distance + weight < dist[adjNode]){
                    dist[adjNode] = distance + weight;
                    pq.offer(new int[]{ dist[adjNode], adjNode});
                }
            }
        }

        return dist;
    }
}