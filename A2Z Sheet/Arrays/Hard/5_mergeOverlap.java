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

class Solution {
    public List<List<Integer>> mergeOverlap(List<List<Integer>> intervals) {
        int n = intervals.size();
        List<List<Integer>> ans = new ArrayList<>();

        if (n == 0) return ans;

        intervals.sort(Comparator.comparingInt(a -> a.get(0)));

        List<Integer> newInterval = new ArrayList<>(intervals.get(0));
        ans.add(newInterval);

        for (int i = 1; i < n; i++) {
            List<Integer> curr = intervals.get(i);

            if (curr.get(0) <= newInterval.get(1)) {
                newInterval.set(1, Math.max(newInterval.get(1), curr.get(1)));
            } else {
                newInterval = new ArrayList<>(curr);
                ans.add(newInterval);
            }
        }

        return ans;
    }
}

// Time: O(n log n)
// Space: O(1) (excluding result)