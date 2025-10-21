/*
-------------------------------------------
Program: Priority Queue for Custom Objects
-------------------------------------------

Goal:
- Demonstrate how to use a **Priority Queue** with custom objects (e.g., Student class).
- Understand how to define **natural ordering** using the Comparable interface.
- Learn how to reverse the order using a Comparator.

Concepts:
1. **Priority Queue with Objects:**
   - Java’s PriorityQueue can store user-defined objects.
   - The order of elements depends on either:
     • Their natural order (using `Comparable<T>`)
     • Or a custom order (using `Comparator<T>`)

2. **Comparable Interface:**
   - Used to define **natural ordering** for objects.
   - The `compareTo()` method decides the order:
        this.rank - s2.rank
     → Smaller rank = Higher priority.

3. **Default Behavior:**
   - By default, PriorityQueue is a **min-heap**.
   - The smallest element (lowest `rank`) is removed first.

4. **Custom Behavior (Max-Heap):**
   - To reverse the order (make it max-heap), use:
        new PriorityQueue<>(Comparator.reverseOrder());
     → Now, the object with **largest rank** gets removed first.

5. **Common Operations:**
   • add(E e)     → Insert element. (O(log n))
   • remove()     → Remove and return the highest priority element. (O(log n))
   • peek()       → View (not remove) top element. (O(1))
   • isEmpty()    → Check if queue is empty. (O(1))

-------------------------------------------
*/

import java.util.*;

public class PQForObjects {

    // Step 1: Define a custom class (Student)
    static class Student implements Comparable<Student> {
        String name;  // Name of the student
        int rank;     // Rank value (lower = better rank)

        // Constructor to initialize student data
        public Student(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }

        // Step 2: Define natural ordering based on rank
        // Smaller rank → Higher priority
        @Override
        public int compareTo(Student s2) {
            return this.rank - s2.rank;   // ascending order by rank
        }
    }

    public static void main(String[] args) {

        // Step 3: Create a PriorityQueue (Max-Heap by reverse order)
        // Since compareTo() gives ascending order (min-heap),
        // reverseOrder() converts it into descending (max-heap).
        PriorityQueue<Student> students = new PriorityQueue<>(Comparator.reverseOrder());

        // Step 4: Add students to the priority queue
        students.add(new Student("Shoaib", 86));
        students.add(new Student("Faisal", 99));
        students.add(new Student("Anas", 29));
        students.add(new Student("Huzaifa", 20));

        /*
        Internal Heap Structure (based on rank):
        Since we used reverseOrder(), higher rank = higher priority.
        Internally (conceptually): [Faisal(99), Shoaib(86), Anas(29), Huzaifa(20)]
        */

        // Step 5: Remove and print students in priority order
        System.out.println("Students removed in priority order (highest rank first):");
        while (!students.isEmpty()) {
            System.out.println(students.remove().name);
        }

        /*
        Expected Output Order (descending by rank):
        Faisal
        Shoaib
        Anas
        Huzaifa
        */
    }
}

/*
-------------------------------------------
DRY RUN (STEP-BY-STEP)
-------------------------------------------

Student List (name, rank):
1. Shoaib (86)
2. Faisal (99)
3. Anas (29)
4. Huzaifa (20)

compareTo() defines:
   smaller rank → smaller (natural order)
reverseOrder() inverts it → larger rank first

Heap after insertions (conceptual):
Top of heap = highest rank

remove() sequence:
1 → Faisal (99)
2 → Shoaib (86)
3 → Anas (29)
4 → Huzaifa (20)

-------------------------------------------
OUTPUT:
-------------------------------------------
Students removed in priority order (highest rank first):
Faisal
Shoaib
Anas
Huzaifa

-------------------------------------------
TIME COMPLEXITY ANALYSIS
-------------------------------------------
Let n = number of students

1. add(E e) → O(log n)
2. remove() → O(log n)
3. peek() → O(1)
4. isEmpty() → O(1)

If all students are inserted and removed:
Total Time → O(n log n)

-------------------------------------------
SPACE COMPLEXITY ANALYSIS
-------------------------------------------
1. Heap storage for n elements → O(n)
2. No extra structures used → O(1)

Total Space Complexity → **O(n)**
-------------------------------------------
*/
