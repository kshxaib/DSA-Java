import java.util.*;

class Solution {
    public int[] JobScheduling(int[][] Jobs) {
        int maxDeadline = -1;   // Find maximum deadline for slot array size
        for(int i = 0; i < Jobs.length; i++){
            maxDeadline = Math.max(maxDeadline, Jobs[i][1]);
        }

        // Create time slots -1 means empty
        int hash[] = new int[maxDeadline + 1];
        Arrays.fill(hash, -1);

        // Sort jobs by maximum profit first
        Arrays.sort(Jobs, (a, b) -> b[2] - a[2]);

        int totalProfit = 0;
        int countJob = 0;

        // Try scheduling every job
        for(int i = 0; i < Jobs.length; i++){
            int jobDeadline = Jobs[i][1];

            // Find latest available slot
            for(int j = jobDeadline; j > 0; j--){
                if(hash[j] == -1){
                    hash[j] = Jobs[i][0];   // Store job id                    
                    totalProfit += Jobs[i][2];  // Add profit
                    countJob++; // Count completed job
                    break;
                }
            }
        }


        return new int[]{countJob, totalProfit};
    }
}