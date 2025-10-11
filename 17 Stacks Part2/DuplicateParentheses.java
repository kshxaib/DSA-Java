import java.util.*;

public class DuplicateParentheses{
    public static boolean isDuplicate(String str){
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<str.length(); i++){
            char currentChr = str.charAt(i);

            if(currentChr != ')'){
                stack.push(currentChr);
            }else{
                int countElement = 0;
                char topChr = stack.peek();
                while(topChr != '('){
                    stack.pop();
                    countElement++;
                    topChr = stack.peek();
                }
                if(countElement == 0){
                    return true;
                }
                stack.pop();
            }
        }

        return false;
    }

    public static void main(String args[]){
        String str = "(a)";
        System.out.println(isDuplicate(str));
    }
}