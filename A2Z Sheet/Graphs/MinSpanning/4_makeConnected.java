import java.util.*;

class Solution {

    class DisjointSet {
        List<Integer> parent = new ArrayList<>();
        List<Integer> rank = new ArrayList<>();

        DisjointSet(int n) {
            for(int i = 0; i < n; i++) {
                parent.add(i);
                rank.add(0);
            }
        }

        int findParent(int node) {
            if(node == parent.get(node)) {
                return node;
            }

            int ultimateParent = findParent(parent.get(node));
            parent.set(node, ultimateParent);
            return parent.get(node);
        }

        void unionByRank(int u, int v) {
            int ultimateParentU = findParent(u);
            int ultimateParentV = findParent(v);

            if(ultimateParentU == ultimateParentV) {
                return;
            }
            if(rank.get(ultimateParentU) < rank.get(ultimateParentV)) {
                parent.set(ultimateParentU, ultimateParentV);
            }
            else if(rank.get(ultimateParentU) > rank.get(ultimateParentV)) {
                parent.set(ultimateParentV, ultimateParentU);
            }
            else {
                parent.set(ultimateParentV, ultimateParentU);
                rank.set(ultimateParentU, rank.get(ultimateParentU) + 1);
            }
        }
    }

    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds = new DisjointSet(n);

        int extraEdges = 0;

        // process every cable 
        for(int edge[] : connections) {
            int u = edge[0];
            int v = edge[1];

            if(ds.findParent(u) == ds.findParent(v)) {  // cable forms a cycle, can be reused later
                extraEdges++;
            }
            else {
                ds.unionByRank(u, v);   // merge components
            }
        }

        int connectedComponents = 0;    // count components
        for(int i = 0; i < n; i++) {
            if(ds.findParent(i) == i) {
                connectedComponents++;
            }
        }

        int requiredEdges = connectedComponents - 1;    // minimum cables needed
        
        if(extraEdges >= requiredEdges) {   // enough extra cables
            return requiredEdges;
        }

        return -1;
    }
}