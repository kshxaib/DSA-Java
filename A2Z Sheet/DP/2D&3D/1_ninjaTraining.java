import java.util.*;

class Solution1 {
    public int ninjaTraining(int[][] matrix) {
        int n = matrix.length;
        // last = 0,1,2 and 3 means no previous activity
        int dp[][] = new int[n][4];
        
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }

        return solve(n-1, 3, matrix, dp);
    }

    private int solve(int day, int lastTask, int matrix[][], int dp[][]){
        if(day == 0){   // first day
            int max = 0;
            for(int task=0; task<3; task++){
                if(task != lastTask){
                    max = Math.max(max, matrix[day][task]);
                }
            }

            return max;
        }

        if(dp[day][lastTask] != -1){    // already computed
            return dp[day][lastTask];
        }

        int max = 0;
        for(int task=0; task<3; task++){    // try every allowed task
            if(task != lastTask){
                int points = matrix[day][task] + solve(day-1, task, matrix, dp);
                max = Math.max(max, points);
            }
        }

        return dp[day][lastTask] = max; // store answer
    }
}


class Solution2 {
    public int ninjaTraining(int[][] matrix) {
        int n = matrix.length;

        // dp[day][lastTask]
        // lastTask = 0,1,2 and 3 means no restriction
        int[][] dp = new int[n][4];


        // If last task was (0), choose max of task 1 or 2
        dp[0][0] = Math.max(matrix[0][1], matrix[0][2]);

        // If last task was (1), choose max of task 0 and 2
        dp[0][1] = Math.max(matrix[0][0], matrix[0][2]);

        // If last task was (2), choose max of task 0 and 1
        dp[0][2] = Math.max(matrix[0][0], matrix[0][1]);

        // No previous task
        dp[0][3] = Math.max(matrix[0][0], Math.max(matrix[0][1], matrix[0][2]));


        for (int day = 1; day < n; day++) {
            for (int lastTask = 0; lastTask < 4; lastTask++) {

                dp[day][lastTask] = 0;
                int max = 0;

                // Try every task except lastTask
                for (int task = 0; task < 3; task++) {
                    if (task != lastTask) {
                        int points = matrix[day][task] + dp[day - 1][task];
                        max = Math.max(max, points);
                    }
                }

                dp[day][lastTask] = max;
            }
        }

        return dp[n - 1][3];
    }
}


class Solution3 {
    public int ninjaTraining(int[][] matrix) {
        int n = matrix.length;

        int[] prev = new int[4];    // prev[lastTask]

        // base cases
        prev[0] = Math.max(matrix[0][1], matrix[0][2]);
        prev[1] = Math.max(matrix[0][0], matrix[0][2]);
        prev[2] = Math.max(matrix[0][0], matrix[0][1]);
        prev[3] = Math.max(matrix[0][0], Math.max(matrix[0][1], matrix[0][2]));

        // Fill DP 
        for (int day = 1; day < n; day++) {
            int[] curr = new int[4];

            for (int lastTask = 0; lastTask < 4; lastTask++) {
                curr[lastTask] = 0;
                int max = 0;
                
                for (int task = 0; task < 3; task++) {  // Try every task except lastTask
                    if (task != lastTask) {
                        int points = matrix[day][task] + prev[task];
                        max = Math.max(max, points);
                    }
                }

                curr[lastTask] = max;
            }
            
            prev = curr;    // Move current row to previous row
        }

        return prev[3];
    }
}