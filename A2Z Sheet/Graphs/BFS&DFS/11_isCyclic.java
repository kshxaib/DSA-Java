import java.util.*;

class Solution {
    public boolean isCyclic(int N, List<List<Integer>> adj) {
        boolean visited[] = new boolean[N];  // visited anytime before
        boolean pathVisited[] = new boolean[N]; // visited in current path

        for(int i=0; i<N; i++){ // check every component
            if(!visited[i]){
                if(dfs(i, adj, visited, pathVisited)){
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(int node, List<List<Integer>> adj, boolean[] visited, boolean[] pathVisited){
        visited[node] = true;   // check every component
        pathVisited[node] = true;   // add to current path

        for(int neighbour : adj.get(node)){
            // new node
            if(!visited[neighbour]){
                if(dfs(neighbour, adj, visited, pathVisited)){
                    return true;
                }
            }

            // already visited in same path
            else if(pathVisited[neighbour]){
                return true;
            }
        }

        // remove while backtracking
        pathVisited[node] = false;
        return false;
    }
}
