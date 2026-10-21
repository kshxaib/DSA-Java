class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pathP = new ArrayList<>();
        List<TreeNode> pathQ = new ArrayList<>();

        findPath(root, p, pathP);
        findPath(root, q, pathQ);

        TreeNode lca = null;
        int i=0;

        while(i<pathP.size() && i<pathQ.size() && pathP.get(i) == pathQ.get(i)){
            lca = pathP.get(i);
            i++;
        }

        return lca;
    }

    private boolean findPath(TreeNode root, TreeNode target, List<TreeNode> path) {
        if(root == null) return false;

        path.add(root);

        if(root == target) return true;

        if(findPath(root.left, target, path) || findPath(root.right, target, path)){
            return true;
        }

        path.remove(path.size() -1);
        return false;
    }
}