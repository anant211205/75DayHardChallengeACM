class Solution {
    public int minimumDeletions(String s) {
        int n = s.length() ;
        int countA = 0 , countB = 0 ;
        for(int i=n-1;i>=0;i--){
            if(s.charAt(i) == 'a'){
                countA++ ;
            }
        }

        int ans = Integer.MAX_VALUE ;
        for(int i=0;i<n;i++){
            if(s.charAt(i) == 'a') countA-- ;
            ans = Math.min(ans , countA + countB) ;
            if(s.charAt(i) == 'b'){
                countB++ ;
            }
        }

        return ans ;
    }
}