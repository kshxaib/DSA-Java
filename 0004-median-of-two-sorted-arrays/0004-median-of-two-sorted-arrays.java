class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int total = n + m;

        int i = 0, j = 0;
        int counter = 0;
        int prev = 0, curr = 0;

        while (counter <= total / 2) {
            prev = curr;

            if (i >= n) {
                curr = nums2[j++];
            } else if (j >= m) {
                curr = nums1[i++];
            } else if (nums1[i] <= nums2[j]) {
                curr = nums1[i++];
            } else {
                curr = nums2[j++];
            }

            counter++;
        }

        if (total % 2 == 1) {
            return curr;
        }

        return ((double) prev + curr) / 2.0;
    }
}
