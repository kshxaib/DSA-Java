import java.util.*;

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;

        boolean visited[] = new boolean[n]; // normal visited
        boolean pathVisited[] = new boolean[n]; // current DFS path
        boolean safe[] = new boolean[n];    // stores safe nodes

        for(int i=0; i<n; i++){
            if(!visited[i]){
                dfs(i, graph, visited, pathVisited, safe);
            }
        }

        List<Integer> ans = new ArrayList<>();  // collect safe nodes
        for(int i=0; i<n; i++){
            if(safe[i]){
                ans.add(i);
            }
        }
        return ans;
    }

    private boolean dfs(int node, int[][] graph, boolean[] visited,
        boolean[] pathVisited, boolean[] safe){

        visited[node] = true;
        pathVisited[node] = true;

        for(int neighbour : graph[node]){   
            if(!visited[neighbour]){    // unvisited neighbour
                if(dfs(neighbour, graph, visited, pathVisited, safe)){
                    return true; // cycle found
                }
            }

            else if(pathVisited[neighbour]){
                return true; // cycle found
            }
        }

        pathVisited[node] = false;  // remove from current path
        safe[node] = true;  // no cycle from this node

        return false;
    }
}