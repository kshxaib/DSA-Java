/*
            FIND PEAK ELEMENT
        (BINARY SEARCH ON SLOPES)

Problem:
Given an array arr, find an index of a peak element.

A peak element is an element that is strictly
greater than its neighbors.

Condition:
        arr[i-1] < arr[i] > arr[i+1]

If multiple peaks exist, return the index of
any one of them.


Example 1:
arr = [1,2,3,4,5,6,7,8,5,1]

Output: 7

Explanation:
8 is greater than both neighbors.


Example 2:
arr = [1,2,1,3,5,6,4]

Output: 1 or 5

Explanation:
2 and 6 are both peaks.


Core Idea:
If we observe the array like a mountain:
1 2 3 4 5 6 7 8 5 1
            ↑ peak

Binary search works because:

If we move in the direction of a
**larger neighbor**, we are guaranteed
to reach a peak.


Key Observation:
Compare arr[mid] and arr[mid+1].

Case 1: arr[mid] < arr[mid+1]
Slope is increasing.
Peak must lie on the RIGHT side.


Case 2: arr[mid] > arr[mid+1]
Slope is decreasing.
Peak must lie on the LEFT side
(or at mid).


Why this works:
Every increasing slope eventually
turns downward or reaches boundary.

That turning point is a peak.


Algorithm Steps:
1. Handle edge peaks:

        if first element > second → peak

        if last element > second last → peak

2. Apply binary search between
   indices 1 and n-2.

3. If:

        arr[mid-1] < arr[mid] > arr[mid+1]

        return mid.

4. If increasing slope

        move right.

5. Else

        move left.


Complexities:
Time Complexity  : O(log n)
Space Complexity : O(1)

Properties:
- Uses binary search on slopes
- Does not require fully sorted array
- Guaranteed to find a peak

Key Interview Points:
Compare:

        arr[mid] and arr[mid+1]

If:

        arr[mid] < arr[mid+1]

Move right.

Else

Move left.
*/

class Solution {
    public int findPeakElement(int[] arr) {
        int n = arr.length;

        if(n == 1) return 0;
        if(arr[0] > arr[1]) return 0;
        if(arr[n-1] > arr[n-2]) return n -1;

        int start = 1;
        int end = n - 2;

        while(start <= end){
            int mid = start + (end - start)/2;

            if(arr[mid -1] < arr[mid] && arr[mid] > arr[mid +1])
                return mid;

            if(arr[mid] < arr[mid +1]){
                start = mid +1;
            } else {
                end = mid -1;
            }
        }

        return -1;
    }
}

// Time: O(log n)
// Space: O(1)