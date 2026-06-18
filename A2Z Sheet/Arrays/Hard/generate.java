/*
                PASCAL'S TRIANGLE

Problem:
Given an integer numRows, generate the first
numRows rows of Pascal's Triangle.

In Pascal's Triangle:

- First and last element of every row is 1.
- Every middle element is the sum of the two
  elements directly above it.

Example:

numRows = 5

Output:

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]

--------------------------------------------------
OBSERVATION
--------------------------------------------------

Every row starts and ends with 1.

For any middle element:

row[i][j] =
previousRow[j-1] + previousRow[j]

Example:

Previous Row:

[1,3,3,1]

Next Row:

1
1+3 = 4
3+3 = 6
3+1 = 4
1

Result:

[1,4,6,4,1]

--------------------------------------------------
CORE IDEA
--------------------------------------------------

Build rows one by one.

For each new row:

1. Add 1 at the beginning.
2. Generate middle elements using previous row.
3. Add 1 at the end.
4. Store the row.

--------------------------------------------------
ALGORITHM
--------------------------------------------------

1. Create answer list.

2. Add first row:

      [1]

3. For every row i:

      Add first 1.

      For j = 1 to i-1:

          value =
          prevRow[j-1] + prevRow[j]

          Add value.

      Add last 1.

4. Store row in answer.
*/

import java.util.*;

class Solution {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        if(numRows == 0) return ans;

        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        ans.add(firstRow);

        for(int i = 1; i < numRows; i++) {
            List<Integer> prevRow = ans.get(i - 1);

            List<Integer> newRow = new ArrayList<>();
            newRow.add(1);

            for(int j = 1; j < i; j++) {
                newRow.add( prevRow.get(j - 1) + prevRow.get(j));
            }
            newRow.add(1);

            ans.add(newRow);
        }

        return ans;
    }
}

