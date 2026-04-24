/*
        LONGEST SUBSTRING WITH AT MOST K DISTINCT CHARACTERS

Definition:
Given string s and integer k,

Return length of longest substring
containing at most k distinct characters.

Substring = continuous part of string


Example 1

Input:
s = "eceba"
k = 2

Output:
3

Explanation:
"ece"


Example 2

Input:
s = "aa"
k = 1

Output:
2

Explanation:
"aa"


Example 3

Input:
s = "aabacbebebe"
k = 3

Output:
7

Explanation:
"cbebebe"


Core Idea
Need longest substring with:
distinct characters <= k


1. BRUTE FORCE
Try every starting index.
Expand right until distinct chars > k

Time = O(n²)
*/


class Solution {

    public int kDistinctCharBrute(String s, int k) {
        int maxLen = 0;

        for(int i = 0; i < s.length(); i++){
            Map<Character, Integer> freq = new HashMap<>();

            for(int j = i; j < s.length(); j++){
                char ch = s.charAt(j);

                freq.put(ch, freq.getOrDefault(ch, 0) + 1);

                // invalid
                if(freq.size() > k){
                    break;
                }

                int len = j - i + 1;
                maxLen = Math.max(maxLen, len);
            }
        }

        return maxLen;
    }


/*
2. OPTIMAL SLIDING WINDOW
Maintain window with:
distinct chars <= k

If > k:
shrink from left.

Time = O(n)
Space = O(k)
*/

    public int kDistinctChar(String s, int k) {
        int n = s.length();
        int maxLen = 0;

        int left = 0;
        int right = 0;

        Map<Character, Integer> freq = new HashMap<>();

        while(right < n){
            char ch = s.charAt(right);

            // include current char
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);

            // shrink until valid
            while(freq.size() > k){
                char leftChar = s.charAt(left);
                freq.put(leftChar, freq.get(leftChar) - 1);

                // remove if count becomes zero
                if(freq.get(leftChar) == 0){
                    freq.remove(leftChar);
                }

                left++;
            }

            // valid window length
            int len = right - left + 1;
            maxLen = Math.max(maxLen, len);

            right++;
        }

        return maxLen;
    }
}
