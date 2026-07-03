/*
        MINIMUM COST TO CONNECT STICKS

Definition:
Given a list of stick lengths.

To connect two sticks:

cost = stick1 + stick2

After connecting:

new stick length = stick1 + stick2

Return minimum total cost
to connect all sticks into one stick.


Example 1

Input:
sticks = [2,4,3]

Output:
14

Explanation:

Connect 2 + 3 = 5
Cost = 5

Sticks:
[4,5]

Connect 4 + 5 = 9
Cost = 9

Total Cost:

5 + 9 = 14


Core Idea
Always connect the
TWO SMALLEST sticks first.


Why?
Large sticks contribute to future costs.

Keeping intermediate sums small
minimizes total cost.


Greedy Strategy

Repeatedly:

1. Remove smallest stick
2. Remove second smallest stick
3. Connect them
4. Add cost
5. Insert merged stick back


Data Structure

Min Heap (Priority Queue)

Top always gives
smallest stick.


Time Complexity
n = number of sticks
Insert all: O(n log n)

Each stick participates once: O(n log n)
Total: O(n log n)

Space Complexity: O(n)
*/
import java.util.*;

class Solution {

    public int connectSticks(List<Integer> sticks) {
        // min heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // insert all sticks
        for(int i = 0; i < sticks.size(); i++){
            pq.add(sticks.get(i));
        }

        int cost = 0;

        // keep merging smallest two
        while(pq.size() > 1){
            int s1 = pq.remove();
            int s2 = pq.remove();

            int sum = s1 + s2;
            cost += sum;

            // push merged stick back
            pq.add(sum);
        }

        return cost;
    }
}