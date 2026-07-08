import java.util.*;

class Solution {
     public TreeNode mergeBST(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        inorder(root1, list1);
        inorder(root2, list2);

        List<Integer> merged = merge(list1, list2);

        return buildBST(merged, 0, merged.size() - 1);
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null) return;

        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    private List<Integer> merge(List<Integer> a, List<Integer> b) {
        List<Integer> ans = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < a.size() && j < b.size()) {
            if (a.get(i) <= b.get(j)) {
                ans.add(a.get(i));
                i++;
            } else {
                ans.add(b.get(j));
                j++;
            }
        }

        while (i < a.size()) {
            ans.add(a.get(i));
            i++;
        }

        while (j < b.size()) {
            ans.add(b.get(j));
            j++;
        }

        return ans;
    }

     private TreeNode buildBST(List<Integer> arr, int start, int end) {
        if (start > end) return null;

        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(arr.get(mid));

        root.left = buildBST(arr, start, mid - 1);
        root.right = buildBST(arr, mid + 1, end);

        return root;
    }
}



