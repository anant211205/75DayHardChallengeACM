class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0 , r = 0 , ch = Integer.MIN_VALUE , n = s.length() ;
        int[]freq = new int[26] ;
        int maxLen = 0 ;
        while(r<n){
            freq[s.charAt(r)-'A']++ ;
            ch=Math.max(ch,freq[s.charAt(r)-'A']) ;
            if(r-l+1-ch>k){
                freq[s.charAt(l)-'A']--;
                l++;
            }
            maxLen = Math.max(maxLen , r-l+1);
            r++;
        }
        return maxLen ;
    }
}