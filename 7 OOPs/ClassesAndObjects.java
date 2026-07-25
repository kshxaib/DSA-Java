// Topic: Classes and Objects in Java
public class ClassesAndObjects {
    public static void main(String args[]){

        Pen p1 = new Pen();

        p1.setColor("blue");
        p1.tip = 5;

        // Printing the tip value
        System.out.print(p1.tip);
    }
}

// ---------------- Pen Class ----------------
class Pen {
    String color;
    int tip;

    void setColor(String newColor) {
        color = newColor;
    }

    void setTip(int newTip){
        tip = newTip;
    }
}

// ---------------- Student Class ----------------
class Student {
    // Properties (fields/attributes)
    String name;
    int age;
    float percentage; 

    // Method to calculate percentage
    void calPercentage(int phy, int chem, int math){
        // formula: average of marks in 3 subjects
        int percentage = (phy + chem + math) / 3;

        // print student's name and percentage
        System.out.print(name + "'s " + "percentage is: " + percentage);
    }
}

/*
📌 Quick Revision Notes:
1. Class → Blueprint/template that defines data (variables) + behavior (methods).
2. Object → Instance of a class (created using 'new').
3. Properties/Fields → Variables inside a class (e.g., color, tip, name, age).
4. Methods → Functions inside a class that define behavior (e.g., setColor, calPercentage).
5. We can create multiple objects from the same class with different data.
6. Setter Methods → Used to set values for object properties.
*/
