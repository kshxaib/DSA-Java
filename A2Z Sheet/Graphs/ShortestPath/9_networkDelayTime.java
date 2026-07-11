import java.util.*;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();  // adjacency list storing {node, weight}

        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
        }

        // build directed graph
        for(int edge[] : times){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            adj.get(u).add(new int[]{v, wt});
        }

        int dist[] = new int[n + 1];    // shortest time to every node
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[k] = 0;    // source distance

        // {distance, node}
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );
        pq.offer(new int[]{0, k});

        while(!pq.isEmpty()){
            int pair[] = pq.poll();
            int currDistance = pair[0];
            int node = pair[1];

            for(int neighbour[] : adj.get(node)){   // explore all outgoing edges
                int adjNode = neighbour[0];
                int weight = neighbour[1];

                // relaxation: found shorter time
                if(currDistance + weight < dist[adjNode]){
                    dist[adjNode] = currDistance + weight;
                    pq.offer(new int[]{dist[adjNode], adjNode});
                }
            }
        }

        int answer = 0;     // stores total network delay
        for(int i=1; i<=n; i++){
            if(dist[i] == Integer.MAX_VALUE){   // unreachable node
                return -1;
            }

            answer = Math.max(answer, dist[i]); // last node decides answer
        }

        return answer;
    }
}