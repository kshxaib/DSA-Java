/*
        CHECK IF ARRAY REPRESENTS MIN HEAP

Definition:
Given array nums[],

Check if it satisfies
Binary Min Heap property.

Return true / false.


Min Heap Conditions

1. Complete Binary Tree
(Array representation already complete)

2. Parent <= Children

For every parent node:

nums[i] <= nums[left]
nums[i] <= nums[right]


Child Index Formula

For index i:

left  = 2*i + 1
right = 2*i + 2


Example 1

Input:
nums = [10,20,30,21,23]

Output:
true


Example 2

Input:
nums = [10,20,30,25,15]

Output:
false

Because:

20 > 15


Your Two Solutions

1st Version

Loop all nodes:

for(i = 0; i < n; i++)

Works ✔
But checks leaf nodes unnecessarily.


2nd Version
Loop only parent nodes:
for(i = 0; i < (n-1)/2; i++)

Better ✔

Because only internal nodes
can have children.


IMPORTANT CORRECTION

For full safety:

Use

i <= (n - 2) / 2

OR

i < n / 2

These represent last parent correctly.


Best Version:
for(int i = 0; i < n/2; i++)


Why Only Till n/2 ?

All indices from n/2 to n-1
are leaf nodes.
Leaf nodes have no children.


Time Complexity: O(n)

Space Complexity: O(1)
*/

class Solution {

    public boolean isHeap(int[] nums) {
        int n = nums.length;

        // check only parent nodes
        for(int i = 0; i < n / 2; i++) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            // parent > left child
            if(left < n && nums[i] > nums[left]) {
                return false;
            }

            // parent > right child
            if(right < n && nums[i] > nums[right]) {
                return false;
            }
        }

        return true;
    }
}