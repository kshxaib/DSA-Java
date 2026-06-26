import java.util.*;

class Solution {
    public void reverseStack(Stack<Integer> st) {
        // Pop all elements recursively.
        if (!st.isEmpty()) {
            int topVal = st.pop();
            reverseStack(st);   // Reverse the remaining stack.
            
            insertAtBottom(st, topVal);  // Place the popped element at the bottom.
        }
    }

    private void insertAtBottom(Stack<Integer> st, int val) {
        // Bottom reached.
        if (st.isEmpty()) {
            st.push(val);
            return;
        }
        
        int topVal = st.pop();  // Remove top element.
        insertAtBottom(st, val);    // Insert the element at the bottom.

        st.push(topVal);    // Restore removed element.
    }
}