public class MCM {

    /*
      Matrix Chain Multiplication (Recursive)

      Meaning:
      - We are given an array arr[] of size (n)
      - It represents matrix dimensions:
        Matrix 1 = arr[0] x arr[1]
        Matrix 2 = arr[1] x arr[2]
        ...
        Matrix (n-1) = arr[n-2] x arr[n-1]

      Goal:
      - Find minimum number of multiplications needed
        to multiply all matrices together

      mcm(arr, i, j) means:
      - minimum cost to multiply matrices from Ai to Aj
    */
    public static int mcm(int arr[], int i, int j) {

        // Base case:
        // If only one matrix, no multiplication needed
        if (i == j) {
            return 0;
        }

        // Store minimum cost
        int minCost = Integer.MAX_VALUE;

        // Try all possible partitions between i and j
        for (int k = i; k < j; k++) {

            // Cost of multiplying left part: Ai...Ak
            int cost1 = mcm(arr, i, k);

            // Cost of multiplying right part: A(k+1)...Aj
            int cost2 = mcm(arr, k + 1, j);

            /*
              Cost of multiplying the two resulting matrices:

              Left result dimension  = arr[i-1] x arr[k]
              Right result dimension = arr[k] x arr[j]

              Multiplication cost = arr[i-1] * arr[k] * arr[j]
            */
            int cost3 = arr[i - 1] * arr[k] * arr[j];

            // Total cost for this partition
            int finalCost = cost1 + cost2 + cost3;

            // Take minimum over all partitions
            minCost = Math.min(minCost, finalCost);
        }

        return minCost;
    }

    public static void main(String[] args) {

        int arr[] = { 1, 2, 3, 4, 3 };
        int n = arr.length;

        // Multiply matrices from A1 to A(n-1)
        System.out.println(mcm(arr, 1, n - 1)); // Output: 30
    }
}

/*
Time Complexity:
- Exponential (very slow)
  because we try all partitions and repeat subproblems

Space Complexity:
- O(n)
  due to recursion stack
*/
