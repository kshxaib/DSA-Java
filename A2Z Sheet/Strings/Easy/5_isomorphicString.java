class Solution {
    public boolean isomorphicString(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        Map<Character, Character> map = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            char original = s.charAt(i);
            char replacement = t.charAt(i);

            if(!map.containsKey(original)){
                if(!map.containsValue(replacement)){
                    map.put(original, replacement);
                } else {
                    return false;
                }
            } else {
                char replaced = map.get(original);
                if(replaced != replacement){
                    return false;
                }
            }
        }

        return true;
    }
} 

Isomorphic String
Subscribe to TUF+

Hints
Company
Given two strings s and t, determine if they are isomorphic. Two strings s and t are isomorphic if the characters in s can be replaced to get t.



All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.


Example 1

Input : s = "egg" , t = "add"

Output : true

Explanation :

The 'e' in string s can be replaced with 'a' of string t.

The 'g' in string s can be replaced with 'd' of t.

Hence all characters in s can be replaced to get t.

Example 2

Input : s = "apple" , t = "bbnbm"

Output : false

Explanation :

Strings are matched index by index.

At index 0, 'a' maps to 'b'.

At index 1, 'p' also maps to 'b'.

This is invalid because two different characters (a and p) cannot map to the same character (b) in a one-to-one mapping.

Therefore, no valid mapping exists and the output is false.