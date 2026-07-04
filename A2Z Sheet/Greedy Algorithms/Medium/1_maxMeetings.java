/*
        N MEETINGS IN ONE ROOM

Definition:
Given two arrays:

start[i] = starting time of ith meeting
end[i]   = ending time of ith meeting

Only one meeting can be performed
at a time.

Return the maximum number of meetings
that can be accommodated in one room.


Example 1

Input:

start = [1,3,0,5,8,5]
end   = [2,4,6,7,9,9]

Output:
4


Meetings:

(1,2)
(3,4)
(0,6)
(5,7)
(8,9)
(5,9)

Select:

(1,2)
(3,4)
(5,7)
(8,9)

Total = 4


Algorithm

1. Store meetings as:

   [end, start, index]

2. Sort by end time.

3. Select first possible meeting.

4. If current meeting starts
   after last selected meeting ends:

      take it.


Why This Works
Meeting with earliest ending time
gives maximum remaining time
for future meetings.

Greedy choice is always optimal.


Time Complexity: O(n log n)
Creating meetings list: O(n)
Sorting: O(n log n)
Traversal: O(n)

Space Complexity: O(n)
*/
import java.util.*;

class Solution {
    public int maxMeetings(int[] start, int[] end) {
        int n = start.length;

        // store: [startTime, endTime]
        List<int[]> meetings = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            meetings.add( new int[]{start[i], end[i]});
        }

        // sort by ending time
        Collections.sort(meetings, (a, b) -> a[1] - b[1]);

        int totalMeeting = 0;
        int lastEnd = -1;   // end time of last selected meeting
        int i = 0;

        while(i < n) {
            int currMeeting[] = meetings.get(i);
            if(lastEnd < currMeeting[0]) {   // current meeting can be scheduled
                totalMeeting++;
                lastEnd = currMeeting[1];   // update last ending time
            }
            i++;
        }

        return totalMeeting;
    }
}