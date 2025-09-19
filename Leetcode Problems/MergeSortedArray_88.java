public class MergeSortedArray_88 {
 public void merge1(int[] nums1, int m, int[] nums2, int n) {
    int arr[] = new int[m+n];
    int left=0, right=0;
    int index=0;
    while(left < n && right < m){
        if(nums1[left] <= nums2[right]){
            arr[index] = nums1[left];
            left++;
            index++;
        } else {
             arr[index] = nums1[right];
            right++;
            index++;
        }
    }
 }   
}