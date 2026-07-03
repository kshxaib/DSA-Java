/*
        JUMP GAME

Definition:
Given an integer array nums where:

nums[i] represents the maximum jump length
from index i.

Return true if you can reach
the last index.

Otherwise return false.


Example 1

Input:
nums = [2,3,1,1,4]

Output:
true

Explanation:

Index 0 -> jump 1 step to index 1

Index 1 -> jump 3 steps to index 4

Reached last index.


Example 2

Input:
nums = [3,2,1,0,4]

Output:
false

Explanation:

At index 3,
maximum jump = 0

Cannot move further.

Index 4 becomes unreachable.


Greedy Idea

Track the farthest index
reachable so far.

If at any point the current index
is beyond the farthest reachable index,
then we can never reach it.

Hence answer is false.



Why This Works

maxIndex always stores the
farthest position reachable
using all previous jumps.

If current position itself
cannot be reached,

then no future position
can be reached either.


Time Complexity:O(n)
Single traversal.

Space Complexity: O(1)
*/

class Solution {

    public boolean canJump(int[] nums) {
        int maxIndex = 0; // max reachable index

        for(int i = 0; i < nums.length; i++) {            
            if(i > maxIndex) return false;// current index is unreachable
                
            maxIndex = Math.max(maxIndex, i + nums[i]);  // update max reachable index
        }

        return true;    // reached end successfully
    }
}