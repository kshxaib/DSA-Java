import java.util.*;

class Solution {

    class DisjointSet {
        List<Integer> parent = new ArrayList<>();
        List<Integer> size = new ArrayList<>();

        DisjointSet(int n) {
            for (int i = 0; i < n; i++) {
                parent.add(i);
                size.add(1);
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

        void unionBySize(int u, int v) {
            int ultimateParentU = findParent(u);
            int ultimateParentV = findParent(v);

            if (ultimateParentU == ultimateParentV) {
                return;
            }
            if (size.get(ultimateParentU) < size.get(ultimateParentV)) {
                parent.set(ultimateParentU, ultimateParentV);
                size.set(ultimateParentV, size.get(ultimateParentU) + size.get(ultimateParentV));
            } else {
                parent.set(ultimateParentV, ultimateParentU);
                size.set(ultimateParentU, size.get(ultimateParentU) + size.get(ultimateParentV));
            }
        }
    }

    public int largestIsland(int[][] grid) {
        int n = grid.length;

        DisjointSet ds = new DisjointSet(n * n);

        int dRow[] = {-1, 0, 1, 0};
        int dCol[] = {0, 1, 0, -1};

        // Build all islands
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 0) {
                    continue;
                }

                int node = row * n + col;   // convert cell into DSU node

                for (int i = 0; i < 4; i++) {
                    int newRow = row + dRow[i];
                    int newCol = col + dCol[i];

                    if (newRow>=0 && newRow<n && newCol>=0 && newCol<n && grid[newRow][newCol]==1) {
                        int adjNode = newRow * n + newCol;  
                        ds.unionBySize(node, adjNode);  // build all existing islands
                    }
                }
            }
        }

        int maxIsland = 0;

        // Try converting every 0 into 1
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1) {
                    continue;
                }

                Set<Integer> parents = new HashSet<>(); // unique neighbouring islands

                for (int i = 0; i < 4; i++) {
                    int newRow = row + dRow[i];
                    int newCol = col + dCol[i];

                    if (newRow>=0 && newRow<n && newCol>=0 && newCol<n && grid[newRow][newCol]==1) {
                        int adjNode = newRow * n + newCol;
                        parents.add(ds.findParent(adjNode));    // collect unique island parents
                    }
                }

                int islandSize = 1; // current 0 becomes land

                for (int parent : parents) {    // merge neighbouring islands
                    islandSize += ds.size.get(parent);
                }

                maxIsland = Math.max(maxIsland, islandSize);       // max size
            }
        }
        
        for (int i = 0; i < n * n; i++) {   // Edge case: grid already full of 1's
            if (ds.findParent(i) == i) {
                maxIsland = Math.max(maxIsland, ds.size.get(i));
            }
        }

        return maxIsland;
    }
}