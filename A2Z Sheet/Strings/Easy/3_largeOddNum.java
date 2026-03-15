/*
        LARGEST ODD NUMBER IN A STRING

Problem:
Given a string s representing a large integer,
find the largest-valued odd integer that is a
substring of s.

Rules:
1. The result must be odd.
2. The result must not have leading zeros.
3. If no odd number exists → return "".

-----------------------------------------------------

Example 1

Input:
s = "5347"

Possible odd numbers:
5, 3, 53, 347, 5347

Largest odd number:
5347

-----------------------------------------------------

Example 2

Input:
s = "0214638"

Possible odd numbers:
1, 3, 21, 63, 463, 1463, 21463

Largest odd number:
21463

-----------------------------------------------------

Key Observation

A number is odd if its last digit is odd.

Odd digits:
1, 3, 5, 7, 9

So we only need to find the rightmost
odd digit in the string.

-----------------------------------------------------

Core Idea

1. Traverse the string from right → left.
2. Find the first odd digit.
3. Take substring from index 0 → that index.
4. Remove leading zeros if present.

-----------------------------------------------------

Why This Works

The larger the substring length,
the larger the number value.

So the rightmost odd digit gives
the largest possible odd number.

-----------------------------------------------------

Example Walkthrough

s = "0214638"

Traverse from right:

8 → even
3 → odd

Take substring:

"021463"

Remove leading zeros:

"21463"

-----------------------------------------------------

Algorithm Steps

1. Start from last index.
2. Check if digit is odd.
3. If odd:
       take substring(0, i+1)
4. Remove leading zeros.
5. Return result.

If no odd digit found → return "".

-----------------------------------------------------

Complexities

Time Complexity  : O(n)

Explanation:
Single traversal + trimming.

Space Complexity : O(n)

Explanation:
Substring creation.

-----------------------------------------------------

Properties

• Uses digit parity rule
• Works for very large numbers (string)
• Avoids integer conversion

-----------------------------------------------------

Key Interview Points

Odd digit check:

        (digit % 2 == 1)

Substring for result:

        s.substring(0, i+1)

Remove leading zeros carefully.
*/

class Solution {    
    public String largeOddNum(String s) {
        int n = s.length();

        for(int i = n - 1; i >= 0; i--) {

            if((s.charAt(i) - '0') % 2 == 1) {
                String res = s.substring(0, i + 1);

                int j = 0;
                while(j < res.length() && res.charAt(j) == '0'){
                    j++;
                }

                return res.substring(j);
            }
        }

        return "";
    }
}

// Time: O(n)
// Space: O(n)