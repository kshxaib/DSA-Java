/*
        MEDIAN IN A ROW-WISE SORTED MATRIX

Problem:
Given a matrix where every row is sorted in ascending order,
find the median of the matrix.

Note:
The matrix itself is NOT fully sorted.
Only each individual row is sorted.


Example 1
matrix =
[
 [1,4,9],
 [2,5,6],
 [3,7,8]
]

Sorted order if flattened: [1,2,3,4,5,6,7,8,9]

Median = 5

Example 2
matrix =
[
 [1,3,8],
 [2,3,4],
 [1,2,5]
]

Flattened sorted array: [1,1,2,2,3,3,4,5,8]

Median = 3


Core Idea
The median is the element whose position is: (n * m) / 2

We binary search the possible values between:
        minimum element
        maximum element


Search Space
Minimum element = minimum of first column.
Maximum element = maximum of last column.

Example:
matrix =
[
 [1,4,9],
 [2,5,6],
 [3,7,8]
]

start = 1
end   = 9


Binary Search Logic
For each candidate value (mid):
Count how many elements in the matrix are
≤ mid.

-----------------------------------------------------

Counting Elements

Since rows are sorted,
we can find count in each row using
Binary Search (upper bound).

Example:
row = [1,4,9]
x = 5

Elements ≤ 5 → [1,4]

count = 2


Algorithm Steps
1. Find minimum and maximum values in matrix.

2. Binary search between them.

3. For each mid:

        count elements ≤ mid.

4. Adjust search space.

5. Return start as median.


Complexities
Time Complexity  : O(n * log(m) * log(range))

Explanation:
Binary search on value range → log(range)
For each row → binary search → log(m)

Total rows → n

Space Complexity : O(1)
*/

class Solution {

    public int findMedian(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;

        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
            start = Math.min(start, matrix[i][0]);
            end = Math.max(end, matrix[i][m - 1]);
        }

        int required = (n * m) / 2;

        while(start <= end){

            int mid = start + (end - start) / 2;

            int smallerEquals = findSmallerEquals(matrix, mid);

            if(smallerEquals <= required){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }

        return start;
    }

    public int findSmallerEquals(int matrix[][], int x){

        int count = 0;

        for(int i = 0; i < matrix.length; i++){
            count += findUpperBound(matrix[i], x);
        }

        return count;
    }

    public int findUpperBound(int row[], int x){

        int start = 0;
        int end = row.length - 1;
        int ans = row.length;

        while(start <= end){

            int mid = start + (end - start) / 2;

            if(row[mid] > x){
                ans = mid;
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }

        return ans;
    }
}

// Time: O(n * log(m) * log(range))
// Space: O(1)