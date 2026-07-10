import java.util.*;

class Solution {
    public int[] shortestPath(int N, int M, int[][] edges) {
        List<List<int[]>> adj = new ArrayList<>();  // adjacency list storing {node, weight}
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }

        // build weighted DAG
        for (int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            adj.get(u).add(new int[] { v, wt });
        }

        boolean visited[] = new boolean[N];
        Stack<Integer> stack = new Stack<>();   // stores topological order

        // topo sort
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                dfs(i, adj, visited, stack);
            }
        }

        int dist[] = new int[N];    // stores topological order
        Arrays.fill(dist, Integer.MAX_VALUE);

        // source distance
        dist[0] = 0;

        // process nodes in topo order
        while (!stack.isEmpty()) {
            int node = stack.pop();

            if (dist[node] != Integer.MAX_VALUE) {       // skip unreachable nodes
                for (int neighbour[] : adj.get(node)) {
                    int adjNode = neighbour[0];
                    int weight = neighbour[1];

                    if (dist[node] + weight < dist[adjNode]) {   // edge relaxation
                        dist[adjNode] = dist[node] + weight;
                    }
                }
            }
        }

        // convert unreachable nodes
        for (int i = 0; i < N; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1;
            }
        }

        return dist;

    }

    private void dfs(int node, List<List<int[]>> adj, boolean visited[], Stack<Integer> stack) {
        visited[node] = true;

        for (int neighbour[] : adj.get(node)) {
            int adjNode = neighbour[0];

            if (!visited[adjNode]) {
                dfs(adjNode, adj, visited, stack);
            }
        }

        stack.push(node);
    }
}