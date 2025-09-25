// Problem: Remove duplicate characters from a string using recursion

public class RemoveDuplicate {

    // Recursive function
    public static void RD(String str, int index, StringBuilder sb, boolean map[]){
        // Base case: if we reach the end of the string
        if(index == str.length()){
            System.out.println(sb);  // print the final string without duplicates
            return;
        }

        // Get the current character at given index
        char currentChar = str.charAt(index);

        // Convert character → index for map (0 for 'a', 1 for 'b', ..., 25 for 'z')
        int indexForMap = currentChar - 'a';

        // If character already exists in map (duplicate found)
        if(map[indexForMap] == true){
            // Skip this character and move to next index
            RD(str, index+1, sb, map);
        } 
        else {
            // If character is new → add it to StringBuilder
            sb.append(currentChar);

            // Mark character as seen
            map[indexForMap] = true;

            // Move to next character
            RD(str, index+1, sb, map);
        }
    }

    public static void main(String[] args) {
        String str = "apnacollege"; // Input string
        StringBuilder sb = new StringBuilder(); // To store final result
        boolean map[] = new boolean[26]; // Boolean map for a-z (initially false)
        int startIndex = 0;

        // Start recursion from index 0
        RD(str, startIndex, sb, map);
    }    
}

/*
📌 Example Dry Run: str = "apnacollege"
    Step 1: 'a' → not seen → add → sb = "a"
    Step 2: 'p' → not seen → add → sb = "ap"
    Step 3: 'n' → not seen → add → sb = "apn"
    Step 4: 'a' → already seen → skip
    Step 5: 'c' → not seen → add → sb = "apnc"
    Step 6: 'o' → not seen → add → sb = "apnco"
    Step 7: 'l' → not seen → add → sb = "apncol"
    Step 8: 'l' → already seen → skip
    Step 9: 'e' → not seen → add → sb = "apncole"
    Step 10: 'g' → not seen → add → sb = "apncoleg"
    Step 11: 'e' → already seen → skip

✅ Final Output → "apncoleg"

✅ Time Complexity: O(n) → we process each character once
✅ Space Complexity: O(n) → recursion stack + StringBuilder + map[26]
*/
