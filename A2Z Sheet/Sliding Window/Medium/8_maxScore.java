/*
        MAXIMUM POINTS YOU CAN OBTAIN FROM CARDS

Definition:
You have an array cardPoints[].

You must pick exactly k cards.

Each pick can be from:

• left end
OR
• right end

Return maximum score possible.


Example 1

Input:
cardPoints = [1,2,3,4,5,6,1]
k = 3

Output:
12

Explanation:

Pick:
1 (right), 6 (right), 5 (right)

Total = 12


Example 2

Input:
cardPoints = [2,2,2]
k = 2

Output:
4


Example 3

Input:
cardPoints = [9,7,7,9,7,7,9]
k = 7

Output:
55


Core Idea
If you pick k cards total:

You can pick:
0 from left, k from right
1 from left, k-1 from right
2 from left, k-2 from right
...
k from left, 0 from right

Check all possibilities.


Why This Works
Every valid selection is some split:
left picks + right picks = k


Approach
1. Take first k cards as initial leftSum
2. Gradually remove one left card
3. Add one right card
4. Track max score

Excellent O(k) method.


Time: O(n)
Space: O(1)
*/

class Solution {
    public int maxScore(int[] cardPoints, int k) {

        int n = cardPoints.length;

        // initial: take first k cards from left
        int leftSum = 0;

        for(int i = 0; i < k; i++){
            leftSum += cardPoints[i];
        }

        int maxScore = leftSum;

        int rightSum = 0;

        // replace left picks with right picks one by one
        for(int i = 0; i < k; i++){

            // remove from left side
            leftSum -= cardPoints[k - i - 1];

            // add from right side
            rightSum += cardPoints[n - i - 1];

            maxScore = Math.max(
                maxScore,
                leftSum + rightSum
            );
        }

        return maxScore;
    }
}