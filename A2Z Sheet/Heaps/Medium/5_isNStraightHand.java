class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) return false;

        TreeMap<Integer, Integer> freq = new TreeMap<>();
        for(int i=0; i<hand.length; i++){
            int card = hand[i];
            freq.put(card, freq.getOrDefault(card, 0) + 1);
        }

        while(!freq.isEmpty()){
            int start = freq.firstKey();

            for(int i=0; i<groupSize; i++){
                int card = start +i;

                if(!freq.containsKey(card)) return false;

                freq.put(card, freq.get(card) -1);

                if(freq.get(card) == 0){
                    freq.remove(card);
                }
            }
        }

        return true;
    }
}