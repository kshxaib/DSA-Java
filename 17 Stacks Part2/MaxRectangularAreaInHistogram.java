import java.util.*;

public class MaxRectangularAreaInHistogram {
    public static void maxArea(int heights[]){
        int maxArea = 0;
        int nextSmallerRight[] = new int[heights.length];
        int nextSmallerLeft[] = new int[heights.length];
        
        //Next smaller right
        Stack<Integer> stack = new Stack<>();
        for(int i=heights.length -1; i>=0; i--){
            while(!stack.isEmpty() && heights[i] <= heights[stack.peek()]){
                stack.pop();
            }
            if(stack.isEmpty()){
                nextSmallerRight[i] = heights.length;
            }else{
                nextSmallerRight[i] = stack.peek();
            }
            stack.push(i);
        }

        //Next smaller left
        stack = new Stack<>();
        for(int i=0; i<heights.length; i++){
            while(!stack.isEmpty() && heights[i] <= heights[stack.peek()]){
                stack.pop();
            }
            if(stack.isEmpty()){
                nextSmallerLeft[i] = -1;
            }else{
                nextSmallerLeft[i] = stack.peek();
            }
            stack.push(i);
        }

        for(int i=0; i<heights.length; i++){
            int width = nextSmallerRight[i] - nextSmallerLeft[i] -1;
            int height = heights[i];
            int area = height * width;

            if(maxArea < area){
                maxArea = area;
            }
        }

        System.out.println("Max area in histogram is: " + maxArea);
    }

    public static void main(String[] args) {
        int heights[] = {2,1,5,6,2,3};
        maxArea(heights);
    }
}
