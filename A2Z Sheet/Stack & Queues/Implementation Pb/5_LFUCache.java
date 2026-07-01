import java.util.*;

class LFUCache {

    class DLLNode {
        int key;
        int val;
        int freq;
        DLLNode prev;
        DLLNode next;

        DLLNode(int key, int val) {
            this.key = key;
            this.val = val;
            this.freq = 1; // Every new node starts with frequency 1.
        }
    }

    class DoubleLinkedList {

        DLLNode head;
        DLLNode tail;
        int size;

        DoubleLinkedList() {
            // Dummy head and tail nodes.
            head = new DLLNode(-1, -1);
            tail = new DLLNode(-1, -1);

            head.next = tail;
            tail.prev = head;

            size = 0;
        }

        // Insert node after head (Most Recently Used).
        void addNode(DLLNode node) {

            node.next = head.next;
            node.prev = head;

            head.next.prev = node;
            head.next = node;

            size++;
        }

        // Remove any node from the list.
        void removeNode(DLLNode node) {

            node.prev.next = node.next;
            node.next.prev = node.prev;

            size--;
        }

        // Remove Least Recently Used node (before tail).
        DLLNode removeLastNode() {

            if (size == 0)
                return null;

            DLLNode node = tail.prev;
            removeNode(node);

            return node;
        }
    }

    int capacity;
    int currSize;
    int minFreq;

    // key -> node.
    HashMap<Integer, DLLNode> cache;

    // frequency -> doubly linked list.
    HashMap<Integer, DoubleLinkedList> freqMap;

    public LFUCache(int capacity) {

        this.capacity = capacity;
        this.currSize = 0;
        this.minFreq = 0;

        cache = new HashMap<>();
        freqMap = new HashMap<>();
    }

    public int get(int key) {

        // Key not present.
        if (!cache.containsKey(key))
            return -1;

        DLLNode node = cache.get(key);

        // Increase node frequency.
        updateNode(node);

        return node.val;
    }

    public void put(int key, int value) {

        // No capacity.
        if (capacity == 0)
            return;

        // Key already exists.
        if (cache.containsKey(key)) {

            DLLNode node = cache.get(key);

            // Update value.
            node.val = value;

            // Increase frequency.
            updateNode(node);

            return;
        }

        // Cache is full.
        if (currSize == capacity) {

            // Remove LRU node from minimum frequency list.
            DoubleLinkedList minList = freqMap.get(minFreq);

            DLLNode removeNode = minList.removeLastNode();

            cache.remove(removeNode.key);

            currSize--;
        }

        // Create new node.
        DLLNode newNode = new DLLNode(key, value);

        // Frequency = 1 list.
        DoubleLinkedList list = freqMap.getOrDefault(1, new DoubleLinkedList());

        list.addNode(newNode);

        freqMap.put(1, list);

        cache.put(key, newNode);

        // Minimum frequency becomes 1.
        minFreq = 1;

        currSize++;
    }

    // Move node to next higher frequency list.
    private void updateNode(DLLNode node) {

        int oldFreq = node.freq;

        // Current frequency list.
        DoubleLinkedList oldList = freqMap.get(oldFreq);

        // Remove node from old frequency list.
        oldList.removeNode(node);

        // Increase minimum frequency if needed.
        if (oldFreq == minFreq && oldList.size == 0) {
            minFreq++;
        }

        // Increase node frequency.
        node.freq++;

        // New frequency list.
        DoubleLinkedList newList = freqMap.getOrDefault(node.freq, new DoubleLinkedList());

        // Add node to front (Most Recently Used).
        newList.addNode(node);

        freqMap.put(node.freq, newList);
    }
}