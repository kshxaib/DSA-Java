class Solution {
    ArrayList<Integer> heap;

    public void initializeHeap() {
        heap = new ArrayList<>();
    }

    public void insert(int key) {
        heap.add(key);

        int i = heap.size() -1;
        while(i > 0){
            int parent = (i-1)/2;

            if(heap.get(parent) <= heap.get(i)) break;

            swap(i, parent);
            i = parent;
        }
    }

    public void changeKey(int index, int newVal) {
    if(index < 0 || index >= heap.size()) return;

    int oldVal = heap.get(index);
    heap.set(index, newVal);

    if(newVal < oldVal) {
        while(index > 0) {
            int parent = (index - 1) / 2;

            if(heap.get(parent) <= heap.get(index)) break;

            swap(index, parent);
            index = parent;
        }
    } else {
        heapify(index);
    }
}

    public void extractMin() {
        if(heap.isEmpty()) return;

        int last = heap.size() - 1;
        swap(0, last);
        heap.remove(last);

        if(!heap.isEmpty()){
            heapify(0);
        }
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public int getMin() {
        if(heap.isEmpty()) return -1;
        return heap.get(0);
    }

    public int heapSize() {
        return heap.size();
    }

    private void heapify(int i){
        int n = heap.size();

        while(true){
            int smallest = i;

            int left = 2 * i +1;
            int right = 2 * i +2;

            if(left < n && heap.get(left) < heap.get(smallest)){
                smallest = left;
            }

            if(right < n && heap.get(right) < heap.get(smallest)){
                smallest = right;
            }

            if(smallest == i){
                break;
            }

            swap(i, smallest);
            i = smallest;
        }
    }

    private void swap(int i, int parent){
        int temp = heap.get(i);
        heap.set(i, heap.get(parent));
        heap.set(parent, temp);
    }
}