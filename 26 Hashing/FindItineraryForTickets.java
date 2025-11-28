import java.util.HashMap;

public class FindItineraryForTickets {

    // This method finds the starting point of the journey.
    // The starting city is the one which never appears as a destination.
    public static String getStartPt(HashMap<String, String> tickets){
        HashMap<String, String> revMap = new HashMap<>();

        // Create a reverse map: destination -> source
        for(String key: tickets.keySet()){
            revMap.put(tickets.get(key), key);
        }

        // The start city will not appear as a destination in reverse map
        for(String key: tickets.keySet()){
            if(!revMap.containsKey(key)){
                return key; // starting point found
            }
        }

        return null; // if no start point exists (should not happen for valid input)
    }

    // This method prints the full travel route in order.
    public static void printRoutes(HashMap<String, String> tickets){
        String startingPt = getStartPt(tickets);

        // Print starting point
        System.out.print(startingPt);

        // Follow the chain using the ticket mapping
        for(int i = 0; i < tickets.size(); i++){
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

/*
Time Complexity:
1. Building reverse map: O(n)
2. Finding starting point: O(n)
3. Printing routes: O(n)
Overall time complexity: O(n)

Space Complexity:
1. Reverse map uses O(n) space
2. Ticket map already uses O(n)
Overall auxiliary space: O(n)
*/
