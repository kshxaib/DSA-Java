import java.util.HashMap;

public class FindItineraryForTickets {
    public static String getStartPt(HashMap<String, String> tickets){
        HashMap<String, String> revMap = new HashMap<>();

        for(String key: tickets.keySet()){
            revMap.put(tickets.get(key), key);
        }

        for(String key: tickets.keySet()){
            if(!revMap.containsKey(key)){
                return key;     // starting point
            }
        }

        return null;
    }

    public static void printRoutes(HashMap<String, String> tickets){
        String startingPt = getStartPt(tickets);

        System.out.print(startingPt);
        for(String key: tickets.keySet()){
            String next = tickets.get(startingPt);
            System.out.print(" -> " + next);
            startingPt = next;
        }
    }

    public static void main(String[] args) {
        HashMap<String, String> tickets = new HashMap<>();
        tickets.put("Chennai", "Bangaluru");
        tickets.put("Mumbai", "Delhi");
        tickets.put("Goa", "Chennai");
        tickets.put("Delhi", "Goa");

        printRoutes(tickets);
    }
}
