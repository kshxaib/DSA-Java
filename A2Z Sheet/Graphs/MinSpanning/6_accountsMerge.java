import java.util.*;

class Solution {

    class DisjointSet {
        List<Integer> parent = new ArrayList<>();
        List<Integer> rank = new ArrayList<>();

        DisjointSet(int n) {
            for (int i = 0; i < n; i++) {
                parent.add(i);
                rank.add(0);
            }
        }

        int findParent(int node) {
            if (node == parent.get(node)) {
                return node;
            }

            int ultimateParent = findParent(parent.get(node));
            parent.set(node, ultimateParent);
            return parent.get(node);
        }

        void unionByRank(int u, int v) {
            int ultimateParentU = findParent(u);
            int ultimateParentV = findParent(v);

            if (ultimateParentU == ultimateParentV) {
                return;
            }

            if (rank.get(ultimateParentU) < rank.get(ultimateParentV)) {
                parent.set(ultimateParentU, ultimateParentV);
            }
            else if (rank.get(ultimateParentU) > rank.get(ultimateParentV)) {
                parent.set(ultimateParentV, ultimateParentU);
            }
            else {
                parent.set(ultimateParentV, ultimateParentU);
                rank.set(ultimateParentU, rank.get(ultimateParentU) + 1);
            }
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();

        DisjointSet ds = new DisjointSet(n);

        // email -> account index
        Map<String, Integer> map = new HashMap<>();

        // Union accounts having common email
        for (int i = 0; i < n; i++) {
            List<String> account = accounts.get(i);

            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);

                if (!map.containsKey(email)) {
                    map.put(email, i);
                }
                else {
                    ds.unionByRank(i, map.get(email));
                }
            }
        }

        
        List<List<String>> mergedEmails = new ArrayList<>();    // parent -> emails
        for (int i = 0; i < n; i++) {
            mergedEmails.add(new ArrayList<>());
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String email = entry.getKey();
            int accountIndex = entry.getValue();   // node

            int ultimateParent = ds.findParent(accountIndex);

            mergedEmails.get(ultimateParent).add(email);
        }

        List<List<String>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (mergedEmails.get(i).isEmpty()) {
                continue;
            }

            Collections.sort(mergedEmails.get(i));

            List<String> temp = new ArrayList<>();
           
            temp.add(accounts.get(i).get(0));    // account name
            temp.addAll(mergedEmails.get(i));   // all emails
            ans.add(temp);
        }

        return ans;
    }
}