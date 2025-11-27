import java.util.*;

public class IterationOnHashSet {
    public static void main(String[] args) {
        HashSet<String> cities = new HashSet<>();

        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Bangalore");

        // using iterator
        Iterator it = cities.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        } 
        
        // using for-each loop
        for(String city : cities){
            System.out.println(city);
        }
    }
}
