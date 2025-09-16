public class ShortestPath {
    public static float findShortestPath(String path) {
        int x = 0, y = 0;
        int n = path.length();

        // Traverse the path string
        for (int i = 0; i < n; i++) {
            char dir = path.charAt(i);

            // Update coordinates based on direction
            if (dir == 'W') x--;   // Move left
            if (dir == 'E') x++;   // Move right
            if (dir == 'N') y++;   // Move up
            if (dir == 'S') y--;   // Move down
        }

        // Shortest path = straight-line distance from origin (0,0)
        return (float) Math.sqrt(x * x + y * y);
    }

    public static void main(String args[]) {
        String path = "NS";
        System.out.print(findShortestPath(path));  
    }
}
