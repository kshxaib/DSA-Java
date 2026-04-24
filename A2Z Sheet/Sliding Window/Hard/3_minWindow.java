/*
        MINIMUM WINDOW SUBSTRING

Definition:
Given strings:

s = source string
t = target string

Return smallest substring of s
that contains all characters of t
including duplicates.

If impossible → return ""


Example 1

Input:
s = "ADOBECODEBANC"
t = "ABC"

Output:
"BANC"


Example 2

Input:
s = "a"
t = "a"

Output:
"a"


Example 3

Input:
s = "a"
t = "aa"

Output:
""


Important Rule

If t has duplicates:
t = "AABC"

Window must contain:
A x2, B x1, C x1


Core Idea
Need smallest valid substring.

Use Sliding Window.

Expand right until valid.
Then shrink left to minimize.


1. BRUTE FORCE
Try every start index.
Expand until all chars found.
Track smallest.

Time = O(n²)
*/

class Solution {

    public String minWindowBrute(String s, String t) {
        int minLen = Integer.MAX_VALUE;
        int startingIdx = -1;

        for(int i = 0; i < s.length(); i++){
            int hash[] = new int[256];

            // store target frequency
            for(int k = 0; k < t.length(); k++){
                hash[t.charAt(k)]++;
            }

            int count = 0;
            for(int j = i; j < s.length(); j++){
                char ch = s.charAt(j);

                // useful character matched
                if(hash[ch] > 0){
                    count++;
                }

                hash[ch]--;

                // all chars matched
                if(count == t.length()){
                    int len = j - i + 1;

                    if(len < minLen){
                        minLen = len;
                        startingIdx = i;
                    }

                    break;
                }
            }
        }

        if(startingIdx == -1) return "";

        return s.substring(startingIdx, startingIdx + minLen);
    }


/*
2. OPTIMAL SLIDING WINDOW
Use freq array for t.

Expand right:
Take chars into window.

When all chars matched:
Shrink left to find minimum.

Time = O(n)
Space = O(256)
*/

    public String minWindow(String s, String t) {
        int n = s.length();

        int minLen = Integer.MAX_VALUE;
        int startingIdx = -1;

        int hash[] = new int[256];

        // chars matched
        int count = 0;

        int left = 0;
        int right = 0;

        // store target freq
        for(int i = 0; i < t.length(); i++){
            hash[t.charAt(i)]++;
        }

        while(right < n){
            char rightChar = s.charAt(right);

            /*
                if needed char found
            */
            if(hash[rightChar] > 0){
                count++;
            }

            // include char in window
            hash[rightChar]--;

            /*
                valid window:
                matched all chars of t
            */
            while(count == t.length()){
                int len = right - left + 1;

                if(len < minLen){
                    minLen = len;
                    startingIdx = left;
                }

                // remove left char
                char leftChar = s.charAt(left);
                hash[leftChar]++;

                /*
                    if needed char removed,
                    window invalid
                */
                if(hash[leftChar] > 0){
                    count--;
                }

                left++;
            }

            right++;
        }

        if(startingIdx == -1) return "";

        return s.substring(startingIdx, startingIdx + minLen);
    }
}