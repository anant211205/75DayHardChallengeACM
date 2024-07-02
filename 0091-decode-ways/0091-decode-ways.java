class Solution {

    private int[] dp ; 
    public int solve(int i , String s , int n){
        if(i == n) return dp[i] = 1 ;

        if(s.charAt(i) == '0') return dp[i] = 0 ;

        if(dp[i] != -1){
            return dp[i] ;
        }

        int result = solve(i + 1 , s , n) ;

        if(i + 1 < n){
            if(s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i + 1) <= '6')
                result += solve(i + 2 , s , n) ;
        }

        return dp[i] = result ;
    }

    public int numDecodings(String s) {
        int n = s.length() ;
        dp = new int[n + 1] ;
        Arrays.fill(dp , -1) ;

        dp[n] = 1;

        for(int i=n-1;i>=0;i--){
            if(s.charAt(i) == '0'){
                dp[i] = 0 ;
            }else{
                dp[i] = dp[i+1] ;
                if(i+1 < n){
                    if(s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i+1) <= '6'){
                        dp[i] += dp[i+2] ;
                    }
                }
            }
        }

        return dp[0] ;


        // return solve(0 , s , n) ;
    }
}