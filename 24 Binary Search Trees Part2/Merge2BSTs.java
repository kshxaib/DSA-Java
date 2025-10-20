import java.util.ArrayList;

public class Merge2BSTs {
    static class Node {
        int data;
        Node left, right;
        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static void getInorder(Node root, ArrayList<Integer> arr){
        if(root == null){
            return;
        }

        getInorder(root.left, arr);
        arr.add(root.data);
        getInorder(root.right, arr);
    }

    public static Node createBST(ArrayList<Integer> arr, int start, int end){
        if(start > end){
            return null;
        }

        int mid = (start + end) /2;

        Node newNode = new Node(arr.get(mid));
        newNode.left = createBST(arr, start, mid-1);
        newNode.right = createBST(arr, mid+1, end);

        return newNode;
    }

    public static Node mergeBSTs(Node root1, Node root2){
        ArrayList<Integer> arr1 = new ArrayList<>();
        getInorder(root1, arr1);

        ArrayList<Integer> arr2 = new ArrayList<>();
        getInorder(root2, arr2);

        //merge
        int i=0, j=0;
        ArrayList<Integer> mergedArr = new ArrayList<>();
        while (i<arr1.size() && j<arr2.size()) {
            if(arr1.get(i) <= arr2.get(j)){
                mergedArr.add(arr1.get(i));
                i++;
            } else{
                mergedArr.add(arr2.get(j));
                j++;
            }
        }

        while(i<arr1.size()){
            mergedArr.add(arr1.get(i));
            i++;
        }

        while(j<arr2.size()){
            mergedArr.add(arr2.get(j));
            j++;
        }

        //
        Node root = createBST(mergedArr, 0, mergedArr.size() -1 );
        return root;
    }

    public static void preorderTraversal(Node root){
        if(root == null){
            return;
        }

        System.out.print(root.data + " ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    public static void main(String[] args) {
        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);

        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);

        Node root = mergeBSTs(root1, root2);
        preorderTraversal(root);
    }
}
