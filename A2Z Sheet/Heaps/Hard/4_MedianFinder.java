/*
        FIND MEDIAN FROM DATA STREAM


Definition:
Design a data structure that supports:

1. addNum(num)
   -> add number into stream

2. findMedian()
   -> return median of all numbers


Median

Odd count:
Middle element

Example:

[1,2,3]

Median = 2


Even count:
Average of two middle elements

Example:

[1,2,3,4]

Median = (2+3)/2 = 2.5


=====================================================
1. BRUTE FORCE (SORT EVERY TIME)
=====================================================

Store all numbers.
Whenever median needed:
Sort list and calculate median.


Why This Works

Sorting places elements
in correct order.

Middle element(s) give median.


Time Complexity
addNum()      = O(1)
findMedian()  = O(n log n)
(Sorting every call)

Space Complexity: O(n)
*/

import java.util.*;

class MedianFinder {

    ArrayList<Integer> list;

    public MedianFinder() {
        list = new ArrayList<>();
    }

    // insert number
    public void addNum(int num) {
        list.add(num);
    }

    // find median
    public double findMedian() {
        Collections.sort(list);

        int size = list.size();

        // even elements
        if(size % 2 == 0){
            return (list.get(size/2) + list.get(size/2 - 1)) / 2.0;
        }

        // odd elements
        return list.get(size/2);
    }
}


/*
=====================================================
2. OPTIMAL (TWO HEAPS)
=====================================================

Core Idea

Maintain:

Max Heap = left half of numbers
Min Heap = right half of numbers


Heap Property
maxHeap:
contains smaller half

Top = largest among smaller half


minHeap:
contains larger half

Top = smallest among larger half


Balance Rule

Either:
maxHeap.size == minHeap.size

OR

maxHeap.size == minHeap.size + 1


Why?
Median always lies around the middle.


Time Complexity
addNum()
Heap insertion/removal

O(log n)

findMedian(): O(1)

Space Complexity: O(n)
*/

class MedianFinder {

    // left half
    PriorityQueue<Integer> maxHeap;

    // right half
    PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a,b) -> b - a);
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        // add to left half
        maxHeap.offer(num);

        // largest from left -> right
        minHeap.offer(maxHeap.poll());

        // maintain size rule
        if(minHeap.size() > maxHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        // even count
        if(maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }

        // odd count
        return maxHeap.peek();
    }
}