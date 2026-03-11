/*
        CAPACITY TO SHIP PACKAGES WITHIN D DAYS
              (BINARY SEARCH ON ANSWER)

Problem:
You are given an array weights where
weights[i] represents the weight of a package.

Packages must be shipped in the SAME ORDER.

Each day the ship can carry packages
until the total weight reaches the ship capacity.

Find the minimum ship capacity required
to ship all packages within given days.


Example 1:
weights = [1,2,3,4,5,6,7,8,9,10]
days = 5

Output: 15

Explanation:
Day1 → 1+2+3+4+5 = 15
Day2 → 6+7 = 13
Day3 → 8
Day4 → 9
Day5 → 10


Example 2:
weights = [3,2,2,4,1,4]
days = 3

Output: 6

Explanation:
Day1 → 3+2
Day2 → 2+4
Day3 → 1+4


Core Idea:
Ship capacity must be between: max(weights) and sum(weights)

Why?
Minimum capacity must be at least
the heaviest package.

Maximum capacity could ship everything
in one day.


Key Observation:
For a given capacity C:

Simulate shipping.

If current load exceeds C,
start a new day.

Count how many days are required.


Decision Rule:
If requiredDays ≤ givenDays
Capacity is valid.
Try smaller capacity.

If requiredDays > givenDays
Capacity is too small.
Increase capacity.


Algorithm Steps:

1. Find:

        max weight
        total weight

2. Binary search between:

        start = maxWeight
        end = totalWeight

3. For each mid capacity:

        calculate required days.

4. If requiredDays ≤ days

        store answer
        search left.

5. Else

        search right.


Complexities:
Time Complexity  : O(n log(sum))
Binary search → log(sum)
Each check → O(n)

Space Complexity : O(1)
*/

class Solution {

    public int shipWithinDays(int[] weights, int days) {

        int ans = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for(int i = 0; i < weights.length; i++){
            max = Math.max(max, weights[i]);
            sum += weights[i];
        }

        int start = max;
        int end = sum;

        while(start <= end){

            int mid = start + (end - start)/2;

            int requiredDays = findDays(weights, mid);

            if(requiredDays <= days){
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }

    public int findDays(int weights[], int capacity){

        int currWeight = 0;
        int days = 1;

        for(int i = 0; i < weights.length; i++){

            if(currWeight + weights[i] > capacity){
                days++;
                currWeight = weights[i];
            } else{
                currWeight += weights[i];
            }
        }

        return days;
    }
}