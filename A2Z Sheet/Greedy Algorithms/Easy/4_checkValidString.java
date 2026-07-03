/*
        VALID PARENTHESES STRING
Definition:
Given a string containing:

'('
')'
'*'

Return true if the string can be valid.


Rules

'*' can represent:

1. '('
2. ')'
3. Empty String ""


Example 1

Input:
s = "()"

Output:
true


Example 2

Input:
s = "(*)"

Output:
true

Explanation:

* = empty

Result:

()


Example 3

Input:
s = "(*))"

Output:
true

Explanation:

* = '('

Result:

(())


=====================================================
1. RECURSION (BRUTE FORCE)
=====================================================

Idea:

For every '*'

Try all 3 possibilities:

1. '('
2. ')'
3. ""

If any path becomes valid,
return true.


Why count?

count =
currently open brackets

count > 0
means unmatched '('

count < 0
means too many ')'


Time Complexity: O(3^n)
Every '*' creates 3 branches.

Space Complexity: O(n)
Recursion stack
*/

class Solution {
    public boolean checkValidString(String s) {
        return check(s, 0, 0);
    }

    public boolean check(String s, int index, int count){
        
        if(count < 0)  return false;  // more closing brackets than opening

        // reached end of string
        if(index >= s.length()){
            if(count == 0) return true; // valid if all brackets matched
            else return false;      // more opening brackets than closing
        }

        // opening bracket
        if(s.charAt(index) == '('){
            return check(s, index + 1, count + 1);
        }

        // closing bracket
        else if(s.charAt(index) == ')'){
            return check(s, index + 1, count - 1);
        }

        // '*' can be: '(' OR ')' OR empty
        return check(s, index + 1, count + 1) || check(s, index + 1, count - 1) || check(s, index + 1, count);
    }


/*
=====================================================
2. GREEDY (OPTIMAL)
=====================================================

Core Idea
Track range of possible
open brackets.

minOpen =
minimum possible opens

maxOpen =
maximum possible opens


Time Complexity: O(n)
Space Complexity: O(1)


Why This Works
Instead of trying every
possibility of '*',

we maintain the range of
all possible open counts.
*/

    public boolean checkValidStringOptimal(String s) {
        int minOpen = 0;
        int maxOpen = 0;

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            if(ch == '('){
                minOpen++;
                maxOpen++;
            }
            else if(ch == ')'){
                minOpen--;
                maxOpen--;
            }
            else{
                minOpen--;
                maxOpen++;
            }
   
            if(minOpen < 0){
                minOpen = 0;  
            }
  
            if(maxOpen < 0){
                return false;
            }
        }

        return minOpen == 0;
    }
}

