/*
        TRAPPING RAIN WATER

Definition:
Given an array height[],
where each bar represents elevation height of width 1,

Find total water trapped after raining.

-----------------------------------------------------

Example

Input:
height = [0,1,0,2,1,0,1,3,2,1,2,1]

Output:
6

-----------------------------------------------------

Visualization

        █
    █~~~██~
█~███~█████

(~ = trapped water)

-----------------------------------------------------

Core Idea

Water trapped at index i depends on:

1. Highest bar on LEFT
2. Highest bar on RIGHT

Water level at i:

min(leftMax, rightMax)

Trapped water:

min(leftMax, rightMax) - height[i]

-----------------------------------------------------

Why This Works

Water can only stay till the smaller wall.

If left wall = 5 and right wall = 3

Water level = 3

-----------------------------------------------------

Step-by-Step Approach

Step 1:
Build leftMax[]

leftMax[i] =
maximum bar from 0 to i

-----------------------------------------------------

Step 2:
Build rightMax[]

rightMax[i] =
maximum bar from i to n-1

-----------------------------------------------------

Step 3:
For each index:

waterLevel =
min(leftMax[i], rightMax[i])

trapped =
waterLevel - height[i]

-----------------------------------------------------

Step 4:
Add all trapped water

-----------------------------------------------------

Dry Run

height = [4,2,0,3,2,5]

leftMax:
[4,4,4,4,4,5]

rightMax:
[5,5,5,5,5,5]

Water:

i=0 → 0
i=1 → min(4,5)-2 = 2
i=2 → min(4,5)-0 = 4
i=3 → min(4,5)-3 = 1
i=4 → min(4,5)-2 = 2
i=5 → 0

Total = 9

-----------------------------------------------------

Time Complexity

O(n)

-----------------------------------------------------

Space Complexity

O(n)

(two extra arrays)

-----------------------------------------------------

Key Interview Points

• Water depends on left max + right max
• Use prefix max + suffix max arrays
• Formula:
  min(leftMax,rightMax)-height[i]

-----------------------------------------------------

Common Mistakes

• Forgetting min()
• Using max() instead of min() ❌
• Negative water (won’t happen here)
• Wrong rightMax traversal

-----------------------------------------------------

Better Optimization

Two Pointer Approach:

O(n) time
O(1) space

(Interview favorite)

-----------------------------------------------------

Final Brutal Insight

Your solution is:

• Correct ✔
• Clean ✔
• Easy to explain ✔

But not most optimal in space.

Use two-pointer version for stronger interviews.
*/

class Solution {
    public int trap(int[] height) {
        int n = height.length;

        // leftMax[i] = max height from left till i
        int leftMax[] = new int[n];
        leftMax[0] = height[0];

        for(int i = 1; i < n; i++){
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        // rightMax[i] = max height from right till i
        int rightMax[] = new int[n];
        rightMax[n - 1] = height[n - 1];

        for(int i = n - 2; i >= 0; i--){
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int totalTrappedWtr = 0;

        // calculate trapped water at every index
        for(int i = 0; i < n; i++){
            int waterLvl = Math.min(leftMax[i], rightMax[i]);

            totalTrappedWtr += (waterLvl - height[i]);
        }

        return totalTrappedWtr;
    }
}