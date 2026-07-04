import java.util.*;

class Solution {

    public int[][] merge(int[][] intervals) {
        // Sort intervals according to start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // Stores final merged intervals
        List<int[]> merged = new ArrayList<>();

        merged.add(intervals[0]);   // Add first interval

        // Traverse remaining intervals
        for(int i = 1; i < intervals.length; i++){
            int[] lastInterval = merged.get(merged.size() - 1); // Last interval in answer list

            int currentStart = intervals[i][0];
            int currentEnd = intervals[i][1];

            // Overlapping intervals
            if(currentStart <= lastInterval[1]){
                lastInterval[1] = Math.max( lastInterval[1], currentEnd);   // Extend ending time
            }
            else{   
                merged.add(intervals[i]);   // Non-overlapping interval
            }
        }

        // Convert List<int[]> into int[][]
        return merged.toArray(new int[merged.size()][2]);
    }
}