import java.util.PriorityQueue;

public class NearbyCars {

    static class Point implements Comparable<Point> {
        int x;
        int y;
        int distSq;  
        int index;   

        public Point(int x, int y, int distSq, int i){
            this.x = x;
            this.y = y;
            this.distSq = distSq;
            this.index = i;    
        }

        @Override
        public int compareTo(Point p2){
            return this.distSq - p2.distSq;
        }
    }

    public static void main(String[] args) {

        int points[][] = {{3,3}, {5,-1}, {-2,4}}; 
        int k = 2;

        PriorityQueue<Point> pq = new PriorityQueue<>();

        for(int i = 0; i < points.length; i++){
            int x = points[i][0];
            int y = points[i][1];
            int distSq = x*x + y*y;  
            pq.add(new Point(x, y, distSq, i));
        }

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
