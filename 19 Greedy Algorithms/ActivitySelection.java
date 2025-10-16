// Problem: Activity Selection Problem
/*
This program solves the classic "Activity Selection" problem using a greedy approach.

Goal:
Select the maximum number of non-overlapping activities that can be performed by a single person,
given their start and end times.

Concept:
1. Sort all activities based on their end times (earliest finishing activity first).
2. Always pick the activity that finishes earliest among the remaining compatible ones.
3. Continue selecting the next activity whose start time is >= end time of the last selected one.

Example:
Input:
start = [0, 1, 3, 5, 8, 5]
end   = [6, 2, 4, 7, 9, 9]

Output:
Selected Activity Indices: [1, 2, 3, 4]

Key Idea:
Use a greedy approach — always choose the next activity that ends earliest and does not overlap
with the previously chosen activity.
*/

import java.util.*;

public class ActivitySelection {

    // Function to find maximum set of non-overlapping activities
    public static ArrayList<Integer> findActivity(int start[], int end[]) {
        int n = start.length;
        int activities[][] = new int[n][3]; // Each activity stores {index, start, end}

        // Step 1: Store all activities with their indices
        for (int i = 0; i < n; i++) {
            activities[i][0] = i;       // index
            activities[i][1] = start[i]; // start time
            activities[i][2] = end[i];   // end time
        }

        // Step 2: Sort activities based on end time using lambda comparator
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));

        // Step 3: Select the first activity (earliest end)
        ArrayList<Integer> selectedActivities = new ArrayList<>();
        selectedActivities.add(activities[0][0]); // Store index of first activity
        int lastEnd = activities[0][2];            // End time of last selected activity

        // Step 4: Select next activities that start after the last selected one ends
        for (int i = 1; i < n; i++) {
            if (activities[i][1] >= lastEnd) {
                selectedActivities.add(activities[i][0]);
                lastEnd = activities[i][2];
            }
        }

        return selectedActivities;
    }

    // Function for already sorted input (by end time)
    public static ArrayList<Integer> findAct(int start[], int end[]) {
        int n = start.length;
        ArrayList<Integer> selected = new ArrayList<>();

        selected.add(0);           // Select first activity
        int lastEnd = end[0];      // End time of last selected activity

        // Select next activities
        for (int i = 1; i < n; i++) {
            if (start[i] >= lastEnd) {
                selected.add(i);
                lastEnd = end[i];
            }
        }

        return selected;
    }

    // Main method to test the program
    public static void main(String args[]) {
        int start[] = {0, 1, 3, 5, 8, 5};
        int end[] = {6, 2, 4, 7, 9, 9};

        System.out.println("Selected Activity Indices: " + findActivity(start, end));
    }
}

/*
Dry Run:
Input:
start = [0, 1, 3, 5, 8, 5]
end   = [6, 2, 4, 7, 9, 9]

After Sorting by end time:
Activities = [[1,1,2], [2,3,4], [3,5,7], [0,0,6], [4,8,9], [5,5,9]]

Step 1: Pick activity 1 (ends at 2)
Step 2: Next start >= 2 → pick activity 2 (ends at 4)
Step 3: Next start >= 4 → pick activity 3 (ends at 7)
Step 4: Next start >= 7 → pick activity 4 (ends at 9)
Output: [1, 2, 3, 4]

Time Complexity:
- Sorting: O(n log n)
- Selection: O(n)
Total = O(n log n)

Space Complexity: O(n)
- For storing activity details

Concept Used:
- Greedy algorithm
- Sorting based on end time
- Optimal activity selection strategy
*/
