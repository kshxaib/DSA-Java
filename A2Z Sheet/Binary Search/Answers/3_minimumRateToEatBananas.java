/*
           KOKO EATING BANANAS
        (BINARY SEARCH ON ANSWER)

Problem:
Koko has n piles of bananas.
The ith pile contains nums[i] bananas.

Each hour, Koko chooses one pile and eats
k bananas from that pile.

If the pile has fewer than k bananas,
Koko eats all bananas in that hour.

Find the minimum value of k such that
Koko can finish all bananas within h hours.


Example 1:
nums = [7,15,6,3]
h = 8

Output: 5

Explanation:
Speed = 5 bananas/hour

7  → 2 hours
15 → 3 hours
6  → 2 hours
3  → 1 hour

Total = 8 hours


Example 2:
nums = [25,12,8,14,19]
h = 5

Output: 25

Explanation:
Each pile must be eaten in 1 hour,
so the speed must be at least the
maximum pile size.


Core Idea:
The eating speed k lies between: 1 and max(nums)

We use Binary Search on this range
to find the minimum valid speed.


Key Observation:
For a given speed k:

Time needed for a pile: ceil(nums[i] / k)
Total hours: sum of all ceil divisions


Decision Rule:

If totalHours ≤ h
k is a valid speed.
But maybe we can reduce it.
Search LEFT.

If totalHours > h
k is too slow.
Search RIGHT.


Algorithm Steps:

1. Find maximum pile size.

2. Binary search between:

        start = 1
        end = maxPile

3. For each mid:

        compute total hours needed.

4. If hours ≤ h

        store answer
        move left.

5. Else

        move right.


Complexities:
Time Complexity  : O(n log maxPile)
Explanation:
Binary search → log(maxPile)
Each step → O(n) to compute hours

Space Complexity : O(1)
*/

class Solution {
    public int minimumRateToEatBananas(int[] nums, int h) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int minBananaPH = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++){
            max = Math.max(max, nums[i]);
        }

        int start = 1;
        int end = max;

        while(start <= end){
            int mid = start + (end - start) / 2;
            int totalHours = findTotalHours(nums, mid);

            if(totalHours <= h){
                minBananaPH = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return minBananaPH;
    }

    public int findTotalHours(int nums[], int nph){
        int totalHours = 0;

        for(int i = 0; i < nums.length; i++){
            totalHours += Math.ceil((double) nums[i] / nph);
        }

        return totalHours;
    }
}