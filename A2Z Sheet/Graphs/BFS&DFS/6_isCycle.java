import java.util.*;

class Solution {
    public boolean isCycle(int V, List<Integer>[] adj) {
        boolean visited[] = new boolean[V];

        // graph can have multiple components
        for(int i=0; i<V; i++){
            if(!visited[i]){
                if(dfs(i, -1, adj, visited)){
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(int node, int parent, List<Integer>[] adj, boolean visited[]){
        visited[node] = true;
        for(int neighbour : adj[node]){
            if(!visited[neighbour]){
                if(dfs(neighbour, node, adj, visited)){
                    return true;
                }
            }

            else if(neighbour != parent){
                return true;
            }
        }


        return false;
    }
}
