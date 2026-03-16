/*
        MAXIMUM NESTING DEPTH OF PARENTHESES

Problem:
Given a valid parentheses string s,
return the maximum nesting depth.

Nesting depth = maximum number of
parentheses opened inside each other.

-----------------------------------------------------

Example 1

Input:
s = "(1+(2*3)+((8)/4))+1"

Output:
3

Explanation:

((8)/4)

Digit 8 is inside 3 nested parentheses.

-----------------------------------------------------

Example 2

Input:
s = "(1)+((2))+(((3)))"

Output:
3

Explanation:

(((3)))

Digit 3 is inside 3 nested parentheses.

-----------------------------------------------------

Core Idea

Track how many parentheses are currently open.

Every '(' increases nesting level.
Every ')' decreases nesting level.

The highest value reached by the counter
is the maximum nesting depth.

-----------------------------------------------------

Step-by-Step Approach

Step 1 — Initialize variables

count  → current open parentheses
maxDpt → maximum depth seen so far

Example:

count = 0
maxDpt = 0

-----------------------------------------------------

Step 2 — Traverse the string

Loop through every character of the string.

-----------------------------------------------------

Step 3 — If '(' is found

Increase nesting level.

count++

Update maximum depth.

maxDpt = max(maxDpt, count)

-----------------------------------------------------

Step 4 — If ')' is found

Decrease nesting level.

count--

-----------------------------------------------------

Step 5 — Continue until string ends

Return maxDpt.

-----------------------------------------------------

Example Walkthrough

s = "(1+(2*3)+((8)/4))+1"

Traversal:

(  → count = 1 → max = 1
(  → count = 2 → max = 2
)  → count = 1
(  → count = 2
(  → count = 3 → max = 3
)  → count = 2
)  → count = 1
)  → count = 0

Maximum depth = 3

-----------------------------------------------------

Algorithm Steps

1. Initialize count = 0
2. Initialize maxDepth = 0
3. Traverse the string
4. If '(' → increase count
5. Update maxDepth
6. If ')' → decrease count
7. Return maxDepth

-----------------------------------------------------

Complexities

Time Complexity  : O(n)

Explanation:
We scan the string once.

Space Complexity : O(1)

Explanation:
Only two integer variables are used.

-----------------------------------------------------

Properties

• Simple counter-based solution
• No stack required
• Works because input string is valid

-----------------------------------------------------

Key Interview Points

Maximum depth occurs when the number of
open parentheses is highest.

count    → current nesting level
maxDepth → highest nesting level reached
*/

class Solution {

    public int maxDepth(String s) {

        int maxDpt = 0;   // stores maximum depth
        int count = 0;    // current nesting level

        for(char c : s.toCharArray()){

            if(c == '('){

                count++;                       // increase nesting level
                maxDpt = Math.max(maxDpt, count); // update maximum depth

            } 
            else if(c == ')'){

                count--;                       // decrease nesting level

            }
        }

        return maxDpt;
    }
}

// Time Complexity  : O(n)
// Space Complexity : O(1)