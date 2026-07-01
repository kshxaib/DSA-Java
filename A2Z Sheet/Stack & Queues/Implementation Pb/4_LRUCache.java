/*
        LRU CACHE (LEAST RECENTLY USED)

Definition:
Design cache with capacity.

Supports:

1. get(key)
   → return value if exists
   → else -1

2. put(key, value)
   → insert/update key

When capacity full:
remove LEAST RECENTLY USED item.


What is "Recently Used"?
Whenever key is accessed by:

• get(key)
• put(existing key)

That key becomes MOST RECENT.


Example

LRUCache(2)

put(1,1)
put(2,2)

get(1) = 1

Cache order:
1 (recent), 2 (old)

put(3,3)

Capacity full

Remove key 2


Core Idea
Need two things:
1. O(1) key lookup
2. O(1) move nodes by usage order

So use:
• HashMap<Key, Node>
• Doubly LinkedList


Why Doubly Linked List?
Need O(1):
• delete any node
• add to front

Singly list fails efficiently.


Data Structure Layout
head <-> recent nodes <-> old nodes <-> tail

head.next = Most Recent  
tail.prev = Least Recent



Time Complexity
get()  = O(1)
put()  = O(1)


Space Complexity: O(capacity)
*/

import java.util.*;

class LRUCache {

    class Node {
        int key;
        int val;
        Node next;
        Node prev;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    // Dummy head and tail nodes.
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);

    int cap;

    // key -> node mapping.
    HashMap<Integer, Node> map = new HashMap<>();

    public LRUCache(int capacity) {
        cap = capacity;

        // Initialize empty doubly linked list.
        head.next = tail;
        tail.prev = head;
    }

    // Insert node after head (Most Recently Used).
    public void addNode(Node newNode) {

        Node temp = head.next;

        newNode.next = temp;
        newNode.prev = head;

        head.next = newNode;
        temp.prev = newNode;
    }

    // Remove node from linked list.
    public void deleteNode(Node node) {

        Node prevNode = node.prev;
        Node nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    public int get(int key) {

        // Key exists.
        if (map.containsKey(key)) {

            Node resNode = map.get(key);
            int value = resNode.val;

            // Move accessed node to front (MRU).
            map.remove(key);
            deleteNode(resNode);
            addNode(resNode);
            map.put(key, head.next);

            return value;
        }

        // Key not found.
        return -1;
    }

    public void put(int key, int value) {

        // Remove old node if key already exists.
        if (map.containsKey(key)) {

            Node existingNode = map.get(key);

            map.remove(key);
            deleteNode(existingNode);
        }

        // Cache full -> Remove Least Recently Used node.
        if (map.size() == cap) {

            map.remove(tail.prev.key);
            deleteNode(tail.prev);
        }

        // Insert new node at front.
        addNode(new Node(key, value));
        map.put(key, head.next);
    }
}