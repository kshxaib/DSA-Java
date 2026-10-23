class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();

        if(root == null) return ans;

        queue.offer(root);

        while(!queue.isEmpty()){
            int currLvlSize = queue.size();
            List<Integer> currLvl = new ArrayList<>();

            for(int i=0; i<currLvlSize; i++){
                TreeNode node = queue.poll();

                if(node.left != null){
                    queue.offer(node.left);
                }

                if(node.right != null){
                    queue.offer(node.right);
                }

                currLvl.add(node.val);
            }

            ans.add(currLvl);
        }       

        return ans;
    }
}