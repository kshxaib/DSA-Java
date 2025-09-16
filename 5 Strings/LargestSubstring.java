public class LargestSubstring {
    public static void main(String args[]){
        String fruits[] = {"apple", "mango", "banana"};

        String largest = fruits[0];
        for(int i=0; i<fruits.length; i++){
            int comparison = largest.compareTo(fruits[i]);

            if(comparison < 0){
                largest = fruits[i];
            }
        }

        System.out.print(largest);
    }
}
