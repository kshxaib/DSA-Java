// Problem: Convert a number into words using recursion
/*
📌 Problem Statement:
Given a number, print its digits in words.
Example: 1947 → "one nine four seven"

👉 Approach:
- Break number into digits using modulo (% 10).
- Process digits in correct order:
   - First recursively call function with remaining number (number/10).
   - Then print the last digit as word.
*/

public class Question2 {
    // Array of words for digits 0-9
    static String words[] = {"zero", "one", "two", "three", "four", 
                             "five", "six", "seven", "eight", "nine"};

    // Recursive function
    public static void printWords(int number){
        // Base case: when number becomes 0 → stop
        if(number == 0){
            return;
        }

        // Extract last digit
        int lastDigit = number % 10;

        // Reduce number (remove last digit)
        number = number / 10;

        // Recursive call for remaining digits
        printWords(number);

        // Print last digit after recursive call (to maintain left-to-right order)
        System.out.print(words[lastDigit] + " ");
    }

    public static void main(String[] args) {
        int number = 1947;
        printWords(number);
        // Expected Output → one nine four seven 
    }    
}

/*
📌 Dry Run (number = 1947):

Step 1: lastDigit = 7 → recursive call with 194
Step 2: lastDigit = 4 → recursive call with 19
Step 3: lastDigit = 9 → recursive call with 1
Step 4: lastDigit = 1 → recursive call with 0
        → base case hit, return

Now printing in reverse stack order:
    words[1] → "one"
    words[9] → "nine"
    words[4] → "four"
    words[7] → "seven"

✅ Output → "one nine four seven"

✅ Time Complexity: O(d) → d = number of digits
✅ Space Complexity: O(d) → recursion stack depth
*/
