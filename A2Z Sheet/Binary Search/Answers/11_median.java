/*
         MEDIAN OF TWO SORTED ARRAYS
        (BINARY SEARCH ON PARTITION)

Problem:
Given two sorted arrays arr1 and arr2,
find the median of the combined array
without merging them.


Median Definition:
If total length is odd: middle element

If total length is even: average of two middle elements


Example 1
arr1 = [2,4,6]
arr2 = [1,3,5]

Merged: [1,2,3,4,5,6]

Median = (3 + 4) / 2 = 3.5


Example 2
arr1 = [2,4,6]
arr2 = [1,3]

Merged: [1,2,3,4,6]

Median = 3


Core Idea:
Instead of merging arrays,
we partition both arrays such that:

Left half size = Right half size
(or left half has one extra element if odd)


Partition Concept
Suppose we cut arrays like this:

arr1:   [ left | right ]
arr2:   [ left | right ]

Total left elements = (n1 + n2 + 1) / 2


Partition Condition
Correct partition occurs when:
        l1 ≤ r2
        l2 ≤ r1

Where:
l1 = last element on left of arr1
l2 = last element on left of arr2
r1 = first element on right of arr1
r2 = first element on right of arr2


Median Calculation
If total length is odd: median = max(l1, l2)

If even: median = ( max(l1,l2) + min(r1,r2) ) / 2


Binary Search Strategy
We binary search the partition index
in the smaller array.

Why?
To keep time complexity minimal.


Complexities
Time Complexity  : O(log(min(n1,n2)))
Space Complexity : O(1)
*/

class Solution {
    public double median(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;

        if(n1 > n2) return median(arr2, arr1);

        int start = 0;
        int end = n1;

        int left = (n1 + n2 + 1) / 2;
        int n = n1 + n2;

        while(start <= end){
            int mid1 = start + (end - start)/2;
            int mid2 = left - mid1;

            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;

            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;

            if(mid1 < n1) r1 = arr1[mid1];
            if(mid2 < n2) r2 = arr2[mid2];

            if(mid1 - 1 >= 0) l1 = arr1[mid1 - 1];
            if(mid2 - 1 >= 0) l2 = arr2[mid2 - 1];

            if(l1 <= r2 && l2 <= r1){
                if(n % 2 == 1)
                    return Math.max(l1, l2);

                return (double)(Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
            }
            else if(l1 > r2){
                end = mid1 - 1;
            }
            else{
                start = mid1 + 1;
            }
        }

        return 0.0;
    }
}