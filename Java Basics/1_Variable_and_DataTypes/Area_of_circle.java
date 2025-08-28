import java.util.*;

public class Area_of_circle {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        float radius = sc.nextFloat();
        float area = 3.14f * radius * radius;
        System.out.printf("Area of circle is: %f", area);
    }    
}
