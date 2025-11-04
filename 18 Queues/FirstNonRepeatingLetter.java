// Problem: Find the First Non-Repeating Letter in a Stream

import java.util.*;
import java.util.LinkedList;

public class FirstNonRepeatingLetter {

    public static void printFNRL(String str) {
        int freq[] = new int[26];              // Frequency array for 'a' to 'z'
        Queue<Character> queue = new LinkedList<>(); // Queue to store characters in order

        // Process each character in the input string
        for (int i = 0; i < str.length(); i++) {
            char currentChr = str.charAt(i);   // Current character
            queue.add(currentChr);             // Add it to the queue
            freq[currentChr - 'a']++;          // Increment its frequency count

            // Remove characters from front if they have frequency > 1
            while (!queue.isEmpty() && freq[queue.peek() - 'a'] > 1) {
                queue.remove();
            }

            // If queue is empty → no non-repeating character yet
            if (queue.isEmpty()) {
                System.out.print(-1 + " ");
            } else {
                // Front of the queue → first non-repeating character
                System.out.print(queue.peek() + " ");
            }
        }
    }

    public static void main(String[] args) {
        String str = "aabccxb"; 
        printFNRL(str);         
    }
}

/*
Dry Run:
Input: aabccxb
Output: a -1 b b b b x

Step-by-Step:
1. 'a' → queue = [a] → freq[a]=1 → Output: a
2. 'a' → freq[a]=2 → remove 'a' → queue empty → Output: -1
3. 'b' → queue = [b] → freq[b]=1 → Output: b
4. 'c' → queue = [b, c] → freq[c]=1 → Output: b
5. 'c' → freq[c]=2 → remove 'c' → queue = [b] → Output: b
6. 'x' → queue = [b, x] → freq[x]=1 → Output: b
7. 'b' → freq[b]=2 → remove 'b' → queue = [x] → Output: x

Time Complexity: O(n)
- Each character is added and removed from the queue at most once.

Space Complexity: O(n)
- Queue and frequency array storage.
*/
