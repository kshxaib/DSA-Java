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

    public List<Integer> numOfIslands(int n, int m, int[][] A) {
        DisjointSet ds = new DisjointSet(n * m);

        boolean[][] visited = new boolean[n][m];

        List<Integer> ans = new ArrayList<>();

        int islands = 0;

        int dRow[] = {-1, 0, 1, 0};
        int dCol[] = {0, 1, 0, -1};

        for(int operation[] : A) {  // process each operation
            int row = operation[0];
            int col = operation[1];

            if(visited[row][col]) {     // Already land
                ans.add(islands);
                continue;
            }

            visited[row][col] = true;
            islands++;  // new land creates a new island

            int node = row * m + col;  // DSU node number

            for(int i = 0; i < 4; i++) {    // check all 4 neighbours
                int newRow = row + dRow[i];
                int newCol = col + dCol[i];

                // valid neighbouring land
                if(newRow>=0 && newRow<n && newCol>=0 && newCol<m && visited[newRow][newCol]) {
                    int adjNode = newRow * m + newCol;  // convert neighbour cell into DSU node

                    if(ds.findParent(node) != ds.findParent(adjNode)) {
                        ds.unionByRank(node, adjNode);  // merge two different islands
                        islands--;
                    }
                }
            }

            ans.add(islands);
        }

        return ans;
    }
}