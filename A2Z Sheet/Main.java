import java.util.*;

/**
 * Main
 */
class Solution {
    public int findMedian(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[] arr = new int[n * m];

        int idx = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[idx++] = matrix[i][j];
            }
        }

        Arrays.sort(arr);

        return arr[(n * m) / 2];
    }
}


// Node class represents a node in the linked list
class Node {
    int data;      // Data value
    Node next;     // Pointer to next node

    // Constructor with data and next
    Node(int data1, Node next1) {
        data = data1;
        next = next1;
    }

    // Constructor with only data
    Node(int data1) {
        data = data1;
        next = null;
    }
}

public class Main {
    public static void main(String[] args) {

        // Create an array
        int[] arr = {2, 5, 8, 7};

        // Create first node
        Node y = new Node(arr[0]);

        // Print memory reference of node
        System.out.println(y);

        // Print data stored in node
        System.out.println(y.data);
    }
}