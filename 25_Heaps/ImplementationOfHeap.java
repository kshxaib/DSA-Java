import java.util.*;

public class ImplementationOfHeap {

    static class Heap {
        ArrayList<Integer> list = new ArrayList<>();

        public void insert(int data) {
            list.add(data);

            int childIdx = list.size() - 1;
            int parentIdx = (childIdx - 1) / 2;

            while (childIdx > 0 && list.get(childIdx) < list.get(parentIdx)) {

                int temp = list.get(childIdx);
                list.set(childIdx, list.get(parentIdx));
                list.set(parentIdx, temp);

                childIdx = parentIdx;
                parentIdx = (childIdx - 1) / 2;
            }
        }

        public int peek() {
            return list.get(0);
        }

        public void heapify(int i) {
            int left = 2 * i + 1;  
            int right = 2 * i + 2;  

            int minIdx = i;  

            if (left < list.size() && list.get(minIdx) > list.get(left)) {
                minIdx = left;
            }

            if (right < list.size() && list.get(minIdx) > list.get(right)) {
                minIdx = right;
            }

            if (minIdx != i) {
                int temp = list.get(i);
                list.set(i, list.get(minIdx));
                list.set(minIdx, temp);

                heapify(minIdx);
            }
        }

        public int remove() {
            int first = list.get(0);
            int last = list.get(list.size() - 1);
            list.set(0, last);
            list.set(list.size() - 1, first);

            list.remove(list.size() - 1);

            heapify(0);

            return first;
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
 insert -> O(log n)
 remove -> O(log n)
 peek -> O(1)
*/
