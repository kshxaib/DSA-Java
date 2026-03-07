/*
                LEADERS IN AN ARRAY

Problem:
An element is called a leader if it is strictly greater
than all elements to its right.

The rightmost element is always a leader.

Return all leaders in the order they appear in the array.

Example:
nums = [1, 2, 5, 3, 1, 2]

Leaders:
5 > [3,1,2]
3 > [1,2]
2 > []

Answer → [5,3,2]

Core Idea:
Instead of checking every element's right side (O(n²)),
we traverse the array from right to left.

Maintain the maximum element seen so far.

If the current element is greater than this maximum,
it is a leader.

Algorithm Steps:

1. Start from the rightmost element.
2. Keep track of the current maximum (greatest).
3. The last element is always a leader.
4. Traverse the array from right → left:
      if nums[i] > greatest
            update greatest
            add it to the list
5. Reverse the list to restore original order.


Example Walkthrough:

nums = [1,2,5,3,1,2]

Start from right:

2 → leader
1 < 2 → ignore
3 > 2 → leader
5 > 3 → leader
2 < 5 → ignore
1 < 5 → ignore

Leaders found (reverse order):
[2,3,5]

Reverse → [5,3,2]

Complexities:
Time Complexity  : O(n)
Space Complexity : O(n)

Properties:
- Single pass traversal
- Greedy technique
- Efficient because we track maximum from right

Key Interview Points:
- Rightmost element always a leader
- Traverse from right to avoid O(n²)
- Reverse result to restore order
 */

class Solution {
    public List<Integer> leaders(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int n = nums.length;

        int greatest = nums[n - 1];
        list.add(greatest);

        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] > greatest) {
                greatest = nums[i];
                list.add(greatest);
            }
        }

        Collections.reverse(list);
        return list;
    }
}

// Time: O(n)
// Space: O(n)