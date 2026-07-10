import java.util.*;

class Solution {
    public int[] shortestPath(int[][] edges, int N, int M) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<N; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int edge[] : edges){    // build undirected graph
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int dist[] = new int[N];    // stores shortest distance
        Arrays.fill(dist, -1);

        Queue<Integer> queue = new LinkedList<>();
        dist[0] = 0;    // source = 0
        queue.offer(0);

        while(!queue.isEmpty()){
            int node = queue.poll();

            for(int neighbour : adj.get(node)){
                if(dist[neighbour] == -1){              // not visited
                    dist[neighbour] = dist[node] + 1;  // Moving one edge ahead increases distance by 1
                    queue.offer(neighbour);
                }
            }
        }

        return dist;
    }
}
 