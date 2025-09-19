public class MajorityElement {
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 1;

        // Step 1: Find candidate
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                candidate = nums[i];
                count = 1;
            } else if (nums[i] == candidate) {
                count++;
            } else {
                count--;
            }
        }

        // Step 2 (Optional check if guaranteed majority): 
        // Verify candidate actually appears > n/2 times
        int freq = 0;
        for (int num : nums) {
            if (num == candidate) freq++;
        }
        if (freq > nums.length / 2) {
            return candidate;
        }

        // If no majority (problem guarantee usually ensures this case won't happen)
        return -1;
    }
}
