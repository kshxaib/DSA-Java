class Student {

    static String college = "ABC College";
    String name;

    Student(String name) {
        this.name = name;
    }

    void display() {
        System.out.println(name + " - " + college);
    }
}

public class Main {
    public static void main(String[] args) {

        Student s1 = new Student("Aman");
        Student s2 = new Student("Riya");

        s1.display();
        s2.display();
    }
}