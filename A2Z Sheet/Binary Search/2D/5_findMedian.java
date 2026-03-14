 class Solution {

    public int findMedian(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;

        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
            start = Math.min(start, matrix[i][0]);
            end = Math.max(end, matrix[i][m-1]);
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

Given a 2D array matrix that is row-wise sorted. The task is to find the median of the given matrix.


Example 1

Input: matrix=[ [1, 4, 9], [2, 5, 6], [3, 7, 8] ] 

Output: 5

Explanation: If we find the linear sorted array, the array becomes 1 2 3 4 5 6 7 8 9. So, median = 5

Example 2

Input: matrix=[ [1, 3, 8], [2, 3, 4], [1, 2, 5] ] 

Output: 3

Explanation: If we find the linear sorted array, the array becomes 1 1 2 2 3 3 4 5 8. So, median = 3