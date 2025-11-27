import java.util.TreeMap;

public class ImplementationOfTreeMap {
    public static void main(String[] args) {
        TreeMap<String, Integer> tm = new TreeMap<>();

        tm.put("India", 130);
        tm.put("China", 140);
        tm.put("US", 30);
        tm.put("Nepal", 25);

        System.out.println(tm);
    }
}
