class Solution {
    public int findCircleNum(int[][] isConnected) {
        int V = isConnected.length;
        boolean visited[] = new boolean[V];
        int provinces = 0;

        for(int i=0; i<V; i++){
            if(!visited[i]){
                provinces++;

                dfs(i, isConnected, visited);
            }
        }

        return provinces;
    }

    private void dfs(int node, int[][] adj, boolean visited[]) {
        visited[node] = true;

        for(int neighbour=0; neighbour<adj.length; neighbour++){
            if(adj[node][neighbour] == 1 && !visited[neighbour]){
                dfs(neighbour, adj, visited);
            }
        }
    }
}

