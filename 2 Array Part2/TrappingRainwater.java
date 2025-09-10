public class TrappingRainwater {

    // Function to calculate total trapped rainwater
    // Time Complexity: O(n)  -> 3 passes over the array
    // Space Complexity: O(n) -> leftMax[] and rightMax[] arrays
    public static int findTrappingRainwater(int height[]) {
        int n = height.length;

        // ---------------- Step 1: Build leftMax[] ----------------
        // leftMax[i] = highest bar from index 0 to i
        int leftMax[] = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }

        // ---------------- Step 2: Build rightMax[] ----------------
        // rightMax[i] = highest bar from index i to last index
        int rightMax[] = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
             rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }

        // ---------------- Step 3: Calculate trapped water ----------------
        int totalTrappedWtr = 0;
        for (int i = 0; i < n; i++) {
            // Water level = minimum of highest bar on left & right
            int waterLevel = Math.min(leftMax[i], rightMax[i]);

            // Water trapped at index i = waterLevel - current height
            totalTrappedWtr += (waterLevel - height[i]);
        }

        return totalTrappedWtr;
    }

    public static void main(String[] args) {
        int height[] = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.print(findTrappingRainwater(height)); 
    }
}
