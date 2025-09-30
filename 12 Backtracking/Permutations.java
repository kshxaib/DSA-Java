// Problem: Print all permutations of a string using recursion
/*
📌 Problem Statement:
Given a string, generate and print all possible permutations
of its characters.

👉 Idea:
- At each step, pick one character as the current choice.
- Remove that character from the remaining string.
- Recursively generate permutations of the reduced string.
- Append chosen character to the answer string.
*/

public class Permutations {

    // Recursive function to print all permutations
    public static void printPermutations(String str, String ans){
        // Base case: if string becomes empty → one permutation complete
        if(str.length() == 0){
            System.out.println(ans);
            return;
        }

        // Loop over each character in the string
        for(int i=0; i<str.length(); i++){
            // Pick the current character
            char currentChar = str.charAt(i);

            // Form the remaining string by removing current character
            String newStr = str.substring(0, i) + str.substring(i+1, str.length());

            // Recursive call → build permutation with currentChar added to ans
            printPermutations(newStr, ans + currentChar);
        }
    }

    public static void main(String[] args) {
        String str = "abc";
        String ans = "";   // initially empty answer
        printPermutations(str, ans); // start recursion
    }
}

/*
📌 Dry Run (str = "abc"):

1. Pick 'a' → newStr = "bc"
   → Pick 'b' → newStr="c" → ans="ab" → then "abc"
   → Pick 'c' → newStr="b" → ans="ac" → then "acb"

2. Pick 'b' → newStr = "ac"
   → Pick 'a' → newStr="c" → ans="ba" → then "bac"
   → Pick 'c' → newStr="a" → ans="bc" → then "bca"

3. Pick 'c' → newStr = "ab"
   → Pick 'a' → newStr="b" → ans="ca" → then "cab"
   → Pick 'b' → newStr="a" → ans="cb" → then "cba"

✅ Output:
abc
acb
bac
bca
cab
cba

---
📊 Time Complexity:
- n! permutations for string of length n.
- Each permutation takes O(n) to construct.
- Total = O(n × n!).

📊 Space Complexity:
- O(n) recursion depth.
- O(n) space for temporary strings.
*/
