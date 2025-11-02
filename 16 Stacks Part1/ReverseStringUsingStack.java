import java.util.*;

public class ReverseStringUsingStack {

    public static String reverseString(String str) {
        Stack<Character> stack = new Stack<>();

        // Step 1: Push all characters of string into the stack
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }

        // Step 2: Pop characters and build reversed string
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            char top = stack.pop();   // pop top character
            sb.append(top);           // append to result
        }

        // Step 3: Return the reversed string
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "abc";
        System.out.println(reverseString(str)); 
    }
}

/*
Time Complexity:
O(n) — Each character is pushed and popped once.

Space Complexity:
O(n) — Stack stores all characters temporarily.
*/
