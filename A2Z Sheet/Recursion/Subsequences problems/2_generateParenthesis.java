/*
        GENERATE PARENTHESES (VALID COMBINATIONS)

Definition:
Given n pairs of parentheses,
generate all combinations of well-formed (valid) parentheses.


Example 1

Input:
n = 3

Output:
["((()))","(()())","(())()","()(())","()()()"]


Example 2

Input:
n = 1

Output:
["()"]


Core Idea (Backtracking)

We build the string step-by-step,
ensuring it NEVER becomes invalid.

At any point, we decide:

• Add '('
• Add ')'

BUT with rules.


Key Rules (VERY IMPORTANT)

1. We can add '(' only if:
   open < n

2. We can add ')' only if:
   close < open


Time Complexity: O(2^n) (approx)
More precisely:
O(Catalan Number)

Number of valid combinations:

C(n) = (2n)! / (n! * (n+1)!)

Space Complexity: O(n)
Recursion depth = n
*/

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generateAns(ans, "", 0, 0, n);
        return ans;
    }

    public void generateAns(List<String> ans, String s, int open, int close, int n){
        if(s.length() == 2 * n){
            ans.add(s);
            return;
        }

        // add '(' if we still can
        if(open < n){
            generateAns(ans, s + "(", open + 1, close, n);
        }

        // add ')' only if valid
        if(close < open){
            generateAns(ans, s + ")", open, close + 1, n);
        }
    }
}