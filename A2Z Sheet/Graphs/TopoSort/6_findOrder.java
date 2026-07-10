import java.util.*;

class Solution {
    public String findOrder(String [] dict, int N, int K) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<K; i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<N-1; i++){   // build graph from dictionary
            String s1 = dict[i];
            String s2 = dict[i+1];

            int len = Math.min(s1.length(), s2.length());
            for(int j=0; j<len; j++){

                if(s1.charAt(j) != s2.charAt(j)){    // first different character
                    int u = s1.charAt(j) - 'a';
                    int v = s2.charAt(j) - 'a';

                    // u comes before v (edge)
                    adj.get(u).add(v);      
                    break;
                }
            }
        }

        int indegree[] = new int[K];
        for(int i=0; i<K; i++){         // calculate indegree
            for(int neighbour : adj.get(i)){
                indegree[neighbour]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();  
        for(int i=0; i<K; i++){         // starting characters
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }

        StringBuilder ans = new StringBuilder();

        while(!queue.isEmpty()){            // Kahn BFS
            int node = queue.poll();
            ans.append((char)(node + 'a'));     // convert node to char

            for(int neighbour : adj.get(node)){
                indegree[neighbour]--;
                if(indegree[neighbour] == 0){
                    queue.offer(neighbour);
                }
            }
        }

        return ans.toString();
    }
}