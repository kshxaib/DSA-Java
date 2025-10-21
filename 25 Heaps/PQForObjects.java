import java.util.*;

public class PQForObjects {
    static class Student implements Comparable<Student>{
        String name;
        int rank;

        public Student(String name, int rank){
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student s2){
            return this.rank - s2.rank;
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Student> students = new PriorityQueue<>(Comparator.reverseOrder());

        students.add(new Student("Shoaib", 86));
        students.add(new Student("Faisal", 99));
        students.add(new Student("Anas", 29));
        students.add(new Student("Huzaifa", 20));

        while (!students.isEmpty()) {
            System.out.println(students.remove().name);
        }
    }
}
