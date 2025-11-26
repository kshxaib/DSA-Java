import java.util.*;

public class HashMap{
    static class HashMap<K, V>{     // generic
        private class Node{
            K key;
            V value;

            public Node(K key, V value){
                this.key = key;
                this.value = value;
            }
        }

        private int n; // total number of nodes
        private int N; // number of linkedlists in array
        private LinkedList<Node> buckets [];

        @SupressWarnings("unchecked")
        public HashMap(){
            this.N = 4;
            this.buckets = new LinkedList[4];
            for(int i=0; i<4; i++){
                this.buckets[i] = new LinkedList<>();
            }
        }

        private int hashFunction(K key){
            int hashCode = key.hashCode();
            return math.abs(hashCode) % N;
        }

        private int searchInLL(K key, int bi){
            LinkedList<Node> ll = buckets[bi];
            int di = 0;    

            for(int i=0; i<ll.size(); i++){
                Node node = ll.get(i);

                if(node.key == key){
                    return di;
                }
                di++;
            }

            return -1;
        }

        public void put(K key, V value){
            int bi = hashFunction(key);  // bucket index
            int di = searchInLL(key, bi);   // data index 

            if(di != -1){ // data index exits
                Node node = buckets[bi].get(di);
                node.value = value;
            } else {
                buckets[bi].add(new Node(key, value));
                n++;
            }

            double lambda = (double) n/N;
            if(lambda > 2.0){   // greater than threshold
                rehash();
            }
        }

        public boolean containsKey(K key){}

        public V remove(K key){}
        
        public V get(K key){}

        public ArrayList<K> keySet(){}
    }

    public static void main(String[] args) {
        
    }
}