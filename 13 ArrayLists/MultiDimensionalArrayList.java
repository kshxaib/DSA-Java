import java.util.*;

public class MultiDimensionalArrayList {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> mutliList = new ArrayList<>();
        ArrayList<Integer> List1 = new ArrayList<>();
        ArrayList<Integer> List2 = new ArrayList<>();
        ArrayList<Integer> List3 = new ArrayList<>();

        for(int i=1; i<=5; i++){
            List1.add(i);
            List2.add(i*2);
            List3.add(i*3);
        }

        mutliList.add(List1);
        mutliList.add(List2);
        mutliList.add(List3);


        for(int i=0; i<mutliList.size(); i++){
            ArrayList<Integer> currList = mutliList.get(i);
            for(int j=0; j<currList.size(); j++){
                System.out.print(currList.get(j) + " ");
            }
            System.out.println();
        }
    }
}