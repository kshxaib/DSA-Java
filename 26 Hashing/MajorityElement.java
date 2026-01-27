import java.util.Set;
import java.util.HashMap;

public class MajorityElement {
    public static void findMajorityElement(int nums[]) {

        // Time: O(n), Space: O(n)
        HashMap<Integer, Integer> hm = new HashMap<>();

        // Count frequencies - O(n)
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if (hm.containsKey(num)) {
                int freq = hm.get(num);
                hm.put(num, freq + 1);
            } else {
                hm.put(num, 1);
            }
        }

        // Check which element appears more than n/3 times - O(n)
        for (Integer key : hm.keySet()) {
            if (hm.get(key) > nums.length / 3) {
                System.out.println(key);
            }
        }    
    }

    public static void main(String[] args) {
        int nums[] = { 1, 3, 2, 5, 1, 3, 1, 5, 1 };
        findMajorityElement(nums);
    }
}

/*
Time Complexity: O(n)
 - Counting frequencies in array: O(n)
 - Iterating over HashMap keys: O(n)
Total: O(n)

Space Complexity: O(n)
 - HashMap stores frequency of elements.
*/
