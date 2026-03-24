/*
        GENERATE BINARY STRINGS WITHOUT CONSECUTIVE 1s

Definition:
Given an integer n,
generate all binary strings of length n
such that NO two consecutive 1s appear.

Return strings in lexicographically increasing order.


Example 1
Input:
n = 3

Output:
["000", "001", "010", "100", "101"]


Example 2
Input:
n = 2

Output:
["00", "01", "10"]


Core Idea (Backtracking)

We build the string step-by-step.

At every position:
we decide whether to place:

• '0'
• '1' (only if previous digit is NOT 1)


Why This Works

Constraint:
NO consecutive 1s

So:
If last digit = 1 → cannot add another '1'
If last digit = 0 → can add both '0' and '1'


Time Complexity: O(2^n)
Worst case all combinations explored
(but actually less due to constraint)

Exact count follows Fibonacci pattern.

Space Complexity: O(n)
Recursion stack depth = n
*/

class Solution {
    public List<String> generateBinaryStrings(int n) {
        List<String> ans = new ArrayList<>();
    
        generateAns(ans, "", 0, n);
        return ans;
    }

    public void generateAns(List<String> ans, String s, int lastDigit, int n){
        if(s.length() == n){
            ans.add(s);
            return;
        }

        // always allowed
        generateAns(ans, s+"0", 0, n);

        // only if previous was 0
        if(lastDigit == 0){
            generateAns(ans, s+"1", 1, n);
        }        
    }
}