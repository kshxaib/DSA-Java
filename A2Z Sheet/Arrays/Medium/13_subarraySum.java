/*
            SUBARRAY SUM EQUALS K
        (PREFIX SUM + HASHMAP FREQUENCY)

Problem:
Given an integer array nums and an integer k,
return the number of subarrays whose sum equals k.

Example:
nums = [1,1,1], k = 2

Subarrays with sum = 2:
[1,1] at indices (0,1)
[1,1] at indices (1,2)

Answer = 2


Core Idea (Prefix Sum):

Let prefixSum[i] = sum of elements from index 0 → i.

If:
prefixSum[j] - prefixSum[i] = k

Then:
Subarray (i+1 ... j) has sum = k.

Rearrange:

prefixSum[i] = prefixSum[j] - k

So if we already saw prefixSum[j] - k earlier,
then we found a valid subarray.


Why HashMap?

We store:
prefixSum → frequency of occurrence.

This allows us to instantly know how many times
(prefixSum - k) has appeared before.


Algorithm Steps:
1. Initialize map with:
   map.put(0,1)
   (handles subarrays starting at index 0)

2. Traverse the array:
      sum += nums[j]

3. If (sum - k) exists in map:
      add its frequency to answer

4. Store/update current prefix sum in map


Complexities:
Time Complexity  : O(n)
Space Complexity : O(n)

Properties:
- Works even when array contains negative numbers
- Uses HashMap for prefix frequency
- Avoids nested loops

Key Interview Points:
- map.put(0,1) handles subarrays starting from index 0
- prefixSum - k identifies valid previous prefix
- frequency counting handles multiple subarrays
*/

class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);  

        int sum = 0;
        int ans = 0;

        for(int j = 0; j < nums.length; j++){
            sum += nums[j];  

            if(map.containsKey(sum - k)){
                ans += map.get(sum - k);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return ans;
    }
}

// Time Complexity  : O(n)
// Space Complexity : O(n)