import java.util.*;

// Problem: Reverse a String using Stack
/*
📌 Problem Statement:
Given a string `str`, reverse it using a **stack** data structure.

Example:
Input  → "abc"
Output → "cba"

👉 Concept:
- Push all characters of the string into the stack.
- Since stack follows **LIFO (Last In, First Out)**,
  popping elements will give the characters in reverse order.

✅ Approach:
1. Create a stack of characters.
2. Traverse the string and push each character.
3. Pop characters one by one and append them to a new StringBuilder.
4. Convert StringBuilder to string and return.
*/

public class ReverseStringUsingStack {

    // Function to reverse string using stack
    public static String reverseString(String str) {
        Stack<Character> stack = new Stack<>();

        // 🔹 Step 1: Push all characters of string into the stack
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }

        // 🔹 Step 2: Pop characters and build reversed string
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            char top = stack.pop();   // pop top character
            sb.append(top);           // append to result
        }

        // 🔹 Step 3: Return the reversed string
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "abc";
        System.out.println(reverseString(str)); // Output: cba
    }
}

/*
📌 Dry Run:
Input: "abc"

Step 1: Push characters
Stack (top → bottom): c, b, a

Step 2: Pop and append
→ pop 'c' → sb = "c"
→ pop 'b' → sb = "cb"
→ pop 'a' → sb = "cba"

Output: "cba"

---

📊 Time Complexity:
O(n) — Each character is pushed and popped once.

📊 Space Complexity:
O(n) — Stack stores all characters temporarily.

✅ Concept Used:
Stack (LIFO) property for reversing order.
*/
