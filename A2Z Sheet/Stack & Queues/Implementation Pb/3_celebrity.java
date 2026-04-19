/*
        CELEBRITY PROBLEM

Definition:
There are n people at a party.

Matrix M:

M[i][j] = 1  → person i knows j
M[i][j] = 0  → person i does NOT know j

Find celebrity.


Celebrity Conditions

A celebrity:
1. Knows nobody
2. Everyone knows them


Example

Input:

M = [
[0,1,1],
[0,0,0],
[0,1,0]
]

Output:
1

Explanation:

Person 1 knows nobody
0 knows 1
2 knows 1

So person 1 is celebrity.


Optimal Idea (Two Pointer Elimination)

Use two pointers:
top = 0
down = n-1


Why This Works

Compare top and down:

If top knows down:
M[top][down] == 1

Then top cannot be celebrity.
Move top++


Else if down knows top:
M[down][top] == 1

Then down cannot be celebrity.
Move down--


Else:
Neither qualifies confidently,
remove both candidates.


After elimination:
Only one possible candidate remains.


Time Complexity
Elimination: O(n)
Verification: O(n)
Total: O(n)

Space Complexity: O(1)
*/

class Solution {
    public int celebrity(int[][] M) {
        int n = M.length;

        int top = 0;
        int down = n - 1;

        // eliminate impossible candidates
        while(top < down){
            if(M[top][down] == 1){
                top++;
            }
            else if(M[down][top] == 1){
                down--;
            }
            else{
                top++;
                down--;
            }
        }

        if(top > down) return -1;

        // verify candidate
        for(int i = 0; i < n; i++){
            if(i == top) continue;

            if(M[top][i] != 0 || M[i][top] != 1){
                return -1;
            }
        }

        return top;
    }
}