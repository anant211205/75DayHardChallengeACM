class Solution {
    public int rec(List<List<Integer>> ls , int i , int j , int[][]dp){
        if(i==ls.size()-1){
            return ls.get(ls.size()-1).get(j) ;
        }
        if(dp[i][j] != -1) return dp[i][j] ;
        int downI = ls.get(i).get(j) + rec(ls , i+1 , j ,dp) ;
        int downI1 = ls.get(i).get(j) + rec(ls , i+1 , j+1 ,dp) ;

        return dp[i][j] = Math.min(downI , downI1) ;
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size(); 
        // int [][]dp = new int[triangle.size()][triangle.size()] ;
        // for(int []i : dp){
        //     Arrays.fill(i , -1) ;
        // }
        int[]dp = new int[n] ;
        for(int j=0;j<n;j++){
            dp[j] = triangle.get(n-1).get(j); 
        }
        for(int i=n-2;i>=0;i--){
            int[]curr = new int[n] ;
            for(int j=i;j>=0;j--){
                int downI = 0 , downI1 = 0 ;
                downI = triangle.get(i).get(j) + dp[j] ;
                downI1 = triangle.get(i).get(j) + dp[j+1] ;
                curr[j] = Math.min(downI ,downI1); 
            }
            dp = curr ;
        }
        return dp[0] ;
        // return rec(triangle ,0 ,0 , dp) ;
    }
}