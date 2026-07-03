import java.util.*;

class Solution {
    public long solve(int[] bt) {
        Arrays.sort(bt);    // Shortest jobs first

        long totalWaiting = 0;
        long currentTime = 0;   // Current elapsed time

        for (int i = 0; i < bt.length; i++) {
            // Current process waits till currentTime
            totalWaiting += currentTime;

            // Execute current process
            currentTime += bt[i];
        }

        return totalWaiting / bt.length;
    }
}

