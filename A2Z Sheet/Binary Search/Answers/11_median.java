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
*/

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int length1 = nums1.length;
        int length2 = nums2.length;
        int totalLength = length1 + length2;

        // Always binary search on the smaller array
        if (length1 > length2) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int low = 0;
        int high = length1;

        int leftPartitionSize = (totalLength + 1) / 2;

        while (low <= high) {

            int partition1 = low + (high - low) / 2;
            int partition2 = leftPartitionSize - partition1;

            int leftMax1 = Integer.MIN_VALUE;
            int leftMax2 = Integer.MIN_VALUE;

            int rightMin1 = Integer.MAX_VALUE;
            int rightMin2 = Integer.MAX_VALUE;

            if (partition1 > 0) {
                leftMax1 = nums1[partition1 - 1];
            }

            if (partition2 > 0) {
                leftMax2 = nums2[partition2 - 1];
            }

            if (partition1 < length1) {
                rightMin1 = nums1[partition1];
            }

            if (partition2 < length2) {
                rightMin2 = nums2[partition2];
            }

            // Correct partition found
            if (leftMax1 <= rightMin2 && leftMax2 <= rightMin1) {

                if (totalLength % 2 == 1) {
                    return Math.max(leftMax1, leftMax2);
                }

                return (Math.max(leftMax1, leftMax2)
                        + Math.min(rightMin1, rightMin2)) / 2.0;
            }

            // Move partition1 to the left
            else if (leftMax1 > rightMin2) {
                high = partition1 - 1;
            }

            // Move partition1 to the right
            else {
                low = partition1 + 1;
            }
        }

        return 0.0;
    }
}


class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int merged[] = new int[n+m];

        int i =0, j =0, k=0;
        while(i<n && j<m){
            if(nums1[i] < nums2[j]){
                merged[k] = nums1[i];
                i++;
            } else {
                merged[k] = nums2[j];
                j++;
            }
            k++;
        }

        while(i<n){
            merged[k] = nums1[i];
            i++;
            k++;
        }

        while(j<m){
            merged[k] = nums2[j];
            j++;
            k++;
        }

        int len = merged.length;
        if(len % 2 == 1) return (double)merged[len/2];
        return ((double)merged[len/2 - 1] + merged[len/2]) / 2.0;
    }
}


class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int len = n + m;

        int index1 = (len / 2) - 1;
        int index2 = len / 2;

        int element1 = -1;
        int element2 = -1;

        int i = 0, j = 0, count = 0;

        while (i < n && j < m) {
            int curr;

            if (nums1[i] <= nums2[j]) {
                curr = nums1[i++];
            } else {
                curr = nums2[j++];
            }

            if (count == index1) element1 = curr;
            if (count == index2) element2 = curr;

            count++;
        }

        while (i < n) {
            int curr = nums1[i++];

            if (count == index1) element1 = curr;
            if (count == index2) element2 = curr;

            count++;
        }

        while (j < m) {
            int curr = nums2[j++];

            if (count == index1) element1 = curr;
            if (count == index2) element2 = curr;

            count++;
        }

        if (len % 2 == 1) {
            return element2;
        }

        return (element1 + element2) / 2.0;
    }
}