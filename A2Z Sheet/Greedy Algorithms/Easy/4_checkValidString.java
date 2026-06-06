class Solution {
    public boolean checkValidString(String s) {
        return check(s, 0, 0);
    }

    public boolean check(String s, int index, int count){
        if(count < 0){
            return false;
        }
        if(index >= s.length()){
            if(count == 0) return true;
            else return false;
        }

        if(s.charAt(index) == '('){
            return check(s, index+1, count+1);
        }
        else if(s.charAt(index) == ')'){
            return check(s, index+1, count-1);
        }
        
        return check(s, index+1, count+1) || check(s, index+1, count-1) ||
        check(s, index+1, count);
    }


    public boolean checkValidString(String s) {
        int minOpen = 0;
        int maxOpen = 0;

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                minOpen++;
                maxOpen++;
            } else if(ch == ')'){
                minOpen--;
                maxOpen--;
            } else {
                minOpen--;
                maxOpen++;
            }

            if(minOpen < 0) minOpen =0;
            if(maxOpen < 0) return false;
        }

        return minOpen == 0;
    }
}