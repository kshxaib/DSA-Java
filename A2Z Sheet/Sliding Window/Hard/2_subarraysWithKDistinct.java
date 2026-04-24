/*
        SUBARRAYS WITH K DISTINCT INTEGERS

Definition:
Given integer array nums[]
and integer k,

Return number of subarrays
having EXACTLY k distinct integers.


Example 1

Input:
nums = [1,2,1,2,3]
k = 2

Output:
7


Example 2

Input:
nums = [1,2,1,3,4]
k = 3

Output:
3


Core Idea
Need EXACTLY k distinct numbers.
Best trick:
Exactly(k) = AtMost(k) - AtMost(k - 1)


Why This Works
Subarrays with exactly k distinct
=
subarrays with <= k distinct
-
subarrays with <= (k-1) distinct


1. BRUTE FORCE
Try every starting index.
Expand until distinct > k
If distinct == k → count++

Time = O(n²)
*/


class Solution {

    public int subarraysWithKDistinctBrute(int[] nums, int k) {
        int n = nums.length;
        int count = 0;

        for(int i = 0; i < n; i++){

            Map<Integer,Integer> freq = new HashMap<>();

            for(int j = i; j < n; j++){
                freq.put(nums[j], freq.getOrDefault(nums[j],0) + 1);

                // invalid
                if(freq.size() > k){
                    break;
                }

                if(freq.size() == k){
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
Space = O(k)
*/

    public int subarraysWithKDistinct(int[] nums, int k) {
        int atMostK = atMost(nums, k);
        int atMostKMinus1 = atMost(nums, k - 1);
        return atMostK - atMostKMinus1;
    }

    // count subarrays with at most k distinct
    public int atMost(int[] nums, int k) {
        if(k < 0) return 0;

        int n = nums.length;

        int left = 0;
        int right = 0;

        int count = 0;

        Map<Integer,Integer> freq = new HashMap<>();

        while(right < n){
            // include right element
            freq.put(nums[right], freq.getOrDefault(nums[right],0) + 1);

            // shrink invalid window
            while(freq.size() > k){
                int val = nums[left];
                freq.put(val, freq.get(val) - 1);

                if(freq.get(val) == 0){
                    freq.remove(val);
                }

                left++;
            }

            /*
                all subarrays ending at right
                from left...right valid
            */
            count += (right - left + 1);
            right++;
        }

        return count;
    }
}