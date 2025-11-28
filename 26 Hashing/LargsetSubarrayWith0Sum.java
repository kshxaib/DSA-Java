import java.util.HashMap;

public class LargsetSubarrayWith0Sum {
    public static int findLength(int arr[]){
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = 0;
        int sum = 0;

        for(int i = 0; i < arr.length; i++){
            sum += arr[i];  // prefix sum

            // Same sum seen before → elements between those indexes sum to 0
            if(map.containsKey(sum)){
                int newLen = i - map.get(sum);
                if(newLen > len){
                    len = newLen;
                }
            } else {
                // Store first occurrence of this prefix sum
                map.put(sum, i);
            }
        }

        return len;
    }

    public static void main(String[] args) {
        int arr[] = {15, -2, 2, -8, 1, 7, 10};
        System.out.println(findLength(arr));
    }    
}

/*
Time Complexity:
O(n) – Each element is processed once, and HashMap operations are O(1) average.

Space Complexity:
O(n) – HashMap stores prefix sums up to n entries.
*/
