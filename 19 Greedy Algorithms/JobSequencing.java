// Problem: Job Sequencing Problem (Greedy Algorithm)

/*
This program solves the classic "Job Sequencing with Deadlines" problem using a greedy approach.

Goal:
Schedule jobs to maximize total profit, given:
1. Each job has a profit and a deadline.
2. Only one job can be scheduled at a time unit.
3. Jobs must be completed before their deadlines.

Concept:
1. Sort all jobs in descending order of profit.
2. Iterate through jobs and schedule each job in the latest available time slot before its deadline.
3. Keep track of total profit and jobs taken.

Example:
Input:
jobs = [[4,20], [1,10], [1,40], [1,30]]

Output:
Maximum profit: 60
Jobs taken (profits): [20, 40]

Key Idea:
Use a greedy strategy — always select the job with the highest profit first, and schedule it in the latest possible slot before its deadline.
*/

import java.util.*;

public class JobSequencing {

    // Function to find maximum profit and selected jobs
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
Dry Run:
Jobs = [[4,20],[1,10],[1,40],[1,30]]
Step 1: Sort by profit → [[1,10],[4,20],[1,30],[1,40]]

Step 2: Start from highest profit:
- Job [1,40] → deadline 1 > time 0 → schedule → time = 1 → maxValue = 40
- Job [1,30] → deadline 1 > time 1 → cannot schedule
- Job [4,20] → deadline 4 > time 1 → schedule → time = 2 → maxValue = 60
- Job [1,10] → deadline 1 > time 2 → cannot schedule

Output:
Maximum profit = 60
Jobs taken = [40,20]

Time Complexity: O(n log n)
- Sorting takes O(n log n)
- Scheduling loop takes O(n)

Space Complexity: O(n)
- For storing selected jobs

Concept Used:
- Greedy Algorithm
- Sorting jobs by profit
- Schedule in the latest available slot
*/
