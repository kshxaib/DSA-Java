/*
        MERGE OVERLAPPING INTERVALS
        (SORTING + GREEDY MERGING)

Problem:
Given a list of intervals where each interval is
[start, end], merge all overlapping intervals.

Example:
intervals = [[1,3],[2,6],[8,10],[15,18]]

Output:
[[1,6],[8,10],[15,18]]

Explanation:
[1,3] and [2,6] overlap → merged into [1,6]


Core Idea:
If intervals are sorted by start time,
overlapping intervals will appear next to each other.

So we:
1. Sort intervals by start time
2. Traverse intervals
3. Merge when overlap occurs


Overlap Condition:
Two intervals overlap if:
start₂ ≤ end₁

Example:
[1,3]
[2,6]

Since:
2 ≤ 3

They overlap.

Algorithm Steps:

1. Sort intervals based on start value.

2. Add the first interval to result.

3. Traverse remaining intervals:

      If current.start ≤ previous.end
            merge intervals
            update end = max(end₁, end₂)

      Else
            add new interval


Complexities:
Time Complexity  : O(n log n)  (due to sorting)
Space Complexity : O(1)  (excluding output)

Properties:
- Uses sorting
- Greedy interval merging
- Classic interval problem

Key Interview Points:
• Sorting ensures overlapping intervals are adjacent
• Always compare with last merged interval
• Update end using max()
*/

// Time: O(n log n)
// Space: O(n) 

import java.util.*;

class Solution {
    public int[][] merge( int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> merged = new ArrayList<>();
        merged.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] last = merged.get(merged.size() - 1);

            if (intervals[i][0] <= last[1]) {
                last[1] = Math.max(last[1], intervals[i][1]);
            } else {
                merged.add(intervals[i]);
            }
        }

        return merged.toArray(new int[merged.size()][2]);
    }
}


