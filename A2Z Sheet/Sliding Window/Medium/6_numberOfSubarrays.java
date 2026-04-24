/*
        COUNT NUMBER OF NICE SUBARRAYS

Definition:
Given array nums[]
and integer k,

Return number of subarrays
having exactly k odd numbers.

Such subarrays are called NICE subarrays.


Example 1

Input:
nums = [1,1,2,1,1]
k = 3

Output:
2

Subarrays:

[1,1,2,1]
[1,2,1,1]


Example 2

Input:
nums = [2,4,6]
k = 1

Output:
0


Example 3

Input:
nums = [2,2,2,1,2,2,1,2,2,2]
k = 2

Output:
16


Core Idea
Need subarrays with:
Exactly k odd numbers

Best Trick
Exactly(k) = AtMost(k) - AtMost(k - 1)


Why This Works
Subarrays with exactly k odds
=
subarrays with <= k odds
-
subarrays with <= (k-1) odds


This is same pattern as:
• Binary subarray sum
• K distinct chars
• Nice subarrays


1. BRUTE FORCE

Try every subarray,
count odd numbers.

Time = O(n²)
*/

class Solution {

    public int numberOfSubarraysBrute(int[] nums, int k) {
        int count = 0;

        for(int i = 0; i < nums.length; i++){
            int odd = 0;

            for(int j = i; j < nums.length; j++){

                // count odd numbers
                if(nums[j] % 2 == 1){
                    odd++;
                }

                if(odd > k){
                    break;
                }

                if(odd == k){
                    count++;
                }
            }
        }

        return count;
    }


/*
2. OPTIMAL SLIDING WINDOW
Exactly(k) = AtMost(k) - AtMost(k-1)

Time = O(n)
Space = O(1)
*/

    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    // count subarrays with at most k odd numbers
    public int atMost(int[] nums, int k) {
        int n = nums.length;

        int left = 0;
        int right = 0;

        int odd = 0;
        int count = 0;

        while(right < n){
            // include right element
            if(nums[right] % 2 == 1){
                odd++;
            }

            // shrink invalid window
            while(odd > k){
                if(nums[left] % 2 == 1){
                    odd--;
                }

                left++;
            }

            /*
                all subarrays ending at right
                starting from left...right valid
            */
            count += (right - left + 1);
            right++;
        }

        return count;
    }
}
