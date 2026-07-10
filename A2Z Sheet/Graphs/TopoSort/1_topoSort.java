import java.util.*;

class Solution {
    public int[] topoSort(int V, List<List<Integer>> adj) {
        boolean visited[] = new boolean[V]; // tracks visited nodes
        Stack<Integer> stack = new Stack<>();   // stores topo order

        for(int i=0; i<V; i++){
            if(!visited[i]){
                dfs(i, adj, visited, stack);
            }
        }

        int ans[] = new int[V];
        int index = 0;
        while(!stack.isEmpty()){
            ans[index++] = stack.pop();
        }

        return ans;
    }

    private void dfs(int node, List<List<Integer>> adj, boolean visited[],
        Stack<Integer> stack){

        visited[node] = true;

        for(int neighbour : adj.get(node)){
            if(!visited[neighbour]){
                dfs(neighbour, adj, visited, stack);
            }
        }

        // push after neighbours done
        stack.push(node);
    }
}