// Problem: Connect N Ropes with Minimum Cost

import java.util.PriorityQueue;

public class ConnectNRopes {
    public static void main(String[] args) {

        int ropes[] = {2, 3, 3, 4, 6};

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < ropes.length; i++) {
            pq.add(ropes[i]);
        }

        int cost = 0;
        while (pq.size() > 1) {
            int min1 = pq.remove();  
            int min2 = pq.remove();

            cost = cost + min1 + min2;
            pq.add(min1 + min2);
        }

        System.out.println(cost);
    }
}


/*
Time Complexity:
    Inserting N ropes into PQ: O(n log n)
    Each merge operation: O(log n)
    Number of merges: (n - 1)
    Total: O(n log n)

Space Complexity:
    PriorityQueue stores at most n ropes -> O(n)
*/
