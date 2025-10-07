import java.util.LinkedList;

/*
Problem: Sort a Linked List using Merge Sort Algorithm

Problem Statement:
Given an unsorted singly linked list, we need to sort it in ascending order 
using the Merge Sort algorithm.

💡 Key Idea (Divide & Conquer):
Divide the linked list into two halves using the middle node.
Recursively sort both halves.
Merge both sorted halves into one sorted linked list.

Why Merge Sort works well for Linked Lists:
- No need for random access (unlike arrays).
- Splitting and merging can be done in O(1) space.
*/

public class MergeSort {

    // Node class — represents one element in the linked list
    public static class Node {
        int data;   // stores the node's data
        Node next;  // pointer to the next node

        // Constructor to create a new node
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Function to find the middle node of the linked list
    /*
    Approach:
    - Use two pointers (slow, fast).
    - Move `slow` by 1 step and `fast` by 2 steps.
    - When `fast` reaches the end, `slow` will be at the middle.
    */
    private Node getMid(Node head) {
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;        // move slow one step
            fast = fast.next.next;   // move fast two steps
        }

        // slow is now pointing to the mid node
        return slow;
    }

    // Function to merge two sorted linked lists
    /*
    Idea:
    - Create a dummy node to start merging.
    - Compare elements from both lists one by one.
    - Append the smaller one to the merged list.
    - Continue until one list is empty.
    - Finally, attach the remaining nodes (if any).
    */
    private Node merge(Node leftHalf, Node rightHalf) {
        Node mergedLL = new Node(-1);  // dummy node for simplicity
        Node temp = mergedLL;          // pointer to build the new list

        // Compare elements from both halves
        while (leftHalf != null && rightHalf != null) {
            if (leftHalf.data <= rightHalf.data) {
                temp.next = leftHalf;
                leftHalf = leftHalf.next;
            } else {
                temp.next = rightHalf;
                rightHalf = rightHalf.next;
            }
            temp = temp.next;
        }

        // Append remaining nodes (if any)
        while (leftHalf != null) {
            temp.next = leftHalf;
            leftHalf = leftHalf.next;
            temp = temp.next;
        }

        while (rightHalf != null) {
            temp.next = rightHalf;
            rightHalf = rightHalf.next;
            temp = temp.next;
        }

        // Return merged sorted list (skip dummy node)
        return mergedLL.next;
    }

    // Recursive Merge Sort
    /*
    Recursive Steps:
    Base Case → If 0 or 1 element, return as it is.
    Find middle node.
    Split into left & right halves.
    Recursively sort both halves.
    Merge the sorted halves.
    */
    public Node mergeSort(Node head) {
        // Base case: single node or empty list
        if (head == null || head.next == null) {
            return head;
        }

        // Step 1: Find middle node
        Node mid = getMid(head);

        // Step 2: Split list into two halves
        Node rightHead = mid.next;
        mid.next = null;

        // Step 3: Sort both halves recursively
        Node leftHalfSorted = mergeSort(head);
        Node rightHalfSorted = mergeSort(rightHead);

        // Step 4: Merge both sorted halves
        Node fullSortedLL = merge(leftHalfSorted, rightHalfSorted);

        // Return the fully sorted list
        return fullSortedLL;
    }

    // Global head node
    public static Node head;

    public static void main(String[] args) {
        MergeSort list = new MergeSort();

        // Create unsorted linked list: 4 -> 2 -> 5 -> 1 -> 3
        list.head = new Node(4);
        list.head.next = new Node(2);
        list.head.next.next = new Node(5);
        list.head.next.next.next = new Node(1);
        list.head.next.next.next.next = new Node(3);

        System.out.println("Original Linked List:");
        printList(list.head);

        // Sort using Merge Sort
        Node sortedHead = list.mergeSort(list.head);

        System.out.println("Sorted Linked List:");
        printList(sortedHead);
    }

    // Helper function to print the linked list
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}

/*
Dry Run Example:

Original List: 4 → 2 → 5 → 1 → 3

Step 1: Find mid → split into [4,2,5] and [1,3]
Step 2: Recursively sort each half
         → [4,2,5] → [2,4,5]
         → [1,3]   → [1,3]
Step 3: Merge both → [1,2,3,4,5]

Final Output:
1 -> 2 -> 3 -> 4 -> 5 -> null

---

Time Complexity:
- O(n log n) → due to recursive splitting and merging.

Space Complexity:
- O(log n) → recursion stack (no extra linked list used).
*/
