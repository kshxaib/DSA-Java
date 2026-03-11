/*
        MINIMUM DAYS TO MAKE M BOUQUETS
          (BINARY SEARCH ON ANSWER)

Problem:
You are given an array nums where:
nums[i] = day when the ith rose blooms.

To make 1 bouquet we need: k adjacent bloomed roses.
We must make at least: m bouquets.

Return the minimum number of days needed.
If it is impossible, return -1.


Example 1:
nums = [7,7,7,7,13,11,12,7]
m = 2
k = 3

Output: 12

Explanation:
By day 12: [7,7,7,7,13,11,12,7]

Bloomed roses: 7,7,7,7,x,11,12,7

We can form:
[7,7,7]
[12,11,7]

Two bouquets.


Example 2:
nums = [1,10,3,10,2]
m = 3
k = 2

Output: -1

Explanation:
We need:
3 * 2 = 6 flowers

But only 5 flowers exist.
Impossible.


Core Idea:
We search for the minimum day such that
we can make at least m bouquets.

The answer must lie between: min(nums) and max(nums)


Key Observation:

For a given day D:

A rose is usable if: nums[i] ≤ D
Then we check how many bouquets
can be formed using k adjacent roses.

Decision Rule:
If we can make ≥ m bouquets
Day D is valid.
Try smaller day.

If bouquets < m
Day D is too early.
Try larger day.


Algorithm Steps:

1. If:

        m * k > n

Return -1 immediately.

2. Find:

        minimum bloom day
        maximum bloom day

3. Binary search between them.

4. For each mid day:

        check if we can make m bouquets.

5. If yes → search left.

6. Else → search right.


Complexities:
Time Complexity  : O(n log(maxDay))
Binary search → log(maxDay)
Each check → O(n)

Space Complexity : O(1)
*/


class Solution {
    public int roseGarden(int n, int[] nums, int k, int m) {
        int minDay = -1;

        if(m * k > n) return minDay;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        int start = min;
        int end = max;

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(canMake(nums, mid, m, k)){
                minDay = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return minDay;
    }

    public boolean canMake(int nums[], int day, int m, int k){
        int count = 0;
        int bouquets = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] <= day){
                count++;

                if(count == k){
                    bouquets++;
                    count = 0;
                }
            } else {
                count = 0;
            }
        }

        return bouquets >= m;
    }
}