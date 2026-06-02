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

class Task implements Comparable<Task> {
    int frequency;
    int excuetionTime;

    Task(int f, int t) {
        this.frequency = f;
        this.excuetionTime = t;
    }

    // max heap by frequency
    public int compareTo(Task t2) {
        return t2.frequency - this.frequency;
    }
}

class Solution {

    public int leastInterval(char[] tasks, int n) {
        // frequency count
        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < tasks.length; i++) {
            map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1);
        }

        // max heap
        PriorityQueue<Task> pq = new PriorityQueue<>();
        for(Character ch : map.keySet()) {
            pq.add(new Task( map.get(ch), 0));
        }

        // cooldown queue
        Queue<Task> queue = new LinkedList<>();
        int time = 0;

        while(!pq.isEmpty() || !queue.isEmpty()) {
            time++;

            // execute highest frequency task
            if(!pq.isEmpty()) {
                Task task = pq.remove();
                task.frequency--;

                // still remaining
                if(task.frequency > 0) {
                    task.excuetionTime = time + n;
                    queue.add(task);
                }
            }

            // cooldown completed
            if(!queue.isEmpty() && queue.peek().excuetionTime == time) {
                pq.add(queue.remove());
            }
        }

        return time;
    }
}