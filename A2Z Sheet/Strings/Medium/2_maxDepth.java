/*
        MAXIMUM NESTING DEPTH OF PARENTHESES

Problem:
Given a valid parentheses string s,
return the maximum nesting depth.

Nesting depth = maximum number of
parentheses opened inside each other.


Example 1
Input:
s = "(1+(2*3)+((8)/4))+1"

Output: 3


Example 2
Input:
s = "(1)+((2))+(((3)))"

Output: 3


Core Idea
Track how many parentheses are currently open.

Every '(' increases nesting level.
Every ')' decreases nesting level.

The highest value reached by the counter
is the maximum nesting depth.


Algorithm Steps
1. Initialize count = 0
2. Initialize maxDepth = 0
3. Traverse the string
4. If '(' → increase count
5. Update maxDepth
6. If ')' → decrease count
7. Return maxDepth


Complexities
Time Complexity  : O(n)

Explanation:
We scan the string once.

Space Complexity : O(1)

Explanation:
Only two integer variables are used.
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