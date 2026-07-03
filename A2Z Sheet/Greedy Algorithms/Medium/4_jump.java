class Solution {
    // BRUTE FORCE
    public int jumpBrute(int[] nums) {
        return minJump(nums, 0);
    }

    private int minJump(int nums[], int position) {
        if (position >= nums.length - 1) {
            return 0;
        }

        if (nums[position] == 0) {
            return Integer.MAX_VALUE;
        }

        int minStep = Integer.MAX_VALUE;
        for (int jump = 1; jump <= nums[position]; jump++) {
            int subResult = minJump(nums, position + jump);
            if (subResult != Integer.MAX_VALUE) {
                minStep = Math.min(minStep, 1 + subResult);
            }
        }

        return minStep;
    }

    // OPTIMAL APPROACH
    public int jump(int[] nums) {
        int n = nums.length;

        // Current jump range
        int left = 0; // start of current jump range
        int right = 0; // end of current jump range

        // Count minimum jumps
        int jumps = 0;

        // Continue until last index is inside our range
        while (right < n - 1) {

            // Farthest position reachable from current range
            int farthest = 0;

            // Try all indexes reachable with current jump
            for (int i = left; i <= right; i++) {
                // Update maximum reachable position
                farthest = Math.max(farthest, i + nums[i]);
            }

            // Move to next jump range
            left = right + 1;
            right = farthest;

            // One jump completed
            jumps++;
        }

        return jumps;
    }
}