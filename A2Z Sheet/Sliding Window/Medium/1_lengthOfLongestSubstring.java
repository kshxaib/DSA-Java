/*
        LONGEST SUBSTRING WITHOUT REPEATING CHARACTERS

Definition:
Given a string s,

Find length of longest substring
having all unique characters.

Substring = continuous part of string


Example 1
Input: s = "abcabcbb"
Output: 3
Explanation: "abc"

Example 2
Input: s = "bbbbb"
Output: 1
Explanation: "b"

Example 3
Input: s = "pwwkew"
Output: 3
Explanation: "wke"


BRUTE FORCE IDEA

Try every starting index.
Expand until duplicate found.
Time = O(n²)


OPTIMAL IDEA (SLIDING WINDOW)

Use two pointers:
left  = window start
right = window end

Keep current substring unique.


Why This Works

If duplicate comes:
Move left pointer after
previous duplicate position.


Data Structure
hash[ch] = last index of character


Time Complexity
Brute Force = O(n²)
Optimal = O(n)

Space Complexity
O(256) ASCII array
*/

import java.util.*;

class Solution {

    /*
        BRUTE FORCE SOLUTION
        Time: O(n²)
        Space: O(256)
    */
    public int lengthOfLongestSubstringBrute(String s) {
        int n = s.length();
        int maxLen = 0;

        // try every starting index
        for(int i = 0; i < n; i++){

            // visited characters
            int map[] = new int[256];

            // expand substring from i 
            for(int j = i; j < n; j++){
                int val = s.charAt(j);

                // duplicate found
                if(map[val] == 1){
                    break;
                }

                // mark visited
                map[val] = 1;

                // current substring length
                int currLen = j - i + 1;
                maxLen = Math.max(maxLen, currLen);
            }
        }

        return maxLen;
    }


    /*
        OPTIMAL SOLUTION
        Sliding Window
        Time: O(n)
        Space: O(256)
    */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();

        // stores last index of each character
        int hash[] = new int[256];
        Arrays.fill(hash, -1);

        int left = 0;     // window start
        int right = 0;    // window end

        int maxLen = 0;

        while(right < n){
            int currChar = s.charAt(right);

            /*
                if character already appeared
                inside current window
            */
            if(hash[currChar] >= left){
                left = hash[currChar] + 1;  // move left after duplicate
            }

            // current valid window length
            int len = right - left + 1;
            maxLen = Math.max(maxLen, len);

            // update latest index of character
            hash[currChar] = right;

            // expand window
            right++;
        }

        return maxLen;
    }
}