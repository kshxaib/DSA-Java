import java.util.*;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int countNonOverlapping = 0;
        int lastEnd = Integer.MIN_VALUE;
        int i = 0;

        while(i < n){
            int currInterval[] = intervals[i];
            if(lastEnd <= currInterval[0]){
                countNonOverlapping++;
                lastEnd = currInterval[1];
            }

            i++;
        }

        int removedIntervals  = n - countNonOverlapping;
        return removedIntervals ;
    }
}