/*
        ROW WITH MAXIMUM 1s
          (BINARY SEARCH)

Problem:
Given a binary matrix where each row
is sorted in ascending order (0s first,
then 1s), find the index of the row
with the maximum number of 1s.

If multiple rows have the same number
of 1s, return the smallest index.

If no 1 exists, return -1.


Example 1
mat =
[
 [1,1,1],
 [0,0,1],
 [0,0,0]
]

Output: 0

Explanation:
Row 0 → 3 ones
Row 1 → 1 one
Row 2 → 0 ones

Maximum = row 0


Example 2
mat =
[
 [0,0],
 [0,0]
]

Output: -1

Explanation:
Matrix contains no 1.


Core Idea:

Each row is sorted.

So the first occurrence of 1
can be found using Binary Search.

Once we know where the first 1 appears,
we can count total 1s in that row.


Counting 1s
If:
first index of 1 = idx
total columns = m

Number of ones: m - idx

Example:
row = [0,0,1,1,1]

idx = 2

count = 5 - 2 = 3


Algorithm Steps

For each row:

1. Use Binary Search to find
   first occurrence of 1.

2. Count ones:

        count = m - idx

3. Track row with maximum ones.


Complexities
Time Complexity  : O(n log m)
n = number of rows
m = number of columns
Binary search per row.

Space Complexity : O(1)
*/

class Solution {
    public int rowWithMax1s(int[][] mat) {
        int rows = mat.length;

        int maxOnes = 0;
        int ans = -1;

        for (int i = 0; i < rows; i++) {
            int firstOne = findFirstOne(mat[i]);
            int ones = mat[i].length - firstOne;

            if (ones > maxOnes) {
                maxOnes = ones;
                ans = i;
            }
        }

        return ans;
    }

    private int findFirstOne(int[] row) {
        int n = row.length;
        int ans = n;

        int start = 0;
        int end = n - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (row[mid] == 1) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }
}

// Time: O(n log m)
// Space: O(1)



class Solution {
    
    public int rowWithMax1s(int[][] mat) {
       int n = mat.length;

       int maxCount = 0;
       int ans = -1;

       for(int i=0; i<n; i++){
            int count = 0;
            for(int j=0; j<n; j++){
                if(mat[i][j] == 1) count++;
            }

            if(count > maxCount){
                maxCount = count;
                ans = i;
            }
       }

       return ans;
    }
}