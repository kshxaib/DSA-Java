import java.util.*;

class Solution {
    public int spanningTree(int V, List<List<List<Integer>>> adj) {
        boolean visited[] = new boolean[V]; // keeps track of MST nodes

        // {edge weight, node, parent} always pick minimum weight edge
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );

        pq.offer(new int[]{0, 0, -1});  // start from node 0
        int mstWeight = 0;

        // Optional: store MST edges
        List<int[]> mstEdges = new ArrayList<>();

        while(!pq.isEmpty()){
            int pair[] = pq.poll();
            int weight = pair[0];
            int node = pair[1];
            int parent = pair[2];

            if(!visited[node]){
                visited[node] = true;   // include current node
                mstWeight += weight;
                if(parent != -1){
                    mstEdges.add(new int[] {parent, node}); // save MST edge
                }

                for(List<Integer> neighbour : adj.get(node)){   // explore all neighbours
                    int adjNode = neighbour.get(0);
                    int edgeWeight = neighbour.get(1);

                    if(!visited[adjNode]){  // candidate edge for MST
                        pq.offer(new int[] {edgeWeight, adjNode, node});
                    }
                }
            }
        }

        // Optional: print MST edges
        /*
        for(int edge[] : mstEdges){
            System.out.println(edge[0] + " -> " + edge[1]);
        }
        */

        return mstWeight;
    }
}

