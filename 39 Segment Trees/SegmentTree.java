public class SegmentTree {

    /*
      Segment Tree (Range Sum Query)

      Use-case:
      - Fast range sum queries: sum(qi...qj)
      - (Later) Fast updates also possible

      tree[] is used to store segment sums
      Size = 4*n (safe size for segment tree storage)
    */

    static int tree[];

    // Initialize Segment Tree array
    public static void init(int n) {
        tree = new int[4 * n];
    }

    /*
      Build Segment Tree (Sum Tree)

      buildST(arr, i, start, end) means:
      - We are building tree node at index i
      - This node represents range [start ... end]
      - tree[i] stores sum of arr[start ... end]
    */
    public static int buildST(int arr[], int i, int start, int end) {

        // Base case:
        // If range has only one element, store it directly
        if (start == end) {
            tree[i] = arr[start];
            return tree[i];
        }

        // Find mid to split range into left and right halves
        int mid = (start + end) / 2;

        // Build left subtree for range [start ... mid]
        buildST(arr, 2 * i + 1, start, mid);

        // Build right subtree for range [mid+1 ... end]
        buildST(arr, 2 * i + 2, mid + 1, end);

        // Store sum of left + right child in current node
        tree[i] = tree[2 * i + 1] + tree[2 * i + 2];

        return tree[i];
    }

    /*
      Range Sum Query Utility

      getSumUtil(i, si, sj, qi, qj) means:
      - Current node index = i
      - Segment range = [si ... sj]
      - Query range = [qi ... qj]

      Overlap cases:
      1) No overlap       -> return 0
      2) Complete overlap -> return tree[i]
      3) Partial overlap  -> return leftSum + rightSum
    */
    public static int getSumUtil(int i, int si, int sj, int qi, int qj) {

        // Case 1: No overlap
        if (qj < si || qi > sj) {
            return 0;
        }

        // Case 2: Complete overlap
        if (si >= qi && sj <= qj) {
            return tree[i];
        }

        // Case 3: Partial overlap
        int mid = (si + sj) / 2;

        // Query left child range [si ... mid]
        int left = getSumUtil(2 * i + 1, si, mid, qi, qj);

        // Query right child range [mid+1 ... sj]
        int right = getSumUtil(2 * i + 2, mid + 1, sj, qi, qj);

        // Total sum = left + right
        return left + right;
    }

    /*
      Public function for Range Sum Query

      getSum(arr, qi, qj) returns:
      - sum of elements from index qi to qj (inclusive)
    */
    public static int getSum(int arr[], int qi, int qj) {
        int n = arr.length;
        return getSumUtil(0, 0, n - 1, qi, qj);
    }

    public static void updateUtil(int i, int si, int sj, int idx, int diff){
      if(idx > sj || idx < si){
        return;
      }

      tree[i] += diff;
      if(si != sj){
        int mid = (si + sj)/2;
        updateUtil(2*i+1, si, mid, idx, diff);
        updateUtil(2*i+2, mid+1, sj, idx, diff);
      }
    }

    public static void update(int arr[], int idx, int newValue){
      int n = arr.length;
      int diff = newValue - arr[idx];
      arr[idx] = newValue;

      updateUtil(0, 0, n-1, idx, diff);
    }

    public static void main(String[] args) {

        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int n = arr.length;

        init(n);
        System.out.println(buildST(arr, 0, 0, n - 1)); // Output: 36

        // Query sum from index 2 to 5 => 3+4+5+6 = 18
        System.out.println(getSum(arr, 2, 5)); 

        update(arr, 2, 2);
        System.out.println(getSum(arr, 2, 5));
    }
}

/*
Time Complexity:
1) Build Segment Tree:
- O(n)

2) Range Sum Query:
- O(log n) average / O(log n)

Space Complexity:
- O(4n) ~ O(n)
*/
