/*
        VALID ANAGRAM

Problem:
Given two strings s and t, determine whether t is an anagram of s.

An anagram means both strings contain exactly the same characters
with the same frequencies but possibly in a different order.


Example 1
Input:
s = "listen"
t = "silent"

Output: true

Explanation:
Both strings contain the same characters with the same frequency.


Example 2
Input:
s = "rat"
t = "car"

Output: false

Explanation:
Characters do not match in frequency.


Core Idea
Two strings are anagrams if the frequency of every character
in both strings is exactly the same.

Instead of sorting, we use a frequency array.


Complexities
Time Complexity  : O(n)

Explanation:
Single traversal of both strings.

Space Complexity : O(1)

Explanation:
Frequency array size is fixed (26).
*/

class Solution {  
    public boolean anagramStrings(String s, String t) {

        if(s.length() != t.length()){
            return false;
        }

        int[] freq = new int[26];

        for(int i = 0; i < s.length(); i++){
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }

        for(int i = 0; i < 26; i++){
            if(freq[i] != 0){
                return false;
            }
        }

        return true;
    }
}

// Time: O(n)
// Space: O(1)