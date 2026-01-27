class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        HashSet<Integer> set = new HashSet<>();
        int n = grid.length;
        int totalElmts = n*n;

        int sum = 0;
        int ans[] = new int[2];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(set.contains(grid[i][j])){
                    ans[0] = grid[i][j];
                } else {
                    set.add(grid[i][j]);
                    sum += grid[i][j];
                }
            }
        }

        int exactSum = totalElmts * (totalElmts + 1) /2;
        int missing = exactSum - sum;
        ans[1] = missing;

        return ans;
    }
}

// Time: O(n^2)
// Space: O(n^2)