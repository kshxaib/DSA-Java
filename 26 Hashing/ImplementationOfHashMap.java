import java.util.*;

public class ImplementationOfHashMap {

    static class HashMap<K, V> {

        // Node: stores a key-value pair
        private class Node {
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n; // number of stored elements
        private int N; // number of buckets
        private LinkedList<Node>[] buckets; // array of linked lists

        @SuppressWarnings("unchecked")
        public HashMap() {
            this.N = 4;
            this.buckets = new LinkedList[4];

            // initialize buckets
            for (int i = 0; i < 4; i++) {
                this.buckets[i] = new LinkedList<>();
            }
        }

        // Hash function → returns bucket index
        // Time: O(1)
        private int hashFunction(K key) {
            int hashCode = key.hashCode();
            return Math.abs(hashCode) % N;
        }

        // Search a key inside a linked list at bucket index
        // Returns its index OR -1
        // Average: O(1)   Worst: O(n)
        private int searchInLL(K key, int bi) {
            LinkedList<Node> ll = buckets[bi];

            for (int i = 0; i < ll.size(); i++) {
                Node node = ll.get(i);
                if (node.key.equals(key)) {
                    return i;
                }
            }
            return -1;
        }

        // Rehashing: double bucket size and reinsert all nodes
        // Time: O(n)
        @SuppressWarnings("unchecked")
        private void rehash() {
            LinkedList<Node>[] oldBuckets = buckets;

            buckets = new LinkedList[N * 2];
            N = N * 2;

            // create new empty buckets
            for (int i = 0; i < buckets.length; i++) {
                buckets[i] = new LinkedList<>();
            }

            // reset n and reinsert everything
            n = 0;

            for (int i = 0; i < oldBuckets.length; i++) {
                LinkedList<Node> ll = oldBuckets[i];

                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.get(j);
                    put(node.key, node.value);
                }
            }
        }

        // Insert or update key-value pair
        // Average: O(1)   Worst: O(n)
        public void put(K key, V value) {
            int bi = hashFunction(key);  // bucket index
            int di = searchInLL(key, bi); // index inside linked list

            if (di != -1) {
                // key exists → update
                Node node = buckets[bi].get(di);
                node.value = value;
            } else {
                // new key → insert
                buckets[bi].add(new Node(key, value));
                n++;
            }

            // check load factor
            double lambda = (double) n / N;
            if (lambda > 2.0) {
                rehash(); // O(n)
            }
        }

        // Check if key exists
        // Average: O(1)   Worst: O(n)
        public boolean containsKey(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);
            return di != -1;
        }

        // Remove key and return value
        // Average: O(1)   Worst: O(n)
        public V remove(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if (di != -1) {
                Node node = buckets[bi].remove(di);
                n--;
                return node.value;
            }
            return null;
        }

        // Get value of key
        // Average: O(1)   Worst: O(n)
        public V get(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if (di != -1) {
                Node node = buckets[bi].get(di);
                return node.value;
            }
            return null;
        }

        // Return all keys
        // Time: O(n)
        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();

            for (int i = 0; i < buckets.length; i++) {
                LinkedList<Node> ll = buckets[i];

                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.get(j);
                    keys.add(node.key);
                }
            }
            return keys;
        }

        // Check if map is empty
        // Time: O(1)
        public boolean isEmpty() {
            return n == 0;
        }
    }

    public static void main(String[] args) {

        HashMap<String, Integer> hm = new HashMap<>();

        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("US", 50);
        hm.put("Nepal", 5);

        ArrayList<String> keys = hm.keySet();

        for (String key : keys) {
            System.out.println(key);
        }
    }
}
