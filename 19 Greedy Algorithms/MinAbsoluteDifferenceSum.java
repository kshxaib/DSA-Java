// Problem: Minimum Absolute Difference Sum

import java.util.*;

public class MinAbsoluteDifferenceSum {

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

    public static void main(String[] args) {
        int A[] = {4, 1, 8, 7};
        int B[] = {2, 3, 6, 5};

        System.out.println("Minimum Absolute Difference Sum: " + findMinAbsDiffSum(A, B));
    }
}

/*
Time Complexity:
- Sorting: O(n log n)
- Summation: O(n)
Total = O(n log n)

Space Complexity: O(1)
- In-place sorting (if we ignore recursion stack).
*/
