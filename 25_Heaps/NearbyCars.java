import java.util.PriorityQueue;

public class NearbyCars {

    // Class representing a point (car) with distance and index
    static class Point implements Comparable<Point> {
        int x;
        int y;
        int distSq;   // distance squared from origin (x^2 + y^2)
        int index;    // original index of the point in the input array

        public Point(int x, int y, int distSq, int i){
            this.x = x;
            this.y = y;
            this.distSq = distSq;
            this.index = i;     // store the index correctly
        }

        // Min-heap comparison based on distance
        @Override
        public int compareTo(Point p2){
            return this.distSq - p2.distSq;
        }
    }

    public static void main(String[] args) {

        int points[][] = {{3,3}, {5,-1}, {-2,4}}; 
        int k = 2;

        // Min-heap storing cars ordered by distance from origin
        PriorityQueue<Point> pq = new PriorityQueue<>();

        // Insert all cars into the priority queue
        for(int i = 0; i < points.length; i++){
            int x = points[i][0];
            int y = points[i][1];
            int distSq = x*x + y*y;  // compute squared distance
            pq.add(new Point(x, y, distSq, i));
        }

        // Remove k nearest cars
        for(int i = 0; i < k; i++){
            System.out.println("C" + pq.remove().index);
        }
    }
}


/*
Time Complexity:
    Building PQ (n insertions): O(n log n)
    Extracting k nearest cars: O(k log n)
    Total: O(n log n + k log n)

Space Complexity:
    PriorityQueue stores n elements -> O(n)
*/
