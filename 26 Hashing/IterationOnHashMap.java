import java.util.*;

public class IterationOnHashMap {
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();   

        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("US", 50);

        Set<String> keys = hm.keySet();     // O(1)
        
        for (String key : keys) {       // O(n)
            System.out.println(hm.get(key));
        }
    }
}
