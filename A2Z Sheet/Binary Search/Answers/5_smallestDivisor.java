/*
        FIND THE SMALLEST DIVISOR
        (BINARY SEARCH ON ANSWER)

Problem:
Given an array nums and an integer limit,
find the smallest divisor such that:
sum of ceil(nums[i] / divisor) ≤ limit


Example 1:
nums = [1,2,3,4,5]
limit = 8

Output: 3

Explanation:
divisor = 1
1+2+3+4+5 = 15 > 8 

divisor = 2
1+1+2+2+3 = 9 > 8 

divisor = 3
1+1+1+2+2 = 7 ≤ 8 

Smallest valid divisor = 3


Example 2:
nums = [8,4,2,3]
limit = 10

divisor = 1
8+4+2+3 = 17 

divisor = 2
4+2+1+2 = 9 ≤ 10    

Answer = 2


Algorithm Steps:

1. Find max element in nums.

2. Binary search between:

        start = 1
        end = max(nums)

3. For each mid divisor:

        compute total sum.

4. If sum ≤ limit

        store answer
        search left.

5. Else

        search right.


Complexities:
Time Complexity  : O(n log max(nums))
Binary search → log(max)
Each check → O(n)

Space Complexity : O(1)
*/

class Solution {

    public int smallestDivisor(int[] nums, int limit) {

        int max = Integer.MIN_VALUE;

        for(int num : nums){
            max = Math.max(max, num);
        }

        int start = 1;
        int end = max;
        int ans = max;

        while(start <= end){

            int mid = start + (end - start)/2;

            int sum = findSum(nums, mid);

            if(sum <= limit){
                ans = mid;
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }

        return ans;
    }

    public int findSum(int nums[], int divisor){
        int sumOfDivision = 0;

        for(int i=0; i<nums.length; i++){
            sumOfDivision += Math.ceil((double) nums[i] / divisor);
        }

        return sumOfDivision;
    }
}