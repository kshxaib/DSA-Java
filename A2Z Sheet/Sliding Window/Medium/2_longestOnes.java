/*
        MAX CONSECUTIVE ONES III

Definition:
Given binary array nums[]
and integer k,

You can flip at most k zeros into ones.

Return maximum length of consecutive 1s.


Example 1
Input: nums = [1,1,1,0,0,0,1,1,1,1,0]
k = 2

Output: 6

Explanation: Flip two zeros:
[1,1,1,0,0,1,1,1,1,1,0]

Longest = 6


Example 2
Input: nums = [0,0,1,1,1,0,0]
k = 0

Output: 3


BRUTE FORCE IDEA

Try every start index.
Expand until zeros > k.
Time = O(n²)


OPTIMAL IDEA (SLIDING WINDOW)

Maintain window containing
at most k zeros.
If zeros exceed k:

Shrink from left.


Why This Works

Any valid window with <= k zeros
can be converted fully into 1s.


Time Complexity
Brute Force = O(n²)
Optimal = O(n)
Each pointer moves once.

Space Complexity: O(1)
*/


class Solution {

    /*
        BRUTE FORCE
        Time: O(n²)
        Space: O(1)
    */
    public int longestOnesBrute(int[] nums, int k) {
        int maxLen = 0;

        for(int i = 0; i < nums.length; i++){
            int countOf0 = 0;

            for(int j = i; j < nums.length; j++){
                // count zeros
                if(nums[j] == 0){
                    countOf0++;
                }

                // invalid window
                if(countOf0 > k){
                    break;
                }

                // valid length
                int len = j - i + 1;
                maxLen = Math.max(maxLen, len);
            }
        }

        return maxLen;
    }



    /*
        BETTER / STANDARD SLIDING WINDOW
        Time: O(n)
        Space: O(1)
    */
    public int longestOnesBetter(int[] nums, int k) {
        int n = nums.length;

        int left = 0;
        int right = 0;

        int countOf0 = 0;
        int maxLen = 0;

        while(right < n){
            // include right element
            if(nums[right] == 0){
                countOf0++;
            }

            // shrink until valid
            while(countOf0 > k){
                if(nums[left] == 0){
                    countOf0--;
                }

                left++;
            }

            // valid window
            int len = right - left + 1;
            maxLen = Math.max(maxLen, len);

            right++;
        }

        return maxLen;
    }



    /*
        MOST OPTIMIZED STYLE
        Single shrink step each iteration
        Time: O(n)
        Space: O(1)
    */
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;

        int left = 0;
        int right = 0;

        int countOf0 = 0;
        int maxLen = 0;

        while(right < n){
            // include current element
            if(nums[right] == 0){
                countOf0++;
            }

            // if invalid, move left once
            if(countOf0 > k){
                if(nums[left] == 0){
                    countOf0--;
                }

                left++;
            }

            // if valid, update answer
            if(countOf0 <= k){
                int len = right - left + 1;
                maxLen = Math.max(maxLen, len);
            }

            right++;
        }

        return maxLen;
    }
}