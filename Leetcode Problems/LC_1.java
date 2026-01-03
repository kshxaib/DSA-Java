import java.util.HashMap;

public class LC_1 {

    // Two Sum using HashMap
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public int[] twoSum(int[] nums, int target) {

        // HashMap to store number and its index
        HashMap<Integer, Integer> map = new HashMap<>();

        // Traverse the array once
        for (int i = 0; i < nums.length; i++) {

            // Find the required number to reach target
            int complement = target - nums[i];

            // If complement exists, pair is found
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            // Store current number with its index
            map.put(nums[i], i);
        }

        // If no valid pair exists (LeetCode guarantees one solution)
        return new int[] { -1, -1 };
    }
}
