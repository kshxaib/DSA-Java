import java.util.ArrayList;

public class InsertInHeap{

    static class Heap{
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data){
            // add at last index
            arr.add(data);

            int myIdx = arr.size()-1;
            int parentIdx = (myIdx -1)/2;
            while (arr.get(myIdx) > arr.get(parentIdx)) {
                int temp = arr.get(parentIdx);
                arr.set(parentIdx, arr.get(myIdx));
                arr.set(myIdx, temp);
            }
        }
    }

    public static void main(String[] args) {
        
    }
}