/*
        LETTER COMBINATIONS OF A PHONE NUMBER

Problem:
Given a string of digits (2–9),
return all possible letter combinations
that the number could represent.

Each digit maps to letters like a phone keypad.


Digit → Letters Mapping
2 → abc  
3 → def  
4 → ghi  
5 → jkl  
6 → mno  
7 → pqrs  
8 → tuv  
9 → wxyz  

(0 and 1 do not map to any letters)


Example
Input: digits = "23"

Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]


Core Idea
This is a BACKTRACKING problem.
At each digit, we have multiple choices (letters).

So:
• For every digit → try all mapped letters
• Build string step-by-step


Visualization
digits = "23"

Tree:

           ""
      /    |    \
     a     b     c
   / | \ / | \ / | \
 ad ae af bd be bf cd ce cf


Time Complexity: O(4^n)
Where n = length of digits
(Each digit can have up to 4 letters)

Space Complexity: O(n)
Recursion depth = n
*/
import java.util.*;

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();

        if (digits.length() == 0) return ans;

        String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        findCombinations(ans, new StringBuilder(), digits, map, 0);

        return ans;
    }

    public void findCombinations(List<String> ans,  StringBuilder curr, 
        String digits, String[] map, int index) {

        if (index == digits.length()) {
            ans.add(curr.toString());
            return;
        }

        int currNum = digits.charAt(index) - '0';
        String letters = map[currNum];

        for (int i=0; i<letters.length(); i++) {
            curr.append(letters.charAt(i));
            findCombinations(ans, curr, digits, map, index + 1);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}