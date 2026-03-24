/*
        GENERATE BINARY STRINGS WITHOUT CONSECUTIVE 1s

Definition:
Given an integer n,
generate all binary strings of length n
such that NO two consecutive 1s appear.

Return strings in lexicographically increasing order.

-----------------------------------------------------

Example 1

Input:
n = 3

Output:
["000", "001", "010", "100", "101"]

-----------------------------------------------------

Example 2

Input:
n = 2

Output:
["00", "01", "10"]

-----------------------------------------------------

Core Idea (Backtracking)

We build the string step-by-step.

At every position:
we decide whether to place:

• '0'
• '1' (only if previous digit is NOT 1)

-----------------------------------------------------

Why This Works

Constraint:
NO consecutive 1s

So:

If last digit = 1 → cannot add another '1'
If last digit = 0 → can add both '0' and '1'

-----------------------------------------------------

Your Approach

You track:

lastDigit

0 → last placed digit was '0'
1 → last placed digit was '1'

-----------------------------------------------------

Step-by-Step Algorithm

1. Start with empty string ""
2. Recursively build string
3. If length == n → add to answer
4. Always add '0'
5. Add '1' only if lastDigit == 0

-----------------------------------------------------

Recursion Tree (n = 3)

Start: ""

Level 1:
"0"      "1"

Level 2:
"00"     "01"     "10"

Level 3:
"000"    "001"    "010"    "100"    "101"

-----------------------------------------------------

Dry Run

n = 3

Call:
generate("", lastDigit = 0)

Step 1:
Add '0' → "0"
Add '1' → "1"

From "0":
→ "00", "01"

From "1":
→ only "10" (can't add '1')

Continue until length = 3

-----------------------------------------------------

Why Lexicographically Sorted?

Because:

You always call:

generateAns(..., s+"0", ...)
then
generateAns(..., s+"1", ...)

So "0" branch is explored first → sorted order

-----------------------------------------------------

Edge Cases

• n = 0 → returns [""]
• n = 1 → ["0", "1"]
• n = 2 → ["00", "01", "10"]

-----------------------------------------------------

Time Complexity

O(2^n)

Worst case all combinations explored
(but actually less due to constraint)

Exact count follows Fibonacci pattern.

-----------------------------------------------------

Space Complexity

O(n)

Recursion stack depth = n

-----------------------------------------------------

Key Interview Points

• Classic backtracking problem
• Constraint-based generation
• Avoid invalid states early (pruning)
• Similar to:
  → generating parentheses
  → subsets with constraints

-----------------------------------------------------

Common Mistakes

• Not tracking last digit
• Allowing "11" accidentally
• Generating all strings then filtering (inefficient)
• Wrong recursion order (breaks sorting)

-----------------------------------------------------

IMPORTANT INSIGHT (INTERVIEW LEVEL)

Number of valid strings follows Fibonacci:

n=1 → 2  
n=2 → 3  
n=3 → 5  
n=4 → 8  

Because:

f(n) = f(n-1) + f(n-2)

-----------------------------------------------------

Code Explanation

generateBinaryStrings:
→ initializes result list
→ starts recursion

generateAns:
→ builds string step-by-step
→ ensures no consecutive 1s
→ adds valid strings to result

-----------------------------------------------------
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