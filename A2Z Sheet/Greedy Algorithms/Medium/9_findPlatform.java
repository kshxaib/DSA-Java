import java.util.*;

class Solution {
    public int findPlatformBrute(int[] Arrival, int[] Departure) {
        int n = Arrival.length;

        int result = 1;

        for (int i = 0; i < n; i++) {
            int count = 1;  // Current train needs one platform

            for (int j = 0; j < n; j++) {
                if (i == j) continue;

                // Check if train i and train j overlap
                if (Arrival[j] <= Departure[i] && Departure[j] >= Arrival[i]) {
                    count++;
                }
            }

            result = Math.max(result, count);
        }

        return result;
    }

    public int findPlatform(int[] Arrival, int[] Departure) {
        int n = Arrival.length;
        
        Arrays.sort(Arrival);
        Arrays.sort(Departure);

        int platforms = 0;
        int result = 0;
        int i = 0, j = 0;

        while(i<n && j<n){
            // Arrival needs platform
            if(Arrival[i] <= Departure[j]){
                platforms++;
                i++;
            } 
            // Departure frees platform
            else {
                platforms--;
                j++;
            }

            // Maximum platforms needed
            result = Math.max(result, platforms);
        }

        return result;
    }
}