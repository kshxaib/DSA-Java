Find Peak Element - II
Subscribe to TUF+

Hints
Company
Given a 0-indexed n x m matrix mat where no two adjacent cells are equal, find any peak element mat[i][j] and return the array [i, j].A peak element in a 2D grid is an element that is strictly greater than all of its adjacent neighbours to the left, right, top, and bottom.



Assume that the entire matrix is surrounded by an outer perimeter with the value -1 in each cell.



Note: As there can be many peak values, 1 is given as output if the returned index is a peak number, otherwise 0.


Example 1

Input: mat=[[10, 20, 15], [21, 30, 14], [7, 16, 32]]

Output: [1, 1]

Explanation: The value at index [1, 1] is 30, which is a peak element because all its neighbours are smaller or equal to it. Similarly, {2, 2} can also be picked as a peak.

Example 2

Input: mat=[[10, 7], [11, 17]]

Output : [1, 1]

Explanation:The value at index [1, 1] is 17, which is the only peak element because all its neighbours are smaller or equal to it. 

class Solution {
    public int[] findPeakGrid(int[][] mat) {
      int m = mat[0].length;
      int start = 0;
      int end = m -1;

      while(start <= end){
        int midCol = start + (end - start)/2;
        int maxIdx = findMax(mat, midCol); 

        int maxEle = mat[maxIdx][midCol];

        int left = midCol -1 >= 0 ? mat[maxIdx][midCol -1] : -1; 
        int right = midCol +1 < m ? mat[maxIdx][midCol +1] : -1;

        if(maxEle > left && maxEle > right){
            return new int[] {maxIdx, midCol};
        }  
        else if (maxEle < left){
            end = midCol -1;
        } else {
            start = midCol +1;
        }
      }

      return new int[] {-1, -1};
    }

    public int findMax(int mat[][], int col){
        int max = -1;
        int maxIdx = -1;
        for(int i=0; i<mat.length; i++){
            if(mat[i][col] > max){
                max = mat[i][col];
                maxIdx = i;
            }
        }

        return maxIdx;
    }
}

give notes with code