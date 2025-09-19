import java.util.*;

public class ReapeatedAndMissing_2965 {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int size = n * n;
        int[] freq = new int[size + 1]; 
        int repeated = 0, missing = 0;

        // Count frequencies
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                freq[grid[i][j]]++;
            }
        }

        // Find repeated & missing
        for (int i = 1; i <= size; i++) {
            if (freq[i] == 0) {
                missing = i;
            } else if (freq[i] == 2) {
                repeated = i;
            }
        }

        return new int[]{repeated, missing};
    }

    public int[] findMissingAndRepeatedValues2(int[][] grid){
        int n = grid.length;
        int size = n * n;
        int repeatedElement = 0;
        int actualSum = 0;
        Set<Integer> set = new HashSet<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                actualSum += grid[i][j];
                if(set.contains(grid[i][j])){
                    repeatedElement = grid[i][j];
                } else {
                    set.add(grid[i][j]);
                }
            }
        }

        int expectedSum = size * (size + 1) /2;
        int missingElement = expectedSum + repeatedElement - actualSum;
        int result[] = {repeatedElement, missingElement};
        return result;
    }
}
