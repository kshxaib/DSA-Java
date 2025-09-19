import java.util.*;

public class Question5 {

    // ✅ Brute Force Approach (O(n^3) time, O(m) space)
    // Try all possible triplets and check if their sum is 0
    public static List<List<Integer>> threeSum(int nums[]) {

        // HashSet ensures unique triplets (no duplicates)
        // Space: O(m), where m = number of unique triplets
        Set<List<Integer>> set = new HashSet<>();

        int n = nums.length; // size of input array

        // Triple nested loops → O(n^3) time
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {

                    // Check if nums[i] + nums[j] + nums[k] == 0 → O(1)
                    if (nums[i] + nums[j] + nums[k] == 0) {

                        // Create triplet list → O(1)
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);

                        // Sort triplet → O(3 log 3) ≈ O(1) (constant)
                        Collections.sort(triplet);

                        // Insert into HashSet → O(1) average
                        set.add(triplet);
                    }
                }
            }
        }

        // Convert Set → List → O(m)
        return new ArrayList<>(set);
    }

    // ✅ Better Approach (O(n^2) time, O(n+m) space)
    public static List<List<Integer>> threeSumBetterWay(int nums[]) {

        // Again use set to store unique triplets
        // Space: O(m) for results
        Set<List<Integer>> set = new HashSet<>();

        // Outer loop runs O(n)
        for (int i = 0; i < nums.length; i++) {

            // HashSet for this iteration of i
            // Space: O(n) in worst case (all elements added)
            Set<Integer> hashSet = new HashSet<>();

            // Inner loop runs O(n)
            for (int j = i + 1; j < nums.length; j++) {

                // Find third element needed for sum = 0 → O(1)
                int thirdElement = -(nums[i] + nums[j]);

                // If found in HashSet → O(1)
                if (hashSet.contains(thirdElement)) {
                    List<Integer> triplet = Arrays.asList(nums[i], nums[j], thirdElement);

                    // Sort triplet → O(1)
                    Collections.sort(triplet);

                    // Add to set → O(1)
                    set.add(triplet);
                }

                // Insert nums[j] into HashSet → O(1)
                hashSet.add(nums[j]);
            }
        }

        // Convert Set → List → O(m)
        return new ArrayList<>(set);
    }

    public static List<List<Integer>> threeSumOptimalWay(int nums[]) {
        Set<List<Integer>> set = new HashSet<>();

        // Sorting the array: O(n log n)
        Arrays.sort(nums);

        // Outer loop runs O(n) times
        for (int i = 0; i < nums.length; i++) {
            // Skip duplicate elements for i
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int j = i + 1;
            int k = nums.length - 1;

            // Two pointer traversal: O(n) for each i
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum > 0) {
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
                    set.add(triplet);
                    j++;
                    k--;

                    // Skip duplicates for j and k
                    while (j < k && nums[j] == nums[j - 1])
                        j++;
                    while (j < k && nums[k] == nums[k + 1])
                        k--;
                }
            }
        }

        // Converting set to list: O(m) where m is number of unique triplets
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        int nums[] = { -1, 0, 1, 2, -1, -4 };

        // Brute force output → O(n^3)
        System.out.println(threeSum(nums));

        // Better approach output → O(n^2)
        System.out.println(threeSumBetterWay(nums));
    }
}
    