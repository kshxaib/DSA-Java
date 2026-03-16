public class introduction {
    public static class Node {
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        // Array to Linked List
        int arr[] = {1, 2, 3, 4, 5};

        Node head = new Node(arr[0]);
        Node tail = head;

        for(int i = 1; i < arr.length; i++){
            Node temp = new Node(arr[i]);
            tail.next = temp;
            tail = temp;
        }

        // Traverse on Linked List
        Node curr = head;
        while(curr != null){
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println("null");

        // Length of Linked List
        int size = 0;
        Node temp = head;
        while(temp != null){
            temp = temp.next;
            size++;
        }
        System.out.print("Lenngth of Linked list is: " + size);
    }
}