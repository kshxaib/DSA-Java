class MedianFinder {
    ArrayList<Integer> list;

    public MedianFinder() {
        list = new ArrayList<>();
    }
    
    public void addNum(int num) {
        list.add(num);
    }
    
    public double findMedian() {
        Collections.sort(list);

        int size = list.size();

        if(size % 2 == 0){
            double midean = (list.get(size /2) + list.get(size / 2 -1)) / 2.0;
            return midean;
        } else {
            int midean = list.get(size/2);
            return midean;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */