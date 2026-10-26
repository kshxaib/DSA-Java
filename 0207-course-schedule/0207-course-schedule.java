class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>(); // [course]->[neighbors]

        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int edge[] : prerequisites){
            int course = edge[0];
            int prerequisite = edge[1];

            adj.get(prerequisite).add(course);  // prerequisite -> course
        }

        int indegree[] = new int[numCourses];
        for(int i=0; i<numCourses; i++){
            for(int neighbor : adj.get(i)){
                indegree[neighbor]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }

        int count = 0;
        while(!queue.isEmpty()){
            int curr = queue.poll();
            count++;

            for(int neighbor : adj.get(curr)){
                indegree[neighbor]--;

                if(indegree[neighbor] == 0){
                    queue.offer(neighbor);
                }
            }
        }

        return count == numCourses;
    }
}