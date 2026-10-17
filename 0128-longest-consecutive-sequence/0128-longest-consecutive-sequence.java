class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;

        Arrays.sort(nums);
        int longest = 1;
        int currLongest = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            }

            if (nums[i] == nums[i - 1] + 1) {
                currLongest++;
            } else {
                currLongest = 1;
            }

            longest = Math.max(longest, currLongest);
        }

        return longest;
    }
}