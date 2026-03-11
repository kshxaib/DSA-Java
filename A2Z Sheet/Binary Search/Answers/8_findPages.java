/*
         BOOK ALLOCATION PROBLEM
        (BINARY SEARCH ON ANSWER)

Problem:
You are given an array nums where nums[i]
represents the number of pages in the ith book.

There are m students.

Rules:
1. Each student must get at least one book.
2. Each book can be assigned to only one student.
3. Books must be allocated in CONTIGUOUS order.
4. We want to minimize the maximum pages
   assigned to any student.

Return the minimum possible maximum pages.
If allocation is not possible → return -1.


Example 1:
nums = [12,34,67,90]
m = 2

Output: 113

Explanation:
Student1 → [12,34,67] = 113
Student2 → [90]

Maximum pages = 113 (minimum possible)


Example 2:
nums = [25,46,28,49,24]
m = 4

Output: 71

Explanation:
Student1 → [25,46]
Student2 → [28]
Student3 → [49]
Student4 → [24]

Maximum pages = 71


Core Idea:
We must minimize the maximum pages
assigned to a student.

Possible range of answers:
Minimum = max(nums)
Maximum = sum(nums)

Why?
Minimum must be at least the largest book.
Maximum occurs when one student reads all books.


Binary Search Strategy:
Search in the range: [max(nums), sum(nums)]


Decision Rule:
If students ≤ m
Allocation is possible.
Try smaller page limit.

If students > m
Limit too small.
Increase page limit.


Algorithm Steps:

1. If m > number of books → return -1.

2. Compute:

        maxPages
        totalPages

3. Binary search between them.

4. For each mid:

        calculate students needed.

5. If students ≤ m

        store answer
        search left.

6. Else

        search right.


Complexities:
Time Complexity  : O(n log(sum))
Binary search → log(sum)
Each check → O(n)

Space Complexity : O(1)
*/

class Solution {
    public int findPages(int[] nums, int m) {
        int ans = -1;
        if(m > nums.length) return ans;

        int max = Integer.MIN_VALUE;
        int sum = 0;

        for(int i = 0; i < nums.length; i++){
            max = Math.max(max, nums[i]);
            sum += nums[i];
        }

        int start = max;
        int end = sum;

        while(start <= end){
            int mid = start + (end - start) / 2;
            int students = countStudents(nums, mid);

            if(students <= m){
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }

    public int countStudents(int nums[], int pages){
        int students = 1;
        int currPages = 0;

        for(int i = 0; i < nums.length; i++){
            if(currPages + nums[i] <= pages){
                currPages += nums[i];
            } else {
                students++;
                currPages = nums[i];
            }
        }

        return students;
    }
}