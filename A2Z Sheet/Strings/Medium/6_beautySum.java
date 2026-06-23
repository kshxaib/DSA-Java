/*
========================================================
          SUM OF BEAUTY OF ALL SUBSTRINGS
                LeetCode 1781
========================================================

Problem:
The beauty of a string is:

(maximum character frequency)
                  -
(minimum character frequency)

Return the sum of beauty values of all
possible substrings.


--------------------------------------------------------
Example
--------------------------------------------------------

s = "aabcb"

Substrings having non-zero beauty:

"aab"    -> 2 - 1 = 1
"aabc"   -> 2 - 1 = 1
"aabcb"  -> 2 - 1 = 1
"abcb"   -> 2 - 1 = 1
"bcb"    -> 2 - 1 = 1

Answer = 5


========================================================
BRUTE FORCE IDEA
========================================================

Generate every substring.

For each substring:

1. Count frequency of characters.
2. Find:

       maximum frequency
       minimum frequency

3. Add:

       maxFreq - minFreq

to answer.


--------------------------------------------------------
Problem with True Brute Force
--------------------------------------------------------

Generate substring

+
Count frequency again

for every substring.

Time Complexity:

O(n³)


========================================================
OPTIMIZED BRUTE FORCE
========================================================

Observation:

Fix starting index i.

Extend substring one character at a time.

Maintain frequency map while extending.

No need to rebuild frequencies
for every substring.


--------------------------------------------------------
Idea
--------------------------------------------------------

For every starting index:

    i

Create frequency map.

Extend ending index:

    j = i → n-1

Update frequency of s[j].

Find:

    max frequency
    min frequency

Add:

    max - min

to answer.


========================================================
ALGORITHM
========================================================

For every starting index i:

    Create frequency map.

    For every ending index j:

        Add s[j] to frequency map.

        Find:

            max frequency
            min frequency

        beauty =
            max - min

        add beauty to answer.


========================================================
CODE
========================================================
*/

import java.util.*;

class Solution {
    public int beautySum(String s) {
        int n = s.length();
        int sum = 0;

        for (int i = 0; i < n; i++) {
            Map<Character, Integer> map = new HashMap<>();

            for (int j = i; j < n; j++) {
                char ch = s.charAt(j);

                map.put(ch, map.getOrDefault(ch, 0) + 1);

                int maxFreq = Integer.MIN_VALUE;
                int minFreq = Integer.MAX_VALUE;

                for (int freq : map.values()) {
                    maxFreq = Math.max(maxFreq, freq);
                    minFreq = Math.min(minFreq, freq);
                }

                sum += (maxFreq - minFreq);
            }
        }

        return sum;
    }
}