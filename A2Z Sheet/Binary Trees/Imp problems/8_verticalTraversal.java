import java.util.*;

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if(root == null) return result;

        // column -> level -> node values
        TreeMap<Integer, TreeMap<Integer, List<Integer>>> map = new TreeMap<>();

        // start DFS from root position (0,0)
        dfs(root, map, 0, 0);

        // traverse columns
        for(Map.Entry<Integer, TreeMap<Integer, List<Integer>>> colMap : map.entrySet()){    
            TreeMap<Integer, List<Integer>> levelMap = colMap.getValue();   
            List<Integer> valuesOfCurrCol = new ArrayList<>();

            // traverse levels
            for(Map.Entry<Integer, List<Integer>> currLevel : levelMap.entrySet()){  
                List<Integer> valuesOfCurrLevel = currLevel.getValue();

                Collections.sort(valuesOfCurrLevel);
                valuesOfCurrCol.addAll(valuesOfCurrLevel);
            }
            
            result.add(valuesOfCurrCol);
        }

        return result;
    }

    private void dfs(TreeNode root, TreeMap<Integer, TreeMap<Integer, List<Integer>>> map, int col, int lvl){
        if(root == null) return;

        // create column if not present
        if(!map.containsKey(col)){
            map.put(col, new TreeMap<>());
        }

        // create level if not present
        if(!map.get(col).containsKey(lvl)){
            map.get(col).put(lvl, new ArrayList<>());
        }

        // add node
        map.get(col).get(lvl).add(root.val);

        // left child
        dfs(root.left, map, col -1, lvl +1);

        // right child
        dfs(root.right, map, col +1, lvl +1);
    }
}