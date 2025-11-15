import java.util.PriorityQueue;

public class PQforObjects {

    // Student class implements Comparable to define priority ordering
    static class Student implements Comparable<Student>{
        String name;
        int rank;

        public Student(String name, int rank){
            this.name = name;
            this.rank = rank;
        }

        // compareTo defines how two Student objects should be compared
        // Here: smaller rank = higher priority (Min Priority Queue)
        @Override
        public int compareTo(Student s2){
            return this.rank - s2.rank; 
            // If result < 0 --> this student has higher priority
        }
    }    

    public static void main(String[] args){
        
        // PriorityQueue of Student objects
        // It will use compareTo() to decide order
        PriorityQueue<Student> pq = new PriorityQueue<>();

        // Adding Student objects to PriorityQueue
        pq.add(new Student("A", 4));
        pq.add(new Student("B", 5));
        pq.add(new Student("C", 2));
        pq.add(new Student("D", 12));

        // Removing elements one by one
        // PriorityQueue always removes the element with smallest rank first
        while(!pq.isEmpty()){
            // peek() returns the highest priority element
            System.out.println(pq.peek().name + " -> " + pq.peek().rank);

            // remove() deletes the highest priority element
            pq.remove();
        }
    }
}
