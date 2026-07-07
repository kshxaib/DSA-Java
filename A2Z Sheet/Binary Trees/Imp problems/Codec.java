import java.util.*;

public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        StringBuilder ans = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node == null){
                ans.append("N,");
                continue;
            }

            ans.append(node.val + ",");
            queue.offer(node.left);
            queue.offer(node.right);
        }

        return ans.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("")) return null;
        String values[] = data.split(",");

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        queue.add(root);

        int i=1;
        while(!queue.isEmpty()){
            TreeNode parent = queue.poll();
            
            if(!values[i].equals("N")){
                TreeNode leftNode = new TreeNode(Integer.parseInt(values[i]));
                parent.left = leftNode;
                queue.offer(leftNode);
            }
            i++;

            if(!values[i].equals("N")){
                TreeNode rightNode = new TreeNode(Integer.parseInt(values[i]));
                parent.right = rightNode;
                queue.offer(rightNode);
            }
            i++;
        }

        return root;
    }
}
