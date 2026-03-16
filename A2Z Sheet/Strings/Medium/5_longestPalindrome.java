/*
        LONGEST PALINDROMIC SUBSTRING

Problem:
Given a string s, return the longest substring
which is a palindrome.

Palindrome:
A string that reads the same forward and backward.

Examples:
"aba"
"racecar"
"bb"


Example 1
Input:
s = "babad"

Output: "bab"

Explanation:
"aba" is also valid.


Example 2
Input:
s = "cbbd"

Output: "bb"


Core Idea

A palindrome expands symmetrically from its center.

Example:

racecar
   ↑
 center

From the center we expand left and right.

There are TWO possible centers:

1. Odd length palindrome
   center at a character

   aba
    ↑

2. Even length palindrome
   center between two characters

   abba
    ↑↑

So for every index we check BOTH cases.


Approach (Expand Around Center)
For every character i in string:

1. Treat i as center → check odd palindrome
2. Treat i,i+1 as center → check even palindrome
3. Expand while characters match
4. Track longest palindrome


Step-by-Step Algorithm

1. Initialize start = 0, end = 0
2. Loop through each index i
3. Find odd length palindrome
4. Find even length palindrome
5. Take maximum length
6. Update start and end indexes
7. Return substring(start, end+1)


Complexities
Time Complexity  : O(n²)

Explanation:
For each character we expand up to n.

Space Complexity : O(1)

Explanation:
No extra data structures used.
*/

class Solution {

    public String longestPalindrome(String s) {
        if (s.length() < 1) {
            return "";
        }

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            int oddLen = expand(s, i, i);       // odd palindrome
            int evenLen = expand(s, i, i + 1);  // even palindrome

            int len = Math.max(oddLen, evenLen);

            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;

            }
        }

        return s.substring(start, end + 1);
    }

    private int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }
}

// Time Complexity  : O(n²)
// Space Complexity : O(1)