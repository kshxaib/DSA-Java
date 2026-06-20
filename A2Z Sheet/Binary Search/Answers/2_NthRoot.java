/*
        FIND Nth ROOT OF A NUMBER
        (BINARY SEARCH ON ANSWER)

Problem:
Given two integers N and M, find the integer X such that:
        X^N = M
If such an integer does not exist,
return -1.


Example 1:
N = 3
M = 27

Output: 3

Explanation:
3^3 = 27


Example 2:
N = 4
M = 69

Output: -1

Explanation:
No integer X exists such that:
        X^4 = 69


Core Idea:
The Nth root must lie between: 1 and M

We apply Binary Search on this range
to find the number whose Nth power
equals M.

Key Observation:
If: mid^N == M
We found the answer.

If: mid^N < M
mid is too small → search RIGHT.

If: mid^N > M
mid is too large → search LEFT.

Algorithm Steps:

1. Initialize:

        start = 1
        end = M

2. While start ≤ end:

        mid = (start + end) / 2

3. Compute:

        mid^N

4. If equal → return mid

5. If smaller → move right

6. If larger → move left

7. If loop ends → root does not exist.


Complexities:
Time Complexity  : O(N log M)
Reason:
Binary search runs log M times
and each time we compute mid^N
in O(N).

Space Complexity : O(1)

Properties:
- Binary search on answer space
- Works efficiently for large values
- Avoids brute force checking
*/

class Solution {

    public int NthRoot(int N, int M) {
        int start = 1;
        int end = M;

        while(start <= end){
            int mid = start + (end - start)/2;

            long power = (long) Math.pow(mid, N);

            if(power == M) return mid;

            if(power < M){
                start = mid +1;
            } else {
                end = mid -1;
            }
        }
        
        return -1;
    }
}

// Time: O(N log M)
// Space: O(1)


