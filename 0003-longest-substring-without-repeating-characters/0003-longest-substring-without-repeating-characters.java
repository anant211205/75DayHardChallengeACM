class Solution {
    public int lengthOfLongestSubstring(String s) {

        int r = 0 , l = 0 , n = s.length() ;
        int ans = 0 ;
        boolean [] ls = new boolean[256] ;
        while(r<n){
            while(ls[s.charAt(r)] == true){
                ls[s.charAt(l)] = false ;
                l++ ;
            }
            ls[s.charAt(r)] = true ;
            
            ans = Math.max(ans , r - l + 1) ;
            r++ ;
        }
        return ans; 
    }
}