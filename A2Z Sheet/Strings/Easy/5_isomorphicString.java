/*
        ISOMORPHIC STRINGS

Problem:
Given two strings s and t, determine
whether they are isomorphic.

Two strings are isomorphic if characters
in s can be replaced to form t.

Rules:
1. Each character in s must map to exactly
   one character in t.
2. No two characters in s can map to the
   same character in t.
3. Order of characters must remain same.


Example 1

Input:
s = "egg"
t = "add"

Output: true

Explanation:
e → a
g → d

Mapping is consistent.


Example 2

Input:
s = "apple"
t = "bbnbm"

Output: false

Explanation:
a → b
p → b

Two characters mapping to same character
is not allowed.


Core Idea
We maintain a mapping between characters
of s → characters of t.

But we must ensure a **one-to-one mapping**.


Two Conditions

1. If a character in s is already mapped,
   it must map to the same character in t.

2. If a character in s is not mapped,
   the target character in t must not
   already be mapped by another character.


Complexities
Time Complexity  : O(n)

Explanation:
Single traversal of both strings.

Space Complexity : O(1)

Explanation:
At most 256 character mappings.
*/

class Solution {
    public boolean isomorphicString(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        Map<Character, Character> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            char original = s.charAt(i);
            char replacement = t.charAt(i);

            if(!map.containsKey(original)){
                if(!map.containsValue(replacement)){
                    map.put(original, replacement);
                }
                else{
                    return false;
                }
            }
            else{
                char replaced = map.get(original);
                if(replaced != replacement){
                    return false;
                }
            }
        }

        return true;
    }
}

// Time: O(n)
// Space: O(1)