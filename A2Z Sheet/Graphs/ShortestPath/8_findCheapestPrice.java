import java.util.*;

class Solution {
    class Pair {
        int stops;
        int node;
        int cost;

        Pair(int stops, int node, int cost) {
            this.stops = stops;
            this.node = node;
            this.cost = cost;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        // build directed weighted graph
        for(int[] flight : flights){
            int u = flight[0];
            int v = flight[1];
            int price = flight[2];

            adj.get(u).add(new int[]{v, price});
        }

        int cost[] = new int[n];    // minimum cost to reach every city
        Arrays.fill(cost, Integer.MAX_VALUE);

        // {stops, node, cost}
        Queue<Pair> queue = new LinkedList<>(); 
        queue.offer(new Pair(0, src, 0));

        cost[src] = 0;  // cost to reach source

        while(!queue.isEmpty()){
            Pair curr = queue.poll();
            int stops = curr.stops;
            int node = curr.node;
            int currCost = curr.cost;

            // cannot use more than k stops
            if(stops > k){
                break;
            }

            for(int neighbour[] : adj.get(node)){   // explore all outgoing flights
                int adjNode = neighbour[0];
                int price = neighbour[1];

                if(currCost + price < cost[adjNode]){   // cheaper route found
                    cost[adjNode] = currCost + price;
                    queue.offer(new Pair(stops + 1, adjNode, cost[adjNode]));
                }
            }
        }

        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
    }
}