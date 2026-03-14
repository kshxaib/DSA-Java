/*
        REMOVE OUTERMOST PARENTHESES

Problem:
Given a valid parentheses string s,
remove the outermost parentheses of
every primitive valid parentheses string.


Valid Parentheses Rules
1. "" is valid.
2. "(" + A + ")" is valid if A is valid.
3. A + B is valid if A and B are valid.


Primitive Parentheses String
A primitive string is a valid parentheses
string that cannot be split into two
valid non-empty strings.

Example: "(()())"
This is primitive.

But "()()"
is not primitive because: "()" + "()"

Goal
Remove the outermost parentheses of
each primitive substring.


Example 1: s = "((()))"
Primitive: ((()))
Remove outer layer: (()) 

Example 2
s = "()(()())(())"
Primitive decomposition: "()" + "(()())" + "(())"
Remove outer parentheses: "" + "()()" + "()"
Final result: "()()()"


Core Idea
Use a counter to track the depth
of parentheses.

counter = number of currently open '('


Why This Works
The first '(' of a primitive occurs
when counter == 0 → we skip it.

The last ')' of a primitive occurs
when counter becomes 0 → we skip it.

All inner parentheses are kept.


Complexities
Time Complexity  : O(n)
Space Complexity : O(n) (for result)
*/

class Solution {
    public String removeOuterParentheses(String s) {
       int counter = 0;
       StringBuilder ans = new StringBuilder();

       for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            if(ch == '('){
                if(counter > 0) ans.append(ch);
                counter++;
            } 
            else{
                counter--;
                if(counter > 0) ans.append(ch);
            }
       }

       return ans.toString();
    }
}