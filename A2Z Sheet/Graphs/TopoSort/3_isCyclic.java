import java.util.*;

class Solution {
    public boolean isCyclic(int N, List<List<Integer>> adj) {
        int indegree[] = new int[N];
        // calculate indegree
        for(int i=0; i<N; i++){
            for(int neighbour : adj.get(i)){
                indegree[neighbour]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        // add all nodes having indegree 0
        for(int i=0; i<N; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }

        int count = 0;

        while(!queue.isEmpty()){
            int node = queue.poll();
            count++;

            for(int neighbour : adj.get(node)){
                indegree[neighbour]--;
                if(indegree[neighbour] == 0){
                    queue.offer(neighbour);
                }
            }
        }

        // if all nodes processed => no cycle
        return count != N;
    }
}
