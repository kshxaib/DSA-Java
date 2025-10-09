import java.util.*;

// Problem: Implement Stack using Java Collection Framework
/*
📌 Problem Statement:
We need to implement and demonstrate basic stack operations 
using Java's built-in **Stack** class from the Collection Framework.

👉 The `java.util.Stack` class provides all standard stack methods:
   - push(x): Insert element at top
   - pop(): Remove and return top element
   - peek(): Return top element without removing
   - isEmpty(): Check if stack is empty

✅ It internally uses a **Vector** for storage, so it is synchronized (thread-safe).
*/

public class StackUsingFramework {
    public static void main(String[] args) {
        // ✅ Creating a stack of integers using Java's built-in Stack class
        Stack<Integer> stack = new Stack<>();

        // 🔹 Push elements onto the stack
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // 🔹 Pop and display elements until the stack becomes empty
        while (!stack.isEmpty()) {
            System.out.println(stack.peek()); // view top element
            stack.pop();                      // remove top element
        }
    }
}

/*
📌 Dry Run:
Push sequence: [1, 2, 3]
Stack (top → bottom): 3, 2, 1

Pop sequence:
→ Peek = 3 → Pop 3
→ Peek = 2 → Pop 2
→ Peek = 1 → Pop 1

Output:
3
2
1

---

📊 Time Complexity:
push()  → O(1)
pop()   → O(1)
peek()  → O(1)
isEmpty() → O(1)

📊 Space Complexity:
O(n) — for storing n elements in the stack.

✅ Advantages:
- Easy to use (ready-made class)
- Thread-safe (synchronized)
- Follows LIFO behavior

⚠️ Note:
If synchronization is not required, use **ArrayDeque** instead of Stack 
for better performance (faster and more modern).
*/
