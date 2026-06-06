class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);   // greed factor
        Arrays.sort(s);   // cookies size

        int gLen = g.length;
        int sLen = s.length; 

        int i=0;
        int j=0;

        while(i<sLen && j<gLen){
            int cookie = s[i];
            int greed = g[j];

            if(cookie >= greed){
                j++;
            }
            i++;
        }

        return j;
    }
}