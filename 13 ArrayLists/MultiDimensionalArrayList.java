import java.util.*;

public class MultiDimensionalArrayList {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> mutliList = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1); 
        list.add(2);
        mutliList.add(list);

        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(3);
        list1.add(4);
        mutliList.add(list1);

        for(int i=0; i<mutliList.size(); i++){
            ArrayList<Integer> currList = mutliList.get(i);
            for(int j=0; j<currList.size(); j++){
                System.out.print(currList.get(j) + " ");
            }
            System.out.println();
        }
    }
}