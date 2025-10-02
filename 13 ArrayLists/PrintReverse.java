import java.util.ArrayList;

public class PrintReverse {
    public static void printRev(ArrayList<Integer> list){
        for(int i=list.size() -1; i>=0; i--){
            System.out.print(list.get(i) + " ");
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        System.out.println("Original List: " + list);

        System.out.print("Reversed List: ");
        printRev(list);
    }
}
