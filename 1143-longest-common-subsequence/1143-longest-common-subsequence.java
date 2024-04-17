class Solution {
    // int m , n ;
    // int[][] dp ;
    // public int solve(String s1 , String s2 , int i , int j){
    //     if(i>=m || j>=n) return 0 ;
    //     if(dp[i][j] != -1) return dp[i][j] ;
    //     if(s1.charAt(i)==s2.charAt(j)){
    //         return dp[i][j]  = 1 + solve(s1,s2, i+1 , j+1) ;
    //     }else return dp[i][j] =  Math.max(solve(s1,s2 , i ,j+1) ,solve(s1,s2 , i+1 , j)) ;
    // }
    public int longestCommonSubsequence(String s1, String s2) {

        // tabulation
        int m = s1.length() ;
        int n = s2.length() ;
        int[][] dp = new int[m+1][n+1] ;
        
        for(int row=0;row<=m;row++){
            dp[row][0] = 0 ;
        }
        for(int col=0;col<=n;col++){
            dp[0][col] = 0;
        }

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1] ;
                }else{
                    dp[i][j] = Math.max(dp[i][j-1] , dp[i-1][j]) ;
                }
            }
        }
        return dp[m][n]; 

        //memo
        // m = text1.length(); 
        // n = text2.length() ;
        // dp = new int[4001][4001] ;
        // for(int[]row : dp){
        //     Arrays.fill(row , -1) ;
        // }
        // return solve(text1,text2,0,0) ;
    }
}