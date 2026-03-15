/*
        ROTATE STRING

Problem:
Given two strings s and goal,
determine whether goal can be obtained
by rotating string s.

A rotation means moving the first
character of the string to the end.

Example rotation:

s = "abcde"

1 shift → "bcdea"
2 shifts → "cdeab"
3 shifts → "deabc"
4 shifts → "eabcd"


Example 1
Input:
s = "abcde"
goal = "cdeab"

Output: true

Explanation:
After 2 shifts:

abcde → bcdea → cdeab


Example 2
Input:
s = "abcde"
goal = "adeac"

Output: false

Explanation:
No sequence of rotations can produce goal.


Key Observation

If we concatenate s with itself: s + s

Then every possible rotation of s
will appear as a substring inside it.

Example:
s = "abcde"
s + s = "abcdeabcde"

Possible rotations inside:
bcdea
cdeab
deabc
eabcd
abcde


Complexities
Time Complexity  : O(n)

Explanation:
Substring search.

Space Complexity : O(n)

Explanation:
Extra doubled string.
*/

class Solution {   
    public boolean rotateString(String s, String goal) {

        if(s.length() != goal.length()){
            return false;
        }

        String doubled = s + s;

        return doubled.contains(goal);
    }
}

// Time: O(n)
// Space: O(n)