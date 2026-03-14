class Solution {

    public String reverseWords(String s) {
        int n = s.length();
        StringBuilder ans = new StringBuilder();

        s = reverseString(s);

        for(int i = 0; i < n; i++) {
            StringBuilder word = new StringBuilder();

            while(i < n && s.charAt(i) != ' ') {
                word.append(s.charAt(i));
                i++;
            }

            String reversedWord = reverseString(word.toString());

            if(reversedWord.length() > 0) {
                if(ans.length() > 0) ans.append(" ");
                ans.append(reversedWord);
            }
        }

        return ans.toString();
    }

    public String reverseString(String str) {
        char[] arr = str.toCharArray();

        int left = 0;
        int right = arr.length - 1;

        while(left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }

        return new String(arr);
    }
}