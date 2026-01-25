public class SegmentTree {

    /*
      Segment Tree (Range Sum Query + Point Update)

      Use-case:
      - Query sum in a range [l..r] quickly
      - Update an element quickly

      tree[] stores sums of segments
      Size = 4*n is safe for storing complete tree
    */

    static int tree[];

    // Initialize segment tree array
    public static void init(int n) {
        tree = new int[4 * n];
    }

    /*
      Build Segment Tree (Sum Tree)

      buildST(arr, i, start, end)
      i     -> current tree index
      start -> segment start index
      end   -> segment end index

      tree[i] stores:
      - sum of arr[start..end]
    */
    public static int buildST(int arr[], int i, int start, int end) {

        // Base case: single element segment
        if (start == end) {
            tree[i] = arr[start];
            return tree[i];
        }

        // Divide segment into 2 halves
        int mid = (start + end) / 2;

        // Build left subtree -> [start..mid]
        buildST(arr, 2 * i + 1, start, mid);

        // Build right subtree -> [mid+1..end]
        buildST(arr, 2 * i + 2, mid + 1, end);

        // Store sum of left + right in current node
        tree[i] = tree[2 * i + 1] + tree[2 * i + 2];

        return tree[i];
    }

    /*
      Range Sum Query (Utility)

      getSumUtil(i, si, sj, qi, qj)
      i  -> current tree index
      si -> segment start
      sj -> segment end
      qi -> query start
      qj -> query end

      Overlap cases:
      1) No overlap       -> return 0
      2) Complete overlap -> return tree[i]
      3) Partial overlap  -> split and add results
    */
    public static int getSumUtil(int i, int si, int sj, int qi, int qj) {

        // Case 1: No overlap
        if (qj < si || qi > sj) {
            return 0;
        }

        // Case 2: Complete overlap
        if (qi <= si && sj <= qj) {
            return tree[i];
        }

        // Case 3: Partial overlap
        int mid = (si + sj) / 2;

        // Query left segment
        int left = getSumUtil(2 * i + 1, si, mid, qi, qj);

        // Query right segment
        int right = getSumUtil(2 * i + 2, mid + 1, sj, qi, qj);

        // Final sum for this node
        return left + right;
    }

    /*
      Public Range Sum Query Function

      getSum(arr, qi, qj) returns:
      - sum of elements from index qi to qj (inclusive)
    */
    public static int getSum(int arr[], int qi, int qj) {
        int n = arr.length;
        return getSumUtil(0, 0, n - 1, qi, qj);
    }

    /*
      Point Update Utility

      updateUtil(i, si, sj, idx, diff)
      idx  -> index to update in original array
      diff -> newValue - oldValue

      Work:
      - If idx is inside current segment, update tree[i]
      - Then go down to left/right child until leaf node
    */
    public static void updateUtil(int i, int si, int sj, int idx, int diff) {

        // If index is outside this segment, do nothing
        if (idx < si || idx > sj) {
            return;
        }

        // Update current node sum
        tree[i] += diff;

        // If not a leaf node, go deeper
        if (si != sj) {
            int mid = (si + sj) / 2;

            // Update left child
            updateUtil(2 * i + 1, si, mid, idx, diff);

            // Update right child
            updateUtil(2 * i + 2, mid + 1, sj, idx, diff);
        }
    }

    /*
      Public Point Update Function

      update(arr, idx, newValue)
      - Updates arr[idx] to newValue
      - Updates segment tree using diff
    */
    public static void update(int arr[], int idx, int newValue) {

        int n = arr.length;

        // Calculate change in value
        int diff = newValue - arr[idx];

        // Update original array
        arr[idx] = newValue;

        // Update segment tree
        updateUtil(0, 0, n - 1, idx, diff);
    }

    public static void main(String[] args) {

        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int n = arr.length;

        init(n);
        System.out.println(buildST(arr, 0, 0, n - 1));

        System.out.println(getSum(arr, 2, 5)); 

        update(arr, 2, 2);
        System.out.println(getSum(arr, 2, 5));
    }
}

/*
Complexities:

1) Build Segment Tree:
Time  = O(n)
Space = O(n)

2) Range Sum Query:
Time  = O(log n)

3) Point Update:
Time  = O(log n)
*/
