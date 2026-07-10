import java.util.*;

class Solution {
    public int[] topoSort(int V, List<List<Integer>> adj) {
        int indegree[] = new int[V];
        // calculate indegree
        for(int i=0; i<V; i++){
            for(int neighbour : adj.get(i)){
                indegree[neighbour]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        // add all nodes having indegree 0
        for(int i=0; i<V; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }

        int topo[] = new int[V];
        int index = 0;

        while(!queue.isEmpty()){
            int node = queue.poll();
            topo[index] = node;
            index++;

            for(int neighbour : adj.get(node)){
                indegree[neighbour]--;          // remove current edge
                if(indegree[neighbour] == 0){    // dependency completed
                    queue.offer(neighbour);
                }
            }
        }

        return topo;
    }
}