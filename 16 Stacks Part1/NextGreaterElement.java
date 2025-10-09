import java.util.*;

public class NextGreaterElement {
    public static void findNextGreater(int arr[], int nextGreater[]){
        Stack<Integer> stack = new Stack<>();
        nextGreater[arr.length -1] = -1;
        stack.push(arr.length -1);

        for(int i=arr.length -2; i>=0; i--){
            while (!stack.isEmpty() && arr[i] >= arr[stack.peek()]) {
                stack.pop();
            }
            if(stack.isEmpty()){
                nextGreater[i] = -1;
            } else {
                nextGreater[i] = arr[stack.peek()];
            }
            stack.push(i);
        }
    }

    public static void main(String[] args) {
        int arr[] = {6,8,0,1,3};
        int nextGreater[] = new int[arr.length];  
        findNextGreater(arr, nextGreater);  

        for(int i=0; i<nextGreater.length; i++){
            System.out.println(nextGreater[i] + " ");
        }
    }
}
