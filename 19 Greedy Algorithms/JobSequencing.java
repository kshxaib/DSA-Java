// Problem: Job Sequencing Problem (Greedy Algorithm)

import java.util.*;

public class JobSequencing {

    public static ArrayList<Integer> findMaxValue(int jobs[][]) {
        // Step 1: Sort jobs based on profit (ascending order initially)
        Arrays.sort(jobs, Comparator.comparingDouble(o -> o[1]));

        ArrayList<Integer> jobTaken = new ArrayList<>(); // Stores profit of selected jobs
        int time = 0;       // Tracks scheduled time slots
        int maxValue = 0;   // Tracks total profit

        // Step 2: Select jobs greedily (start from highest profit)
        for (int i = jobs.length - 1; i >= 0; i--) {
            // If job can be scheduled before its deadline
            if (jobs[i][0] > time) {
                jobTaken.add(jobs[i][1]); // Add profit to taken jobs
                maxValue += jobs[i][1];   // Add profit to total
                time++;                    // Increment time slot
            }
        }

        System.out.println("Maximum profit: " + maxValue);
        return jobTaken;
    }

    // Main method to test the program
    public static void main(String[] args) {
        // Each job: {deadline, profit}
        int jobs[][] = { {4, 20}, {1, 10}, {1, 40}, {1, 30} };

        System.out.println("Selected jobs (profits): " + findMaxValue(jobs));
    }
}

/*
Time Complexity: O(n log n)
- Sorting takes O(n log n)
- Scheduling loop takes O(n)

Space Complexity: O(n)
- For storing selected jobs
*/
