import java.util.*;

class Solution {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;

        List<int[]> result = new ArrayList<>();
        int index = 0;

        // 1. Add intervals before newInterval
        while(index < n && intervals[index][1] < newInterval[0]){
            result.add(intervals[index]);
            index++;
        }

        // 2. Merge overlapping intervals
        while(index < n && intervals[index][0] <= newInterval[1]){
            newInterval[0] = Math.min(newInterval[0], intervals[index][0]); // Update starting point
            newInterval[1] = Math.max(newInterval[1], intervals[index][1]); // Update ending point
            index++;
        }
        result.add(newInterval);    // Add merged new interval

        // 3. Add remaining intervals
        while(index < n){
            result.add(intervals[index]);
            index++;
        }

        return result.toArray(new int[result.size()][2]);
    }
}