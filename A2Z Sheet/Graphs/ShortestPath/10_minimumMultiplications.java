import java.util.*;

class Solution {
    public int minimumMultiplications(int[] arr, int start, int end) {
        if(start == end) return 0;  // already at destination

        int dist[] = new int[100000];   // dist[number] = minimum multiplications required to reach this number (steps)
        Arrays.fill(dist, Integer.MAX_VALUE);

        Queue<int[]> queue = new LinkedList<>();    // {current number, steps taken}

        queue.offer(new int[]{start, 0});   // start BFS from source number
        dist[start] = 0;

        while(!queue.isEmpty()){
            int pair[] = queue.poll();
            int number = pair[0];
            int steps = pair[1];

            for(int multiplier : arr){   // try multiplying with every number
                // every multiplication is followed by %100000 so generated number always lies between 0 to 99999
                int newNumber = (number * multiplier) % 100000; 

                // first time (or shorter way) reaching this generated number
                if(steps + 1 < dist[newNumber]){
                    dist[newNumber] = steps + 1;    // update minimum steps

                    if(newNumber == end){
                        return steps + 1;   // BFS guarantees first time reaching destination is minimum multiplications
                    }

                    queue.offer(new int[]{newNumber, steps + 1});    // continue BFS from this number
                }
            }
        }

        return -1;
    }
}