class Solution {
    public int[] findMissingRepeatingNumbers(int[] nums) {
        long n = nums.length;

        long SN = (n * (n +1))/2;
        long S2N = (n * (n +1) * (2 * n +1))/6;

        long S = 0, S2 = 0;
        for(int i=0; i<n; i++){
            S += nums[i];
            S2 += (long) nums[i] * nums[i];
        }

        long XMinusY = S - SN;
        long XPlusY = (S2 - S2N)/XMinusY;

        long X = (XMinusY + XPlusY)/2;
        long Y = (S2 - S2N)/XMinusY - X;

        return new int[] {(int) X, (int) Y};
    }
}

// Time: O(n)
// Space: O(1)