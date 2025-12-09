import java.util.*;
import java.util.LinkedList;

public class BFS {
    static class Edge {
        int src;
        int dest;
        int wgt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wgt = w;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        graph[6].add(new Edge(6, 5, 1));
    }

    public static void bfs(ArrayList<Edge> graph[]) {
        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[graph.length];

        // Start BFS from source vertex 0
        q.add(0);

        // Run until queue becomes empty
        while (!q.isEmpty()) {

            // Remove front element from queue
            int curr = q.remove();

            // If not visited, process it
            if (!visited[curr]) {

                // Visit the current vertex
                System.out.print(curr + " ");
                visited[curr] = true;

                // Add all neighbours of current vertex to queue
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge edge = graph[curr].get(i);
                    q.add(edge.dest);
                }
            }
        }
    }

    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V]; // null stored
        createGraph(graph);
        bfs(graph);
    }
}

/*
Time Complexity: O(V + E)
V → number of vertices
E → number of edges
Each vertex and each edge is processed once

Space Complexity: O(V)
visited[] array
Queue can store at most V vertices
*/