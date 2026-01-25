public class CreationOfST {

    // Segment Tree array (stores segment sums)
    static int tree[];

    /*
      Initialize Segment Tree
      Size = 4*n (safe size to store complete tree)
    */
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

    public static void main(String[] args) {

        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int n = arr.length;

        init(n);
        System.out.println(buildST(arr, 0, 0, n - 1)); // Total sum = 36
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
