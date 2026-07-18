import java.util.*;

class Solution {
    public int LongestBitonicSequence(int[] arr) {
        int n = arr.length;

        int[] lis = new int[n];
        int[] lds = new int[n];

        Arrays.fill(lis, 1);
        Arrays.fill(lds, 1);

        // LIS ending at every index
        for (int index = 0; index < n; index++) {
            for (int prevIndex = 0; prevIndex < index; prevIndex++) {

                if (arr[index] > arr[prevIndex] && lis[prevIndex] + 1 > lis[index]) {
                    lis[index] = lis[prevIndex] + 1;
                }
            }
        }

        // LDS starting from every index
        for (int index = n - 1; index >= 0; index--) {
            for (int nextIndex = n - 1; nextIndex > index; nextIndex--) {

                if (arr[index] > arr[nextIndex] && lds[nextIndex] + 1 > lds[index]) {
                    lds[index] = lds[nextIndex] + 1;
                }
            }
        }

        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            if (lis[i] > 1 && lds[i] > 1) {
                maxLength = Math.max(maxLength, lis[i] + lds[i] - 1);
            }
        }

        return maxLength;
    }
}