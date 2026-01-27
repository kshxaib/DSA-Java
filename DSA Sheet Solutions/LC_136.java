class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int i=0; i<nums.length; i++){
            ans = ans ^ nums[i];
        }

        return ans;
    }
}

// Time: O(n)
// Space: O(1)

// XOR properties:
// n^n = 0
// n^0 = 1