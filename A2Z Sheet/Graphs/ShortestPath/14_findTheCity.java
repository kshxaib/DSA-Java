import java.util.*;

class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int dist[][] = new int[n][n];   // dist[i][j] = shortest distance from i to j

        // initialize distance matrix
        for(int i = 0; i < n; i++){
            Arrays.fill(dist[i], (int)1e9);
            dist[i][i] = 0;  // distance to itself
        }

        // build undirected weighted graph
        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            dist[u][v] = wt;
            dist[v][u] = wt;
        }

        // Floyd-Warshall: try every node as intermediate
        for(int via=0; via<n; via++){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    // relaxation
                    dist[i][j] = Math.min(dist[i][j], dist[i][via] + dist[via][j]);
                }
            }
        }

        int city = -1;
        int minReachableCites = Integer.MAX_VALUE;

        for(int i=0; i<n; i++){     // check every city

            int countReachableCities = 0;
            for(int j=0; j<n; j++){

                if(dist[i][j] <= distanceThreshold){     // count cities reachable within threshold
                    countReachableCities++;
                }
            }

            // update answer "<=" keeps larger index in case of tie
            if(countReachableCities <= minReachableCites){
                minReachableCites = countReachableCities;
                city = i;
            }
        }

        return city;
    }
}