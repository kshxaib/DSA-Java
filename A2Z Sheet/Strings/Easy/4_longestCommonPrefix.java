/*
        LONGEST COMMON PREFIX

Problem:
Given an array of strings, find the longest
common prefix shared among all strings.

If no common prefix exists → return "".


Example 
Input: ["flowers", "flow", "fly", "flight"]

Output: "fl"

Explanation:
All strings start with "fl".


Core Idea (Sorting Trick)

If we sort the array lexicographically,
the most different strings will be at:

        first position
        last position

The common prefix of these two strings
is the common prefix of the entire array.


Complexities
Time Complexity  : O(n log n + m)

n = number of strings
m = length of prefix comparison

Explanation:
Sorting dominates complexity.

Space Complexity : O(1)
(ignoring sorting internal space)
*/

class Solution {    

    public String longestCommonPrefix(String[] str) {
        Arrays.sort(str);

        String first = str[0];
        String last = str[str.length - 1];

        int i = 0;
        while(i < first.length() &&
              i < last.length() &&
              first.charAt(i) == last.charAt(i)){
            i++;
        }

        return first.substring(0, i);
    }
}

// Time: O(n log n)
// Space: O(1)