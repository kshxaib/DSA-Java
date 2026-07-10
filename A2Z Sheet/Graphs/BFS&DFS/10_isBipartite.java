import java.util.*;

class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;

        int color[] = new int[n];
        Arrays.fill(color, -1); // -1 means no color assigned

        // graph may have multiple components
        for(int i=0; i<n; i++){
            if(color[i] == -1){
                if(!bfs(i, graph, color)){
                    return false;
                }
            }
        }

        return true;
    }

    private boolean bfs(int start, int graph[][], int color[]){
        Queue<Integer> queue = new LinkedList<>();
        color[start] = 0;   // give starting color
        queue.offer(start);

        while(!queue.isEmpty()){
            int node = queue.poll();

            for(int neighbour : graph[node]){
                if(color[neighbour] == -1){      // not colored
                    color[neighbour] = 1- color[node];  // assign opposite color
                    queue.offer(neighbour);
                }

                else if(color[neighbour] == color[node]){   // same color conflict
                    return false;
                }
            }
        }

        return true;
    }
}