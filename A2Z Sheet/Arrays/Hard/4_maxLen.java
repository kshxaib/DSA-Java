/*
        LONGEST SUBARRAY WITH SUM = 0
            (PREFIX SUM + HASHMAP)

Problem:
Given an array of integers, find the length of the
longest subarray with sum equal to 0.

Example:
arr = [1,-1,3,2,-2,-3,3]

Subarray:
[3,2,-2,-3]

Sum = 0
Length = 4

Core Idea:
Use prefix sum.

If two prefix sums are equal:
prefixSum[j] = prefixSum[i]

Then the subarray between them has sum = 0.

Because:
prefixSum[j] - prefixSum[i] = 0


HashMap Usage:
Store:
prefixSum → first index where it appeared

Why first index?
Because we want the longest possible subarray.


Algorithm Steps:

1. Initialize:
   sum = 0
   maxLen = 0

2. Traverse array

3. Update prefix sum

4. If sum == 0
      maxLen = i + 1

5. If sum already exists in map
      length = i - map.get(sum)
      update maxLen

6. Otherwise store prefix sum in map


Complexities:
Time Complexity  : O(n)
Space Complexity : O(n)

Properties:
- Uses prefix sum technique
- HashMap provides O(1) lookup
- Handles negative numbers
*/

class Solution {
    public int maxLen(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
        int maxLen = 0;

        int sum = 0;

        for(int i=0; i<n; i++){
            sum += arr[i];

            if(sum == 0){
                maxLen = i + 1;
            }

            if(map.containsKey(sum)){
                int len = i - map.get(sum);
                maxLen = Math.max(maxLen, len);
            } else {
                map.put(sum, i);
            }
        }

        return maxLen;
    }
}

// Time: O(n)
// Space: O(n)