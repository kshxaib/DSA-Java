import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }

        // build graph
        for(int edge[] : prerequisites){
            int course = edge[0];
            int prerequisite = edge[1];

            // prerequisite -> course
            adj.get(prerequisite).add(course);
        }

        int indegree[] = new int[numCourses];
        // calculate indegree
        for(int i=0; i<numCourses; i++){
            for(int neighbour : adj.get(i)){
                indegree[neighbour]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }

        int topo[] = new int[numCourses];
        int index = 0;

        while(!queue.isEmpty()){
            int node = queue.poll();
            topo[index] = node;
            index++;

            for(int neighbour : adj.get(node)){
                indegree[neighbour]--;
                if(indegree[neighbour] == 0){
                    queue.offer(neighbour);
                }
            }
        }

        // cycle exists
        if(index != numCourses){
            return new int[]{};
        }

        return topo;
    }
}