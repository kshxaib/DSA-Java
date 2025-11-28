import java.util.HashMap;

public class SubarraySumEqualsToK {
    public static int countSubarray(int arr[], int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        // map stores: (prefixSum, how many times it appeared)

        map.put(0, 1);  
        // prefix sum 0 appears once (helps when subarray itself equals k)

        int sum = 0;
        int ans = 0;

        for(int j = 0; j < arr.length; j++){
            sum += arr[j];  
            // current prefix sum

            // If (sum - k) exists, it means subarray ending at j has sum = k
            if(map.containsKey(sum - k)){
                ans += map.get(sum - k);
            }

            // store/update the prefix sum count in map
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {10, 2, -2, -20, 10};
        int k = -10;

        System.out.println(countSubarray(arr, k));
    }
}

/*
Time Complexity:
O(n)
— A single loop through the array.
— HashMap operations are O(1) on average.

Space Complexity:
O(n)
— HashMap can store up to n different prefix sums.
*/
