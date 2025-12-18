import java.util.*;
import java.util.LinkedList;

public class CheapestFlights {
    static class Edge{
        int src;
        int dest;
        int wgt;

        public Edge(int s, int d, int w){
            this.src = s;
            this.dest = d;
            this.wgt = w;
        }
    }

    public static void createGraph(int flights[][], ArrayList<Edge> graph[]){
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<flights.length; i++){
            int src = flights[i][0];
            int dest = flights[i][1];
            int wgt = flights[i][2];

            Edge e = new Edge(src, dest, wgt);
            graph[src].add(e);
        }
    }

    static class Info{
        int vertex;
        int cost;
        int stops;

        public Info(int v, int c, int s){
            this.vertex = v;
            this.cost = c;
            this.stops = s;
        }
    }

    public static int cheapestFlights(int n, int flights[][], int src, int dest, int k){
        ArrayList<Edge> graph[] = new ArrayList[n];
        createGraph(flights, graph);

        int dist[] = new int[n];
        for(int i=0; i<n; i++){
            if(i!=src){
                dist[i] = Integer.MAX_VALUE;
            }
        }

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src, 0, 0));

        while(!q.isEmpty()){
            Info curr = q.remove();
            if(curr.stops > k){
                break;
            }

            for(int i=0; i<graph[curr.vertex].size(); i++){
                Edge e = graph[curr.vertex].get(i);
                int v = e.dest;
                int wgt = e.wgt;

                if((curr.cost + wgt < dist[v]) && (curr.stops <= k)){
                    dist[v] = curr.cost + wgt;
                    q.add(new Info(e.dest, dist[v], curr.stops +1));
                }
            }
        }

        if(dist[dest] == Integer.MAX_VALUE){
            return -1;
        }
        return dist[dest];
    }

    public static void main(String[] args) {
         int n =4;
        int flights[][] = {{0,1,100}, {1,2,100}, {2,0,100}, {1,3,600}, {2,3,200}};
        int src=0, dest=3, k=1;
        System.err.println(cheapestFlights(n, flights, src, dest, k));
    }    
}

/*
 TIME COMPLEXITY:
- Graph construction: O(E)
- BFS traversal: Each edge can be relaxed at most K times
- Total time: O(K * E)

SPACE COMPLEXITY:
- Graph adjacency list: O(V + E)
- Distance array: O(V)
- Queue (worst case): O(V)
- Total space: O(V + E)
*/