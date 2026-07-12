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

    public int removeStones(int[][] stones) {
        int n = stones.length;

        DisjointSet ds = new DisjointSet(n);

        for(int i = 0; i < n; i++) {    // compare every pair of stones
            for(int j = i + 1; j < n; j++) {

                // same row or same column
                if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {

                    ds.unionByRank(i, j);
                }
            }
        }

        int connectedComponents = 0;    
        for(int i = 0; i < n; i++) {    // count components
            if(ds.findParent(i) == i) {
                connectedComponents++;
            }
        }

        return n - connectedComponents; // remove all stones except one per component
    }
}