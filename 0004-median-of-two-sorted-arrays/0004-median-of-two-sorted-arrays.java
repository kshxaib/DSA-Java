
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int[] merged = new int[n + m];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < n && j < m) {
            if (nums1[i] <= nums2[j]) {
                merged[k++] = nums1[i++];
            } else {
                merged[k++] = nums2[j++];
            }
        }

        while (i < n) {
            merged[k++] = nums1[i++];
        }

        while (j < m) {
            merged[k++] = nums2[j++];
        }

        int total = n + m;
        int mid = total / 2;

        if (total % 2 == 1) {
            return merged[mid];
        }

        return (double)(merged[mid - 1] +  merged[mid]) / 2.0;
    }
}
