import java.util.*;

public class HashMapOperations{
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();

        // Insert- O(1)
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("US", 50);

        System.out.println(hm);

        // Get- O(1)
        hm.get("China");

        // ContainsKey- O(1)
        hm.containsKey("China");

        // Remove- O(1)
        hm.remove("China");
    }
}