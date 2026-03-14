/*
        REVERSE WORDS IN A STRING

Problem:
Given a string containing words separated by spaces,
reverse the order of the words.

The output must:
1. Remove leading spaces
2. Remove trailing spaces
3. Replace multiple spaces with a single space
4. Reverse the order of words


Example 1
Input: "welcome to the jungle"

Output: "jungle the to welcome"


Example 2
Input: " amazing coding skills "

Output: "skills coding amazing"

Explanation:
Leading and trailing spaces are removed
and words are reversed.


Core Idea
We solve the problem in two steps:
1. Reverse the entire string.
2. Reverse each individual word.


Complexities
Time Complexity  : O(n)

Explanation:
- Reverse string → O(n)
- Traverse string → O(n)

Space Complexity : O(n)
*/

class Solution {
    public String reverseWords(String s) {
        int n = s.length();
        StringBuilder ans = new StringBuilder();

        s = reverseString(s);

        for(int i = 0; i < n; i++) {
            StringBuilder word = new StringBuilder();

            while(i < n && s.charAt(i) != ' ') {
                word.append(s.charAt(i));
                i++;
            }

            String reversedWord = reverseString(word.toString());

            if(reversedWord.length() > 0) {
                if(ans.length() > 0) ans.append(" ");
                ans.append(reversedWord);
            }
        }

        return ans.toString();
    }

    public String reverseString(String str) {
        char[] arr = str.toCharArray();

        int left = 0;
        int right = arr.length - 1;

        while(left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }

        return new String(arr);
    }
}

// Time: O(n)
// Space: O(n)