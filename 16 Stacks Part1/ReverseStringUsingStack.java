import java.util.*;

public class ReverseStringUsingStack {
    public static String reverseString(String str){
        Stack<Character> stack = new Stack<>();
        int index = 0;
        while (index < str.length()) {
            stack.push(str.charAt(index));
            index++;
        }

        StringBuilder sb = new StringBuilder("");

        while (!stack.isEmpty()) {
            char top = stack.peek();
            sb.append(top);
            stack.pop();
        }

        str = sb.toString();
        return str;
    }

    public static void main(String[] args) {
        String str = "abc";
        System.out.println(reverseString(str));
    }
}
