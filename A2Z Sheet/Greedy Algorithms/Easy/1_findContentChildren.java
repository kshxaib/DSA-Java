/*
        ASSIGN COOKIES

LeetCode 455

Definition:
Assume you are an awesome parent and want to
give cookies to your children.

Each child has a greed factor g[i],
which is the minimum cookie size needed
to satisfy that child.

Each cookie has a size s[j].

A child is satisfied if:

cookie size >= greed factor

Each cookie can be assigned
to only ONE child.

Return the maximum number of children
that can be satisfied.


Example 1

Input:
g = [1,2,3]
s = [1,1]

Output:
1

Explanation:

Cookie 1 satisfies child with greed 1.

Second child and third child
cannot be satisfied.


Example 2

Input:
g = [1,2]
s = [1,2,3]

Output:
2

Explanation:

Cookie 1 -> Child 1
Cookie 2 -> Child 2

Both children satisfied.


Greedy Idea
Sort both arrays.

Always give the smallest possible cookie
that can satisfy the current child.

Why?
Using a larger cookie unnecessarily
may prevent satisfying other children later.


Algorithm

1. Sort greed array.
2. Sort cookie array.
3. Use two pointers:
   - studentIndex
   - cookieIndex
4. If cookie can satisfy child:
      move to next child.
5. Always move to next cookie.
6. Number of satisfied children
   = studentIndex.


Time Complexity: O(n log n + m log m)
Sorting greed array  = O(n log n)
Sorting cookie array = O(m log m)
Two Pointer Traversal = O(n + m)

Space Complexity: O(1)
*/

import java.util.*;

class Solution {
    public int findContentChildren(int[] g, int[] s) {

        // Sort greed factors in increasing order
        Arrays.sort(g);

        // Sort cookie sizes in increasing order
        Arrays.sort(s);

        // Pointer for cookies
        int cookieIndex = 0;

        // Pointer for children
        int childIndex = 0;

        // Try assigning cookies greedily
        while (cookieIndex < s.length && childIndex < g.length) {

            // Current cookie can satisfy current child
            if (s[cookieIndex] >= g[childIndex]) {
                childIndex++; // Child becomes satisfied
            }

            // Move to next cookie
            cookieIndex++;
        }

        // Number of satisfied children
        return childIndex;
    }
}