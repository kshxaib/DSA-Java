/*
        CONVERT MIN HEAP TO MAX HEAP

Definition:
Given array nums[]
representing a Min Heap,

Convert it into Max Heap
in-place and return array.


Heap Rules

Min Heap:
parent <= children

Max Heap:
parent >= children


Example

Input:
nums = [1,2,3,4,5,6]

Min Heap:

        1
      /   \
     2     3
    / \   /
   4  5  6


Output:
[6,5,3,4,2,1]   (one valid answer)

Max Heap:

        6
      /   \
     5     3
    / \   /
   4  2  1


Core Idea

Use Build Max Heap.

Start from last parent node
and apply heapify downward.


Why Start from Last Parent?

Leaf nodes already satisfy heap.
Only internal nodes need fixing.
Last parent index:
(n / 2) - 1


Why Bottom-Up Works

Children are fixed first.

Then parent compares against
already-correct subheaps.



Time Complexity: O(n)
(Build heap)

Space Complexity: O(1)
In-place conversion
*/

class Solution {

    public int[] minToMaxHeap(int[] nums) {
        int n = nums.length;

        // start from last parent
        for(int i = n / 2 - 1; i >= 0; i--){
            heapify(nums, n, i);
        }

        return nums;
    }

    // max heapify downward
    public void heapify(int nums[], int n, int i){
        while(true){
            int largest = i;
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            if(left < n && nums[left] > nums[largest]){
                largest = left;
            }

            if(right < n && nums[right] > nums[largest]){
                largest = right;
            }

            if(largest == i){
                break;
            }

            swap(nums, i, largest);
            i = largest;
        }
    }

    public void swap(int nums[], int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}