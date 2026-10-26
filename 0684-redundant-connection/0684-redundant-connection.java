class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
        }

        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];

            boolean visited[] = new boolean[n+1];
            if(dfs(adj, visited, u, v)){
                return edge;
            }

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        return new int[] {};
    }

    private boolean dfs(List<List<Integer>> adj, boolean[] visited, int u, int v){
        visited[u] = true;

        if(u == v){
            return true;
        }

        for(int neighbor : adj.get(u)){
            if(!visited[neighbor]){
                if(dfs(adj, visited, neighbor, v)){
                    return true;
                }
            }
        }

        return false;   
    }
}