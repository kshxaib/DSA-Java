import java.util.*;

class Solution {
    class Edge {
        int u;
        int v;
        int weight;

        Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
    }

    class DisjointSet {
        List<Integer> parent = new ArrayList<>();
        List<Integer> rank = new ArrayList<>();

        DisjointSet(int n) {
            for (int i = 0; i < n; i++) {
                parent.add(i);
                rank.add(0);
            }
        }

        int findParent(int node) {
            if (node == parent.get(node)) {
                return node;
            }

            int ultimateParent = findParent(parent.get(node));
            parent.set(node, ultimateParent);
            return parent.get(node);
        }

        void unionByRank(int u, int v) {
            int ultimateParentU = findParent(u);
            int ultimateParentV = findParent(v);

            if (ultimateParentU == ultimateParentV) {
                return;
            }

            if (rank.get(ultimateParentU) < rank.get(ultimateParentV)) {
                parent.set(ultimateParentU, ultimateParentV);
            }

            else if (rank.get(ultimateParentU) > rank.get(ultimateParentV)) {
                parent.set(ultimateParentV, ultimateParentU);
            }

            else {
                parent.set(ultimateParentV, ultimateParentU);
                rank.set(ultimateParentU, rank.get(ultimateParentU) + 1);
            }
        }
    }

    public int spanningTree(int V, List<List<List<Integer>>> adj) {
        List<Edge> edges = new ArrayList<>();

        // Convert adjacency list to edge list
        for (int u = 0; u < V; u++) {
            for (List<Integer> neighbour : adj.get(u)) {

                int v = neighbour.get(0);
                int weight = neighbour.get(1);

                // Avoid duplicate edges
                if (u < v) {
                    edges.add(new Edge(u, v, weight));
                }
            }
        }

        // Sort edges by weight
        Collections.sort(edges, (a, b) -> a.weight - b.weight);

        DisjointSet ds = new DisjointSet(V);

        int mstWeight = 0;

        for (Edge edge : edges) {   // process edges
            int u = edge.u; 
            int v = edge.v;
            int weight = edge.weight;

            if (ds.findParent(u) != ds.findParent(v)) { // no cycle
                mstWeight += weight;
                ds.unionByRank(u, v);   // merge components
            }
        }

        return mstWeight;
    }
}