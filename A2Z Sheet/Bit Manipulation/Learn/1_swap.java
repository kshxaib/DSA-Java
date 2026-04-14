/*
        SWAP TWO NUMBERS (WITHOUT EXTRA VARIABLE - XOR METHOD)

Definition:
Swap two integers a and b WITHOUT using
any extra variable.


Example

Input:
a = 5, b = 3

Output:
[3, 5]


Core Idea (XOR Trick)

Use XOR (^) properties:
1. x ^ x = 0
2. x ^ 0 = x
3. XOR is commutative


Step-by-Step Process

Initial:
a = 5 (101)
b = 3 (011)


Step 1
a = a ^ b
a = 101 ^ 011 = 110 (6)

Now:
a = 6, b = 3


Step 2
b = a ^ b
b = 110 ^ 011 = 101 (5)

Now:
a = 6, b = 5


Step 3
a = a ^ b
a = 110 ^ 101 = 011 (3)

Now:
a = 3, b = 5


Time Complexity: O(1)
Space Complexity: O(1)
*/

class Solution {
    public int[] swap(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        return new int []{a, b};
    }
}