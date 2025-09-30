// Problem: Generate All Subsets of a String using Recursion
/*
📌 Problem Statement:
Given a string, generate all possible subsets (the power set) using recursion.

👉 Key Idea (Inclusion/Exclusion with Backtracking):
   - At each character, we have 2 choices:
     1. Include the current character in the subset.
     2. Exclude the current character.
   - Continue this process for every character → gives all subsets.
*/

public class Subsets {

    /*
     * Recursive function to generate subsets.
     * str   → Original string
     * ans   → Current subset being built
     * index → Current index in string
     */
    public static void findSubsets(String str, String ans, int index){
        // Base case: If we reach the end of the string → print current subset
        if(index == str.length()){
            System.out.println(ans);
            return;
        }

        // ✅ Choice 1: Include current character in subset
        findSubsets(str, ans + str.charAt(index), index + 1);

        // ✅ Choice 2: Exclude current character from subset
        findSubsets(str, ans, index + 1);
    }

    public static void main(String[] args) {
        String str = "abc";
        String ans = "";
        findSubsets(str, ans, 0);  // Start recursion from index=0
    }
}

/*
📌 Dry Run for str = "abc":

At index=0 → char='a'
   - Include 'a' → ans="a"
       index=1 → char='b'
           - Include 'b' → ans="ab"
               index=2 → char='c'
                   - Include 'c' → ans="abc" → print
                   - Exclude 'c' → ans="ab"  → print
           - Exclude 'b' → ans="a"
               index=2 → char='c'
                   - Include 'c' → ans="ac" → print
                   - Exclude 'c' → ans="a"  → print
   - Exclude 'a' → ans=""
       index=1 → char='b'
           - Include 'b' → ans="b"
               index=2 → char='c'
                   - Include 'c' → ans="bc" → print
                   - Exclude 'c' → ans="b"  → print
           - Exclude 'b' → ans=""
               index=2 → char='c'
                   - Include 'c' → ans="c" → print
                   - Exclude 'c' → ans=""   → print

✅ Output (all subsets):
abc
ab
ac
a
bc
b
c
(empty subset)

---
📊 Time Complexity:
   - Each character has 2 choices (include/exclude).
   - For n characters → 2^n subsets.
   - Total complexity = O(2^n).

📊 Space Complexity:
   - O(n) recursion depth (max stack calls).
   - O(n) for storing subset string at each recursion level.
*/
