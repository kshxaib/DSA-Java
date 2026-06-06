class Solution {
    public boolean lemonadeChange(int[] bills) {
        int dollar5 = 0; 
        int dollar10 = 0;

        for(int i=0; i<bills.length; i++){
            int bill = bills[i];

            if(bill == 5){
                dollar5++;
            } else if(bill == 10){
                dollar10++;
                if(dollar5 > 0){
                    dollar5--;
                } else {
                    return false;
                }

            } else {
                if(dollar5 > 0 && dollar10 > 0){
                    dollar5--;
                    dollar10--;
                } else if(dollar5 >= 3) {
                    dollar5 -= 3;
                } else {
                    return false;
                }
            }
        } 

        return true;
    }
}