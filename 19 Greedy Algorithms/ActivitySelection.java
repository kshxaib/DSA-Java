// Problem: Activity Selection Problem

import java.util.*;

public class ActivitySelection {

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

    public static void main(String args[]) {
        int start[] = {0, 1, 3, 5, 8, 5};
        int end[] = {6, 2, 4, 7, 9, 9};

        System.out.println("Selected Activity Indices: " + findActivity(start, end));
    }
}

/*
Time Complexity:
- Sorting: O(n log n)
- Selection: O(n)
Total = O(n log n)

Space Complexity: O(n)
- For storing activity details
*/
