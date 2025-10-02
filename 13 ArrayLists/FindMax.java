import java.util.ArrayList;

public class FindMax {
    public static int findMaximum(ArrayList<Integer> list){
        int max = Integer.MIN_VALUE;
        for(int i=0; i<list.size(); i++){
            if(max < list.get(i)){
                max = list.get(i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(90);
        list.add(30);
        list.add(40);
        list.add(50);

        System.out.print("Maximum element: " + findMaximum(list));
    }    
}
