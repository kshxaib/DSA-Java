import java.util.*;
import java.util.LinkedList;

public class KahnAlgorithm {
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }

    public static void topSort(ArrayList<Edge> graph[]){
        // Step 1: calculate indegree
        int indegree[] = new int[graph.length]; 
        for(int i=0; i<graph.length; i++){
            for(int j=0; j<graph[i].size(); j++){
                Edge e = graph[i].get(j);
                indegree[e.dest] = indegree[e.dest]+1;
            }
        }

        // Step 2: add all vertices with indegree 0
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<indegree.length; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        // Step 3: BFS
        while(!q.isEmpty()){
            int curr = q.remove();
            System.out.print(curr + " ");

            for(int i=0; i<graph[curr].size(); i++){
                Edge e = graph[curr].get(i);
                indegree[e.dest] = indegree[e.dest] -1;

                if(indegree[e.dest] == 0){
                    q.add(e.dest);
                }
            }
        }
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V]; 
        createGraph(graph);

        topSort(graph);
    }
}

/*
Time Complexity → O(V + E)
Indegree calculation → O(E)
BFS traversal → O(V + E)

Space Complexity → O(V)
Indegree array → O(V)
Queue → O(V)
*/
