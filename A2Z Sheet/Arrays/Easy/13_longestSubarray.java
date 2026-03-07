/*
        LONGEST SUBARRAY WITH SUM = K
            (PREFIX SUM + HASHMAP)
Problem:
Find the length of the longest subarray whose sum
equals k.

Core Idea (Prefix Sum):
Let prefixSum[i] = sum of elements from 0..i.

If:
prefixSum[j] - prefixSum[i] = k

Then:
Subarray (i+1 ... j) has sum = k

So if we know a previous prefix sum equal to
(sum - k), we found a valid subarray.

Algorithm Steps:
1. Maintain running prefix sum.
2. Store first occurrence of each prefix sum in map.
3. If (sum - k) exists in map:
   length = i - map.get(sum-k)
4. Track maximum length.

Example:
nums = [10,5,2,7,1,9], k = 15

Prefix sums:
10
15 → subarray length = 2
17
24
25
34

Longest valid subarray:
[5,2,7,1] → length = 4

Complexities:
Time Complexity  : O(n)
Space Complexity : O(n)

Key Interview Points:
- Works for arrays containing negative numbers
- Sliding window cannot handle negative numbers
- HashMap stores earliest occurrence of prefix sum
*/

class Solution {
    public int longestSubarray(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxLen = 0;
        
        for(int i=0; i<nums.length; i++){
           sum += nums[i];

           if(sum == k){
                maxLen = i + 1;
           }

           if(map.containsKey(sum - k)){
                int len = i - map.get(sum - k);
                maxLen = Math.max(maxLen, len);
           }

           if(!map.containsKey(sum)){
                map.put(sum, i);
           }
        }

        return maxLen;
    }
}

// Time: O(n)
// Space: O(n)