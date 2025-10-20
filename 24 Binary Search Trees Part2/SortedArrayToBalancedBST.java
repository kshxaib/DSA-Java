public class SortedArrayToBalancedBST{

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node createBST(int arr[], int start, int end){
        if(start > end){
            return null;
        }

        int mid = (start + end) /2;
        
        Node newNode = new Node(arr[mid]);
        newNode.left = createBST(arr, start, mid-1);
        newNode.right = createBST(arr, mid+1, end);

        return newNode;
    }

    public static void inorderTraversal(Node root){
        if(root == null){
            return;
        }

        inorderTraversal(root.left);
        System.out.print(root.data + " ");
        inorderTraversal(root.right);
    }

    public static void main(String[] args) {
        int arr[] = {3,5,6,8,10,11,12};

        Node root = createBST(arr, 0, arr.length -1);
        inorderTraversal(root);
    }
}