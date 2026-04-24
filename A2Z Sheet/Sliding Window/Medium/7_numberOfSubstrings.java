/*
        NUMBER OF SUBSTRINGS CONTAINING ALL THREE CHARACTERS

Definition:
Given string s containing only:

'a', 'b', 'c'

Return number of substrings
containing at least one:

a, b, and c


Example 1

Input:
s = "abcabc"

Output:
10


Example 2

Input:
s = "aaacb"

Output:
3

Substrings:

"aaacb"
"aacb"
"acb"


Example 3

Input:
s = "abc"

Output:
1


Core Idea
Need substrings containing:
a + b + c


1. BRUTE FORCE
Try every starting index.
Expand right and track:
hasA, hasB, hasC
If all true → valid substring

Time = O(n²)
*/

class Solution {

    public int numberOfSubstringsBrute(String s) {
        int count = 0;

        for(int i = 0; i < s.length(); i++){

            boolean hasA = false;
            boolean hasB = false;
            boolean hasC = false;

            for(int j = i; j < s.length(); j++){

                if(s.charAt(j) == 'a') hasA = true;
                if(s.charAt(j) == 'b') hasB = true;
                if(s.charAt(j) == 'c') hasC = true;

                if(hasA && hasB && hasC){
                    count++;
                }
            }
        }

        return count;
    }


/*
2. OPTIMAL SLIDING WINDOW
When window [left...right]
contains a,b,c:

Then every extension till end
is also valid.

So count:
(n - right)
Then shrink left.

Time = O(n)
Space = O(1)
*/

    public int numberOfSubstrings(String s) {
        int n = s.length();
        int freq[] = new int[3];

        int count = 0;

        int left = 0;
        int right = 0;

        while(right < n){
            // include current char
            freq[s.charAt(right) - 'a']++;

            /*
                while window contains
                a,b,c
            */
            while(freq[0] > 0 &&
                  freq[1] > 0 &&
                  freq[2] > 0){

                // all substrings ending after right valid
                count += (n - right);

                // shrink from left
                freq[s.charAt(left) - 'a']--;
                left++;
            }

            right++;
        }

        return count;
    }
}
