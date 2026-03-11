/*
        Kth MISSING POSITIVE NUMBER
              (BINARY SEARCH)

Problem:
Given a sorted array arr of unique positive integers,
find the kth missing positive number.

Missing numbers are those that should appear
in the sequence starting from 1.


Example 1:
arr = [3,5,7,10]
k = 6

Missing numbers:
1,2,4,6,8,9,11...

The 6th missing number = 9


Example 2:
arr = [1,4,6,8,9]
k = 3

Missing numbers:
2,3,5,7,10...

3rd missing = 5


Core Idea:
If the array had no missing numbers,
the value at index i should be: i + 1

Example:
index: 0 1 2 3
value: 1 2 3 4

But in a given array:
arr = [3,5,7,10]

index: 0 1 2 3

Expected values:
1,2,3,4

Actual values:
3,5,7,10


Missing numbers before index i: arr[i] - (i + 1)

Example:
i = 2
arr[2] = 7

missing = 7 - (2+1) = 4

Missing numbers:
1,2,4,6


Binary Search Idea:
We want the smallest index
where missing numbers ≥ k.


Decision Rule:
If missing < k
Search right.

If missing ≥ k
Search left.

After the loop:
start will point to the position
where kth missing number fits.

Final answer: start + k

Derviation of formula:
    arr[end] + more
    but missing = arr[end] - (end +1);
    int more = k - missing
    arr[end] + k - (arr[end] - end - 1);
    k + end + 1;
    but end = start + 1
    
Complexities:
Time Complexity  : O(log n)
Space Complexity : O(1)
*/

class Solution {
    public static int findKthPositive(int[] arr, int k) {
        int start = 0;
        int end = arr.length -1;
        
        while(start <= end){
            int mid = start + (end - start)/2;

            int missings = arr[mid] - (mid + 1);

            if(missings < k){
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return start + k;
    }
}