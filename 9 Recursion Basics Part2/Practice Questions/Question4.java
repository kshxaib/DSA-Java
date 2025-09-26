// Problem: Count substrings starting and ending with the same character
/*
📌 Problem Statement:
Given a string S, find the count of all contiguous substrings 
that start and end with the same character.

👉 Example:
Input: "abcab"
Output: 7
Explanation:
Valid substrings are:
"a", "b", "c", "a", "b", "aba", "cab"

👉 Approach:
- Use recursion with 3 parameters:
   - startIdx → starting index of substring
   - endingIdx → ending index of substring
   - length → length of current substring
- At each step:
   1. If length == 1 → every single character is a valid substring → return 1
   2. If length <= 0 → invalid → return 0
   3. Otherwise:
        count(start+1, end, len-1) +
        count(start, end-1, len-1) -
        count(start+1, end-1, len-2)
   4. If str[start] == str[end] → add +1
*/

public class Question4 {
    
    // Recursive function to count substrings
    public static int countSubstrings(String str, int startIdx, int endingIdx, int length){
        // Base case 1: single character substring → always valid
        if(length == 1){
            return 1;
        }

        // Base case 2: invalid substring
        if(length <= 0){
            return 0;
        }

        // Recursive case: reduce problem
        int count = countSubstrings(str, startIdx + 1, endingIdx, length - 1) +
                    countSubstrings(str, startIdx, endingIdx - 1, length - 1) -
                    countSubstrings(str, startIdx + 1, endingIdx - 1, length - 2);

        // If first and last characters are same → valid substring
        if(str.charAt(startIdx) == str.charAt(endingIdx)){
            count++;
        }

        return count;
    }   

    public static void main(String[] args) {
        String str = "abcab";
        int n = str.length();

        // Count substrings for the entire string
        int total = countSubstrings(str, 0, n - 1, n);

        System.out.println("Total substrings starting and ending with same character: " + total);
    }
}

/*
📌 Dry Run: str = "abcab"

Substrings:
"a", "b", "c", "a", "b" → all valid (5)
"ab", "bc", "ca", "ab" → not valid
"abc", "bca", "cab" → "cab" valid
"abca", "bcab" → "bcab" valid
"abcab" → not valid

✅ Total = 7

📌 Output:
Total substrings starting and ending with same character: 7

✅ Time Complexity: O(2^n) → recursive overlapping subproblems
✅ Space Complexity: O(n) → recursion stack

⚡ Note:
We can solve this more efficiently in O(n²) with DP or in O(n) using combinatorics (count frequency of each character).
*/
