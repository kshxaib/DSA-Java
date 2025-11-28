import java.util.*;

public class LinkedHashSetExample {
    public static void main(String[] args) {
        LinkedHashSet<String> cities = new LinkedHashSet<>();

        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Bangalore");

        System.out.println(cities);
    }
}
