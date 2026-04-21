/*
        LONGEST REPEATING CHARACTER REPLACEMENT

Definition:
Given uppercase string s
and integer k,

You may replace at most k characters.

Return length of longest substring
that can be made of same character.


Example 1

Input:
s = "ABAB"
k = 2

Output:
4

Explanation:
Replace 2 chars → "AAAA"


Example 2

Input:
s = "AABABBA"
k = 1

Output:
4

Explanation:
"AABA" -> replace B with A


Core Idea

Inside a window:

If most frequent character count = maxFreq

Then all other chars must be replaced.

Replacements needed:

windowSize - maxFreq

If <= k, window is valid.


BRUTE FORCE

Try every start index.
Expand right and track frequency.
Time = O(n²)


OPTIMAL IDEA (SLIDING WINDOW)

Maintain valid window where:
(window size - maxFreq) <= k

If invalid:
shrink from left.


Why This Works

Keep the majority character,
replace all others.


IMPORTANT TRICK

maxFreq is NOT reduced while shrinking.

Still works.

Why?

Because stale maxFreq only delays shrinking,
never breaks correctness.

Classic optimization.


Time Complexity
Brute Force = O(n²)
Optimal = O(n)

Space Complexity: O(26) = O(1)
*/

class Solution {

    /*
        BRUTE FORCE
        Time: O(n²)
        Space: O(26)
    */
    public int characterReplacementBrute(String s, int k) {
        int n = s.length();
        int maxLen = 0;

        for(int i = 0; i < n; i++){
            int freq[] = new int[26];

            int maxFreq = 0;

            for(int j = i; j < n; j++){
                // include character
                freq[s.charAt(j) - 'A']++;

                // track most frequent char
                maxFreq = Math.max(
                    maxFreq,
                    freq[s.charAt(j) - 'A']
                );

                int windowSize = j - i + 1;
                int replacements = windowSize - maxFreq;

                if(replacements <= k){
                    maxLen = Math.max(maxLen, windowSize);
                }
            }
        }

        return maxLen;
    }



    /*
        OPTIMAL
        Sliding Window
        Time: O(n)
        Space: O(26)
    */
    public int characterReplacement(String s, int k) {
        int n = s.length();

        int freq[] = new int[26];

        int left = 0;
        int right = 0;

        int maxFreq = 0;
        int maxLen = 0;

        while(right < n){
            // include right char
            freq[s.charAt(right) - 'A']++;

            // highest freq in current / previous valid window
            maxFreq = Math.max(
                maxFreq,
                freq[s.charAt(right) - 'A']
            );

            /*
                invalid if replacements needed > k
                shrink window
            */
            while((right - left + 1) - maxFreq > k){
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            // current valid window
            int len = right - left + 1;
            maxLen = Math.max(maxLen, len);

            right++;
        }

        return maxLen;
    }
}