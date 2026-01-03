import java.util.HashSet;

public class LC_217 {

    // Checks if the array contains any duplicate element
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public boolean containsDuplicate(int[] nums) {

        // HashSet to store unique elements
        HashSet<Integer> set = new HashSet<>();

        // Traverse the array
        for (int i = 0; i < nums.length; i++) {

            // If element already exists in set, duplicate found
            if (set.contains(nums[i])) {
                return true;
            }

            // Otherwise, add element to the set
            set.add(nums[i]);
        }

        // No duplicates found
        return false;
    }
}
