/*
        SUM OF SUBARRAY MINIMUMS

Definition:
For every possible subarray,
find its minimum element.

Return sum of all those minimums.


Example

Input:
arr = [3,1,2,4]

Subarrays:

[3]     min = 3
[3,1]   min = 1
[3,1,2] min = 1
[3,1,2,4] min = 1
[1]     min = 1
[1,2]   min = 1
[1,2,4] min = 1
[2]     min = 2
[2,4]   min = 2
[4]     min = 4

Total = 17

Output:
17


Core Idea (Contribution Technique)

Instead of checking all subarrays O(n²),

For each element arr[i],
count how many subarrays use it as MINIMUM.

Then:

Contribution =
arr[i] * frequency


Why This Works

Every subarray has exactly one minimum contributor.


Need Two Things

1. Previous Smaller or Equal Element (PSEE)
2. Next Smaller Element (NSE)

These define range where arr[i] stays minimum.


Formula

left  = i - PSEE[i]
right = NSE[i] - i

frequency = left * right

Contribution:

arr[i] * left * right


Time Complexity: O(n)
Each index pushed/popped once

Space Complexity: O(n)
*/

import java.util.*;

class Solution {
    public int sumSubarrayMinsBrute(int[] arr) {
        int sum = 0;

        for(int i=0; i<arr.length; i++){
            int min = arr[i];

            for(int j=i; j<arr.length; j++){
                min = Math.min(min, arr[j]);

                sum += min;
            }
        }

        return sum;
    }

    public int sumSubarrayMins(int[] arr) {
        int mod = 1000000007;
        int n = arr.length;

        long sum = 0;

        int[] nse = findNSE(arr);   // nse[i] = index of next smaller element
        int[] psee = findPSEE(arr); // psee[i] = index of previous smaller or equal element

        for (int i = 0; i < n; i++) {
            
            long left = i - psee[i];    // how many choices to pick start index
            long right = nse[i] - i;    // how many choices to pick end index

            long freq = left * right;   // total subarrays where arr[i] is minimum
            
            long value = (freq * arr[i]) % mod; // contribution of current element
            sum = (sum + value) % mod;
        }

        return (int) sum;
    }

    // Next Smaller Element index
    // if none exists -> n
    private int[] findNSE(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();

        // traverse right to left
        for (int i = n - 1; i >= 0; i--) {

            // remove greater or equal elements
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }

            ans[i] = stack.isEmpty() ? n : stack.peek();

            stack.push(i);
        }

        return ans;
    }

    // Previous Smaller or Equal Element index
    // if none exists -> -1
    private int[] findPSEE(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();

        // traverse left to right
        for (int i = 0; i < n; i++) {

            // remove strictly greater elements
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }

            ans[i] = stack.isEmpty() ? -1 : stack.peek();

            stack.push(i);
        }

        return ans;
    }
}