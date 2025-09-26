// Problem: Find length of a string using recursion
/*
📌 Problem Statement:
Given a string, find its length without using any built-in length() function.

👉 Approach:
- Recursively reduce the string by removing the first character (substring).
- At each recursive call:
   - If string becomes empty → return 0 (base case).
   - Otherwise → return 1 + recursive call on remaining string.
*/

public class Question3 {

    // Recursive function to find length of string
    public static int findLength(String str) {
        // Print current string at each recursive step (for tracing/debugging)
        System.out.println("String: " + str);

        // Base case: if string is empty, length = 0
        if (str.equals("")) {
            return 0;
        }

        // Recursive case: count 1 char + recurse for rest of the string
        return 1 + findLength(str.substring(1));
    }

    public static void main(String[] args) {
        String str = "recursion";

        // Call recursive function
        int length = findLength(str);

        // Final output
        System.out.println("Length of string: " + length);
    }
}

/*
📌 Dry Run:
str = "recursion"

Step 1: "recursion" → not empty → 1 + findLength("ecursion")
Step 2: "ecursion" → not empty → 1 + findLength("cursion")
Step 3: "cursion" → not empty → 1 + findLength("ursion")
...
Step 9: "n" → not empty → 1 + findLength("")
Step 10: "" → empty → return 0

Now, add up all 1’s:
1+1+1+1+1+1+1+1+1 = 9

✅ Output = Length of string: 9

✅ Time Complexity: O(n) → one recursive call per character
✅ Space Complexity: O(n) → recursion stack depth = string length
*/
