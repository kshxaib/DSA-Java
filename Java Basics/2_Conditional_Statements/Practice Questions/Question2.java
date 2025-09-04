// Finish the following code so that it prints You have a fever if your temperature is above 100 and otherwise prints You don't have a fever.

public class Question2 {
    public static void main(String args[]){
        double temp = 103.5;
        
        String result = (temp > 100)? "Having fewer" : "You don't have a fewer";
        System.out.print(result);
    }
}
