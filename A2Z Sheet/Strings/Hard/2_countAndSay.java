class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1"; // Base case

        String prev = countAndSay(n-1);  // Generate previous term

        StringBuilder ans = new StringBuilder();

        for(int i=0; i<prev.length(); i++){ // Apply (RLE) on previous term
            int count = 1;
            char ch = prev.charAt(i);

            while(i<prev.length() -1 && ch == prev.charAt(i+1)){    // Count consecutive same digits
                count++;
                i++;
            }

            ans.append(count);  // Append frequency followed by digit
            ans.append(ch);
        } 

        return ans.toString();
    }
}

