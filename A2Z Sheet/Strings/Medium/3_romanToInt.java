/*
        ROMAN TO INTEGER

Problem:
Given a Roman numeral string s,
convert it to its integer value.

Roman numerals use 7 symbols.
Symbol      Value
I           1
V           5
X           10
L           50
C           100
D           500
M           1000


Key Rule (Important)

Normally Roman numbers go
LEFT → RIGHT from larger to smaller.

Example
VIII
5 + 3 = 8

BUT there is a subtraction rule.
If a smaller value appears before a larger value,
we subtract it.

Example
IV = 4  (5 - 1)
IX = 9  (10 - 1)


Step-by-Step Algorithm
1. Create a function to convert Roman char → value.
2. Traverse string from left to right.
3. Get current value.
4. Compare with next value.
5. If current < next → subtract.
6. Else → add.
7. Return total.


Complexities
Time Complexity  : O(n)

We scan the string once.

Space Complexity : O(1)
*/

class Solution {

    public int romanToInt(String s) {

        int total = 0;

        for(int i = 0; i < s.length(); i++){

            int current = value(s.charAt(i));

            if(i < s.length() - 1 && current < value(s.charAt(i + 1))){
                total -= current;
            } else {
                total += current;
            }
        }

        return total;
    }

    private int value(char c){

        switch(c){

            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;

        }

        return 0;
    }
}

// Time Complexity  : O(n)
// Space Complexity : O(1)