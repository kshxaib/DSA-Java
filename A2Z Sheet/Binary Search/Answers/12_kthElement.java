/*
        Kth ELEMENT OF TWO SORTED ARRAYS
          (BINARY SEARCH ON PARTITION)

Problem:
Given two sorted arrays a and b,
find the kth element of the combined
sorted array without merging them.


Example 1
a = [2,3,6,7,9]
b = [1,4,8,10]
k = 5

Merged array: [1,2,3,4,6,7,8,9,10]
5th element = 6


Example 2
a = [100,112,256,349,770]
b = [72,86,113,119,265,445,892]
k = 7

Merged: [72,86,100,112,113,119,256,265,349,445,770,892]
7th element = 256


Core Idea:
Instead of merging arrays (O(n)),
we find a partition such that:

Left side contains exactly k elements.


Partition Concept
We divide both arrays into:

a : [ left | right ]
b : [ left | right ]

Total elements on the left side: mid1 + mid2 = k


Partition Elements
l1 = last element on left of a
l2 = last element on left of b

r1 = first element on right of a
r2 = first element on right of b


Correct Partition Condition
        l1 ≤ r2
        l2 ≤ r1

When this happens,
the kth element is: max(l1, l2)


Binary Search Strategy

We perform binary search
on the smaller array.

Search Range
mid1 must satisfy: 0 ≤ mid1 ≤ n1

Also: mid2 = k - mid1

So valid range becomes:
start = max(0, k - n2)
end   = min(k, n1)


Complexities
Time Complexity  : O(log(min(n1,n2)))
Space Complexity : O(1)

Key Interview Points
• Do NOT merge arrays
• Binary search on smaller array
• Partition must satisfy:
        l1 ≤ r2
        l2 ≤ r1

Answer: max(l1,l2)


Relation With Median Problem
Median of two arrays is just
a special case of this problem.

For median: k = (n1 + n2 + 1) / 2
*/

class Solution {
    public int kthElement(int[] a, int[] b, int k) {

        int n1 = a.length;
        int n2 = b.length;

        if(n1 > n2) return kthElement(b, a, k);

        int start = Math.max(0, k - n2);
        int end = Math.min(k, n1);

        while(start <= end){

            int mid1 = start + (end - start)/2;
            int mid2 = k - mid1;

            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;

            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;

            if(mid1 < n1) r1 = a[mid1];
            if(mid2 < n2) r2 = b[mid2];

            if(mid1 - 1 >= 0) l1 = a[mid1 - 1];
            if(mid2 - 1 >= 0) l2 = b[mid2 - 1];

            if(l1 <= r2 && l2 <= r1){
                return Math.max(l1, l2);
            }
            else if(l1 > r2){
                end = mid1 - 1;
            }
            else{
                start = mid1 + 1;
            }
        }

        return -1;
    }
}