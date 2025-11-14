public class AVLTree {
    static class Node {
        int data;
        int height;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            height = 1;
        }
    }

    public static Node root;

    public static int height(Node root){
        if(root == null){
            return 0;
        } 
        return root.height;
    }

    public static int getBF(Node root){
        if(root == null){
            return 0;
        }

        return height(root.left) - height(root.right);
    }

    public static Node leftRotate(Node x){
        Node y = x.right;
        Node T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // update heights 
        x.height = Math.max(height(x.left), height(x.right)) +1;
        y.height = Math.max(height(y.left), height(y.right)) +1;

        return y; // new root
    }

    public static Node rightRotate(Node y){
        Node x = y.left;
        Node T2 = x.right;

        // perform rotation
        x.right = y;
        y.left = T2;

        // update heights
        y.height = Math.max(height(y.left), height(y.right)) +1;
        x.height = Math.max(height(x.left), height(x.right)) +1;

        return x; // new root
    }

    public static Node insert(Node root, int key){
        if(root == null){
            return new Node(key);
        }

        if(key < root.data){
            root.left = insert(root.left, key);
        } else if(key > root.data){
            root.right = insert(root.right, key);
        } else {
            return root;  // duplicate key not allowed
        }

        // update root height
        root.height = 1 + Math.max(height(root.left), height(root.right));

        // get root's balance factor
        int bf = getBF(root);

        // Left Left Case
        if(bf > 1 && key < root.left.data){
            return rightRotate(root);
        }

        // Right Right Case
        if(bf < -1 && key > root.right.data){
            return leftRotate(root);
        }

        // Left Right Case
        if(bf > 1 && key > root.left.data){
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // Right Left Case
        if(bf < -1 && key < root.right.data){
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    public static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        root = insert(root, 10);
        root = insert(root, 20);
        root = insert(root, 30);
        root = insert(root, 40);
        root = insert(root, 50);
        root = insert(root, 25);

        inorder(root);
    }
}
