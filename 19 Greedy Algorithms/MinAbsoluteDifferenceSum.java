// Problem: Minimum Absolute Difference Sum
/*
This program finds the minimum possible sum of absolute differences
between two arrays A[] and B[] by optimally pairing their elements.

Goal:
Minimize ∑|A[i] - B[i]| by reordering elements.

Concept:
1. Sort both arrays in ascending order.
2. Pair elements at the same index (A[i] with B[i]).
3. Compute and sum their absolute differences.

Why Sorting Works:
- Sorting ensures that elements are paired as closely as possible in value.
- Pairing the smallest with the smallest, next smallest with next smallest, etc.,
  minimizes the overall absolute difference sum (Greedy approach).

Example:
Input:
A = [1, 2, 3]
B = [2, 1, 3]

After sorting:
A = [1, 2, 3]
B = [1, 2, 3]

Output:
Sum = |1-1| + |2-2| + |3-3| = 0
*/

import java.util.*;

public class MinAbsoluteDifferenceSum {

    // Function to find minimum absolute difference sum
    public static int findMinAbsDiffSum(int A[], int B[]) {
        int minSum = 0;

        // Step 1: Sort both arrays
        Arrays.sort(A);
        Arrays.sort(B);

        // Step 2: Calculate sum of absolute differences
        for (int i = 0; i < A.length; i++) {
            minSum += Math.abs(A[i] - B[i]);
        }

        return minSum;
    }

    // Main method for testing
    public static void main(String[] args) {
        int A[] = {1, 2, 3};
        int B[] = {2, 1, 3};

        System.out.println("Minimum Absolute Difference Sum: " + findMinAbsDiffSum(A, B));
    }
}

/*
Dry Run:
Input:
A = [1, 2, 3]
B = [2, 1, 3]

Step 1: Sort both arrays
A = [1, 2, 3]
B = [1, 2, 3]

Step 2: Compute sum
|1-1| + |2-2| + |3-3| = 0 + 0 + 0 = 0

Output: 0

Time Complexity:
- Sorting: O(n log n)
- Summation: O(n)
Total = O(n log n)

Space Complexity: O(1)
- In-place sorting (if we ignore recursion stack).

Concept Used:
- Greedy Algorithm
- Sorting to minimize total difference
*/
