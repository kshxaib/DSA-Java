import java.util.*;

public class ImplementationOfLinkedHashMap {
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();

        lhm.put("India", 130);
        lhm.put("China", 140);
        lhm.put("US", 30);
        lhm.put("Nepal", 25);

        System.out.println(lhm);    
    }
}
