public class SegmentTree {

    // Segment Tree array (stores segment sums)
    static int tree[];

    
    // Initialize Segment Tree
    // Size = 4*n (safe size to store complete tree)
    public static void init(int n) {
        tree = new int[4 * n];
    }

    /*
      Build Segment Tree (Sum Tree)

      buildST(arr, i, start, end) means:
      - Build segment tree at index i
      - Representing segment range [start ... end]

      tree[i] will store:
      - sum of elements arr[start ... end]
    */
    public static int buildST(int arr[], int i, int start, int end) {

        // Base case:
        // If segment has only one element, store it directly
        if (start == end) {
            tree[i] = arr[start];
            return tree[i];
        }

        // Divide the segment into two halves
        int mid = (start + end) / 2;

        // Build left child for range [start ... mid]
        buildST(arr, 2 * i + 1, start, mid);

        // Build right child for range [mid+1 ... end]
        buildST(arr, 2 * i + 2, mid + 1, end);

        // Current node stores sum of left + right child
        tree[i] = tree[2 * i + 1] + tree[2 * i + 2];

        return tree[i];
    }

    public static int getSumUtil(int i, int si, int sj, int qi, int qj){
        if (qj <= si || qi >= sj){
          return 0;
        } else if (si >= qi && sj <= qj){
          return tree[i];
        } else {
          int mid = (si + sj)/2;
          int left = getSumUtil(2*i+1, si, mid, qi, qj);
          int right = getSumUtil(2*i+2, mid+1, sj, qi, qj);
          return left + right;
        }
    }

    public static int getSum(int arr[], int qi, int qj){
        int n = arr.length;
        return getSumUtil(0, 0, n-1, qi, qj);
    }

    public static void main(String[] args) {

        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int n = arr.length;

        init(n);
        System.out.println(buildST(arr, 0, 0, n - 1)); // Total sum = 36

        System.out.println(getSum(arr, 2, 5));
    }
}

/*
Time Complexity:
- Build Segment Tree = O(n)
  because every element contributes once to tree

Space Complexity:
- O(4n) ~ O(n)
  due to segment tree array storage
*/
