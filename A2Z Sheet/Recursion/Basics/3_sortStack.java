import java.util.*;

class Solution {
    public void sortStack(Stack<Integer> st) {
        // Pop all elements recursively.
        if (!st.isEmpty()) {
            int temp = st.pop();

            sortStack(st);  // Sort remaining stack.

            insert(st, temp);   // Insert element at correct position.
        }
    }

    private void insert(Stack<Integer> st, int temp) {
        if (st.isEmpty() || st.peek() <= temp) {    // Correct position found.
            st.push(temp);
            return;
        }

        int largerVal = st.pop();   // Remove larger element.
        insert(st, temp);   // Find correct position.

        st.push(largerVal);   // Restore removed element.
    }
}