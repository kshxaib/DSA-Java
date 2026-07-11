import java.util.*;

class Solution {
    public int countPaths(int n, int[][] roads) {
        List<List<int[]>> adj = new ArrayList<>();  // adjacency list storing {neighbour, travel time}

        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int road[] : roads){    // build undirected weighted graph
            int u = road[0];
            int v = road[1];
            int time = road[2];

            adj.get(u).add(new int[] {v, time});
            adj.get(v).add(new int[] {u, time});
        }

        long dist[] = new long[n];          // build undirected weighted graph
        Arrays.fill(dist, Long.MAX_VALUE);

        long ways[] = new long[n];  // ways[i] = number of shortest paths to reach node i
        Arrays.fill(ways, 0);

        dist[0] = 0;
        ways[0] = 1;

        int MOD = (int) 1e9 +7;

        // {current distance, node} always process minimum distance first
        PriorityQueue<long[]> pq = new PriorityQueue<>(
            Comparator.comparingLong(a -> a[0])
        );

        pq.offer(new long[] {0, 0});

        while(!pq.isEmpty()){
            long pair[] = pq.poll();
            long currDistance = pair[0];
            int node = (int) pair[1];

            for(int neighbour[] : adj.get(node)){   // explore all neighbours
                int adjNode = neighbour[0];
                int time = neighbour[1];

                long newDistance = currDistance + time;
                if(newDistance < dist[adjNode]){     // shorter path found
                    dist[adjNode] = newDistance;    // update shortest distance
                    ways[adjNode] = ways[node];      // all shortest paths now come through current node

                    pq.offer(new long[] {newDistance, adjNode});    
                }

                else if(newDistance == dist[adjNode]){       // another shortest path found
                    ways[adjNode] = (ways[adjNode] + ways[node]) % MOD; // add number of ways from current node
                }
            }
        }

        return (int)ways[n-1];  // number of shortest paths
    }
}