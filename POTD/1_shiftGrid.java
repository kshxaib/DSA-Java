class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int total = n * m;

        k = k % total;

        reverse(grid, 0, total -1, n);
        reverse(grid, 0, k-1, n);
        reverse(grid, k, total -1, n);

        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0; i<m; i++){
            List<Integer> row = new ArrayList<>();

            for(int j=0; j<n; j++){
                row.add(grid[i][j]);
            }

            ans.add(row);
        }

        return ans;
    }

    private void reverse(int grid[][], int i, int j, int cols){
        while(i < j){
            int r1 = i / cols;
            int c1 = i % cols;

            int r2 = j / cols;
            int c2 = j % cols;

            int temp = grid[r1][c1];
            grid[r1][c1] = grid[r2][c2];
            grid[r2][c2] = temp;

            i++;
            j--;
        }
    }
}