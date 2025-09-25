// Problem: Binary String Problem
/*
📌 Problem Statement:
Generate all binary strings of length n such that there are
no consecutive 1s.

👉 Choices for each position:
   - Always place '0'
   - Place '1' only if the last placed digit was '0'
     (to avoid consecutive 1s)

So recurrence relation:
    f(n, last=0) = f(n-1, 0) + f(n-1, 1)
    f(n, last=1) = f(n-1, 0)
*/

public class BinaryStringProblem {
    
    // Recursive function
    // n → remaining length
    // lastPlace → what was placed at the previous position (0 or 1)
    // str → current string being built
    public static void printBinaryString(int n, int lastPlace, String str) {
        // Base case: if length becomes 0 → print the built string
        if(n == 0){
            System.out.println(str);
            return;
        }

        // Choice 1: Always place '0'
        printBinaryString(n - 1, 0, str + "0");

        // Choice 2: Place '1' only if lastPlace was 0
        if (lastPlace == 0) {
            printBinaryString(n - 1, 1, str + "1");
        }
    }

    public static void main(String[] args) {
        String str = "";
        printBinaryString(3, 0, str);  
        // Expected output:
        // 000, 001, 010, 100, 101
    }
}

/*
📌 Dry Run (n=3):
Start: n=3, last=0, str=""

→ Place 0 → n=2, str="0"
    → Place 0 → n=1, str="00"
        → Place 0 → "000"
        → Place 1 → "001"
    → Place 1 → n=1, str="01"
        → Place 0 → "010"
        (can't place "11" since last=1)

→ Place 1 → n=2, str="1"
    → Place 0 → n=1, str="10"
        → Place 0 → "100"
        → Place 1 → "101"

✅ Final Answer for n=3:
000, 001, 010, 100, 101

✅ Time Complexity: O(2^n) → each position has 2 choices (with restriction)
✅ Space Complexity: O(n) → recursion stack depth = n

⚡ Optimization:
If only the *count* of valid strings is needed, we can solve it using
Dynamic Programming (like Fibonacci).
*/
