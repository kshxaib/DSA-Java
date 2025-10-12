import java.util.*;
import java.util.LinkedList;

public class FirstNonRepeatingLetter {
    public static void printFNRL(String str){
        int freq[] = new int[26];
        Queue<Character> queue = new LinkedList<>();

        for(int i=0; i<str.length(); i++){
            char currentChr = str.charAt(i);
            queue.add(currentChr);
            freq[currentChr - 'a']++;

            while(!queue.isEmpty() && freq[queue.peek() - 'a'] > 1){
                queue.remove();
            }

            if(queue.isEmpty()){
                System.out.print(-1 + " ");
            }else{
                System.out.print(queue.peek() + " ");
            }
        }
        
    }

    public static void main(String[] args) {
        String str = "aabccxb";
        printFNRL(str);
    }
}
