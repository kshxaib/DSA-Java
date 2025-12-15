import java.util.*;
import java.util.LinkedList;

public class AllPaths {
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
        graph[0].add(new Edge(0, 3));

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }

    public static void findAllPaths(ArrayList<Edge> graph[], int src, int des, String path){
        if(src == des){
            System.out.println(path+des);
            return;
        }

        for(int i=0; i<graph[src].size(); i++){
            Edge e = graph[src].get(i);
            findAllPaths(graph, e.dest, des, path+src);
        }
    }    

    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V]; 
        createGraph(graph);

        int src = 5, dest =1;
        findAllPaths(graph, src, dest, "");
    }
}

/*
Time Complexity → O(All possible paths)
Worst case: exponential

Space Complexity → O(V)
visited[] array → O(V)
Recursion stack → O(V)
*/

