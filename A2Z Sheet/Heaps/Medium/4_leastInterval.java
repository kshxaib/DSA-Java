/*
        TASK SCHEDULER

LeetCode 621

Definition:
Given tasks represented by characters
and a cooldown period n.

Same task must wait at least n units
before executing again.

Return minimum time required
to complete all tasks.


Example 1

Input:
tasks = ['A','A','A','B','B','B']
n = 2

Output:
8

Schedule:

A B idle A B idle A B

Time = 8


Example 2

Input:
tasks = ['A','C','A','B','D','B']
n = 1

Output:
6

Schedule:

A B A B C D


Core Idea

Always execute task with
highest remaining frequency.

Why?

High frequency tasks are hardest
to schedule later.


Data Structures Used

1. Max Heap (Priority Queue)
Stores tasks by frequency.
Top = task with highest frequency.


2. Queue (Cooldown Queue)
Stores tasks that are cooling down.

Each task keeps:
frequency remaining
next execution time


Task Class

frequency
→ remaining occurrences

executionTime
→ earliest time task can return
   to heap



Time Complexity
Let:
T = total tasks
K = distinct task types

Frequency Count: O(T)
Heap Operations: O(T log K)

Total: O(T log K)


Space Complexity
Heap  : O(K)
Queue : O(K)
Map   : O(K)

Total: O(K)
*/
import java.util.*;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        // Count frequency of each task
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char task : tasks) {
            freqMap.put(task, freqMap.getOrDefault(task, 0) + 1);
        }

        // Max heap stores highest frequency first
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int count : freqMap.values()) {
            maxHeap.add(count);
        }

        int time = 0;

        // Process tasks cycle by cycle
        while (!maxHeap.isEmpty()) {

            // Store tasks used in current cycle
            List<Integer> temp = new ArrayList<>();

            int cycle = n + 1;  // Cooldown cycle length

            // Pick at most n+1 most frequent tasks
            for (int i = 0; i < cycle; i++) {
                if (!maxHeap.isEmpty()) {
                    temp.add(maxHeap.poll());
                }
            }

            // Decrease frequency and add remaining back
            for (int freq : temp) {
                freq--;

                if (freq > 0) {
                    maxHeap.add(freq);
                }
            }

            // Add actual tasks if done, otherwise full cycle
            time += maxHeap.isEmpty() ? temp.size() : cycle;
        }

        return time;
    }
}