class Student {

    int[] marks;

    Student(int m) {
        marks = new int[1];
        marks[0] = m;
    }

    // Deep Copy
    Student(Student s) {

        this.marks = new int[1];

        this.marks[0] = s.marks[0];
    }

    void display() {

        System.out.println("Marks : " + marks[0]);
    }
}

public class DeepCopyDemo {

    public static void main(String[] args) {

        Student s1 = new Student(90);

        Student s2 = new Student(s1);

        s2.marks[0] = 50;

        s1.display();

        s2.display();
    }
}