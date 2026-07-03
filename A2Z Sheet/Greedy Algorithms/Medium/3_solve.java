import java.util.*;

class Solution {
    public long solve(int[] bt) {

        // Shortest jobs first
        Arrays.sort(bt);


        long totalWaiting = 0;

        // Current elapsed time
        long currentTime = 0;


        for (int i = 0; i < bt.length; i++) {

            // Current process waits till currentTime
            totalWaiting += currentTime;


            // Execute current process
            currentTime += bt[i];
        }


        return totalWaiting / bt.length;
    }
}