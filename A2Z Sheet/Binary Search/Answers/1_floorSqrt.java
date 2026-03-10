/*
        FIND SQUARE ROOT OF A NUMBER
         (BINARY SEARCH ON ANSWER)

Problem:
Given a positive integer n, return the
floor value of its square root.

If n is a perfect square, return exact root.

If not, return the largest integer whose
square is ≤ n.


Example 1:
n = 36

Output: 6

Explanation:
6 * 6 = 36


Example 2:
n = 28

Output: 5

Explanation:

5² = 25
6² = 36

25 ≤ 28 < 36

So floor sqrt = 5


Core Idea:
The square root must lie between: 1 and n

We use Binary Search to find the
largest number whose square ≤ n.


Key Observation:
If:  mid * mid ≤ n
mid can be a possible answer.

But maybe a larger value also works,
so we move RIGHT.


If: mid * mid > n
mid is too large.

Move LEFT.


Algorithm Steps:

1. Initialize

        start = 1
        end = n
        ans = 1

2. While start ≤ end

3. Compute mid.

4. If mid² ≤ n

        ans = mid
        search right

5. Else

        search left

6. Return ans.


Complexities:
Time Complexity  : O(log n)
Space Complexity : O(1)

Properties:
- Binary search on answer
- Works for large numbers efficiently
- Avoids linear iteration

Key Interview Points:
We search for the largest value
whose square ≤ n.

This pattern is called: Binary Search on Answer
*/

class Solution {
    public int floorSqrt(int n) {
      int ans = 1;
      int start = 1;
      int end = n;

      while(start <= end){
        int mid = start + (end - start)/2;

        if(mid * mid <= n){
            ans = mid;
            start = mid +1;
        } else {
            end = mid -1;
        }
      }

      return ans;
    }
}

// Time: O(log n)
// Space: O(1)