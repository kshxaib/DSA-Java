import java.util.*;

class Solution {
    public boolean isCycle(int V, List<Integer>[] adj) {
        boolean visited[] = new boolean[V];

        // because graph can have multiple components
        for(int i=0; i<V; i++){
            if(!visited[i]){
                if(bfs(i, adj, visited)){
                    return true;
                }
            }
        }

        return false;
    }

    private boolean bfs(int start, List<Integer>[] adj, boolean visited[]){
        // stores {node,parent}
        Queue<int[]> queue = new java.util.LinkedList<>();
        queue.offer(new int[]{start, -1});
        visited[start] = true;

        while(!queue.isEmpty()){
            int pair[] = queue.poll();
            int node = pair[0];
            int parent = pair[1];

            for(int neighbour: adj[node]){
                if(!visited[neighbour]){
                    visited[neighbour] = true;
                    queue.offer(new int[]{neighbour, node});
                } 
                // visited but not parent
                else if(neighbour != parent){
                    return true;
                }
            }
        }

        return false;
    }
}
