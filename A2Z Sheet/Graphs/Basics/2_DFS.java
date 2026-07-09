import java.util.*;

class Solution {
    public List<Integer> dfsOfGraph(int V, List<List<Integer>> adj) {
        List<Integer> dfs = new ArrayList<>();
        boolean visited[] = new boolean[V];

        // Start DFS from node 0
        dfsHelper(0, adj, visited, dfs);
        return dfs;
    }

    private void dfsHelper(int node, List<List<Integer>> adj, boolean visited[], List<Integer> dfs){
        dfs.add(node);
        visited[node] = true;

        for(Integer neighbour : adj.get(node)){
            if(!visited[neighbour]){
                dfsHelper(neighbour, adj, visited, dfs);
            }
        }
    }
}