import java.util.*;

public class ImplementationOfHeap {
    static class Heap {
        ArrayList<Integer> list = new ArrayList<>();

        public void insert(int data) {
            // Step 1: Insert at last index
            list.add(data);

            // Step 2: Fix the heap (bubble up)
            int childIdx = list.size() - 1;
            int parentIdx = (childIdx - 1) / 2;

            // While child is smaller than parent (Min-Heap)
            while (childIdx > 0 && list.get(childIdx) < list.get(parentIdx)) {

                // Swap child and parent
                int temp = list.get(childIdx);
                list.set(childIdx, list.get(parentIdx));
                list.set(parentIdx, temp);

                // Move upward
                childIdx = parentIdx;
                parentIdx = (childIdx - 1) / 2;
            }
        }

        public int peek(){
            return list.get(0);
        }

        public void printHeap() {
            System.out.println(list);
        }
    }

    public static void main(String[] args) {
        Heap hp = new Heap();
        hp.insert(2);
        hp.insert(3);
        hp.insert(4);
        hp.insert(5);
        hp.insert(10);
        hp.insert(1);

        hp.printHeap(); 
    }
}


/*
Time Complexity:
 insert -> O(logn)
 peek -> O(1)
*/