/*
        SPLIT ARRAY – LARGEST SUM
        (BINARY SEARCH ON ANSWER)

Problem:
Given an array a and an integer k,
split the array into k non-empty
contiguous subarrays.

The goal is to minimize the largest
sum among these subarrays.

Return the minimized largest sum.


Example 1:
a = [1,2,3,4,5]
k = 3

Output: 6

Explanation:
Split as:
[1,2,3] | [4] | [5]

Subarray sums: 6, 4, 5
Largest sum = 6 (minimum possible)


Example 2:
a = [3,5,1]
k = 3

Output: 5

Explanation:
[3] | [5] | [1]

Largest sum = 5


Core Idea:
We want to minimize the largest
subarray sum.

Possible range of answers:
Minimum = max element in array
Maximum = sum of entire array

Why?
Minimum must be at least the
largest element.

Maximum occurs when one subarray
contains the entire array.


Binary Search Strategy:
Search between: [max(a), sum(a)]


Decision Rule:
If required subarrays ≤ k
The split is valid.
Try smaller maximum sum.

If required subarrays > k
Maximum sum too small.
Increase it.


Algorithm Steps:

1. Find:

        max element
        total sum

2. Binary search between them.

3. For each mid:

        count subarrays needed.

4. If subarrays ≤ k

        store answer
        search left.

5. Else

        search right.


Complexities:
Time Complexity  : O(n log(sum))
Binary search → log(sum)
Each feasibility check → O(n)

Space Complexity : O(1)
*/

class Solution {
    public int splitArray(int[] nums, int k) {
        int n = nums.length;

        int max = Integer.MIN_VALUE;
        int sum = 0;    
        for(int i=0; i<n; i++){
            max = Math.max(max, nums[i]);
            sum += nums[i];
        }

        int ans = -1;
        int start = max;
        int end = sum;

        while(start <= end){
            int mid = start + (end - start)/2;
            int subArrays = countSubArrays(nums, mid);

            if(subArrays <= k){
                ans = mid;
                end = mid -1;
            } else {
                start = mid +1;
            }
        }

        return ans;
    }

    private int countSubArrays(int nums[], int maxSum){
        int subArrays = 1;
        int currSum = 0;

        for(int i=0; i<nums.length; i++){
            if(currSum + nums[i] > maxSum){
                subArrays++;
                currSum = nums[i];
            } else {
                currSum += nums[i];
            }
        }

        return subArrays;
    }
}

// Time: O(n log(sum))
// Space: O(1)



class Solution {
    public int splitArray(int[] nums, int k) {
        int n = nums.length;

        int max = Integer.MIN_VALUE;
        int sum = 0;    
        for(int i=0; i<n; i++){
            max = Math.max(max, nums[i]);
            sum += nums[i];
        }

        for(int maxSum=max; maxSum<=sum; maxSum++){
            int subArrays = countSubArrays(nums, maxSum);

            if(subArrays == k){
                return maxSum;
            }
        }

        return -1;
    }

    private int countSubArrays(int nums[], int maxSum){
        int subArrays = 1;
        int currSum = 0;

        for(int i=0; i<nums.length; i++){
            if(currSum + nums[i] > maxSum){
                subArrays++;
                currSum = nums[i];
            } else {
                currSum += nums[i];
            }
        }

        return subArrays;
    }
}