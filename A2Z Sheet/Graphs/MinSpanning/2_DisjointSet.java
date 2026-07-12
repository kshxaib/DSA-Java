import java.util.*;

class DisjointSet {
    List<Integer> rank = new ArrayList<>(); // approximate tree height
    List<Integer> parent = new ArrayList<>();   // immediate parent of every node
    List<Integer> size = new ArrayList<>(); // size of every component

    public DisjointSet(int n) {
        for(int i = 0; i < n; i++){ // every node starts as its own parent
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    private int findParent(int node){    // returns ultimate parent
        if(node == parent.get(node)){   // reached root
            return node;
        }

        // path compression 
        int ultimateParent = findParent(parent.get(node));
        parent.set(node, ultimateParent);   

        return parent.get(node);
    }


    public boolean find(int u, int v) { // checks whether both nodes belong to same component
        return findParent(u) == findParent(v);
    }


    public void unionByRank(int u, int v) { // merge components using rank
        int ultimateParentU = findParent(u);
        int ultimateParentV = findParent(v);

        if(ultimateParentU == ultimateParentV){ // already connected
            return;
        }

        // smaller rank joins larger rank
        if(rank.get(ultimateParentU) < rank.get(ultimateParentV)){
            parent.set(ultimateParentU, ultimateParentV);
        }

        else if(rank.get(ultimateParentV) < rank.get(ultimateParentU)){
            parent.set(ultimateParentV, ultimateParentU);
        }

        else{
            parent.set(ultimateParentV, ultimateParentU);   // attach any one
            rank.set(ultimateParentU, rank.get(ultimateParentU) + 1);   // increase rank
        }
    }


    public void unionBySize(int u, int v) {     // merge components using size
        int ultimateParentU = findParent(u);
        int ultimateParentV = findParent(v);

        if(ultimateParentU == ultimateParentV){ // already connected
            return;
        }

        // smaller component joins larger
        if(size.get(ultimateParentU) < size.get(ultimateParentV)){
            parent.set(ultimateParentU, ultimateParentV);
            size.set(ultimateParentV, size.get(ultimateParentU) + size.get(ultimateParentV));
        }

        else{
            parent.set(ultimateParentV, ultimateParentU);
            size.set(ultimateParentU, size.get(ultimateParentU) + size.get(ultimateParentV)
            );
        }
    }
}