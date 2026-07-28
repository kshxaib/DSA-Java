class Student {

    int[] marks;

    Student(int m) {
        marks = new int[1];
        marks[0] = m;
    }

    // Shallow Copy
    Student(Student s) {
        this.marks = s.marks;
    }

    void display() {
        System.out.println("Marks : " + marks[0]);
    }
}

public class ShallowCopyDemo {

    public static void main(String[] args) {

        Student s1 = new Student(90);

        Student s2 = new Student(s1);

        s2.marks[0] = 50;

        s1.display();
        s2.display();
    }
}