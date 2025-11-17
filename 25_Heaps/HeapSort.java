public class HeapSort {

    // Function to perform heap sort
    public static void heapSort(int arr[]) {
        int n = arr.length;

        // Step 1: Build Max Heap
        for (int i = n/2; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Step 2: Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {

            // Move current root (max element) to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Heapify the reduced heap
            heapify(arr, i, 0);
        }
    }

    // Heapify function to maintain Max Heap at index i
    public static void heapify(int arr[], int size, int i) {
        int largest = i;       // assume parent is largest
        int left = 2 * i + 1;  // left child index
        int right = 2 * i + 2; // right child index

        // If left child exists and is greater than parent
        if (left < size && arr[left] > arr[largest]) {
            largest = left;
        }

        // If right child exists and is greater than current largest
        if (right < size && arr[right] > arr[largest]) {
            largest = right;
        }

        // If parent is not largest, swap and heapify further
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            // Recursively fix affected subtree
            heapify(arr, size, largest);
        }
    }

    public static void printArray(int arr[]) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = {4, 10, 3, 5, 1};

        System.out.println("Original array:");
        printArray(arr);

        heapSort(arr);

        System.out.println("Sorted array:");
        printArray(arr);
    }
}
