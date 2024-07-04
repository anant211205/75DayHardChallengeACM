class Solution {
    private int[][] dp ;
    public int recMem(int[][] pairs , int i , int p , int n){
        if(i >= n) return 0 ;   
        
        if(p != -1 && dp[i][p] != -1){
            return dp[i][p] ;
        }

        int take = 0 ;
        if(p == -1 || pairs[i][0] > pairs[p][1]){
            take = 1 + recMem(pairs , i + 1 , i , n) ;
        }

        int skip = recMem(pairs , i + 1 , p , n) ;

        if(p != -1){
            dp[i][p] = Math.max(take , skip) ; 
        }

        return Math.max(take , skip)  ;

    }

    public int findLongestChain(int[][] pairs) {
        int n = pairs.length ;

        // bottom up

        int[] dp = new int[n] ;
        Arrays.fill(dp , 1) ;

        Arrays.sort(pairs , Comparator.comparingDouble(o->o[1])) ;
        int max = 1 ;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(pairs[i][0] > pairs[j][1]){
                    dp[i] = Math.max(dp[i] , dp[j] + 1) ;
                    max = Math.max(max , dp[i]) ;
                }
            }
        }
        return max ;

        //rec memo

        // dp = new int[1001][1001] ;
        // for(int []ar : dp){
        //     Arrays.fill(ar , -1) ;
        // }
        // return recMem(pairs , 0 , -1 , n) ;

        


        //sorting + greedy

        // int maxChain = 1 ; // 1 chain is already added 
        // int lastSelect = pairs[0][1] ;
        // for(int i=1;i<n;i++){
        //     if(pairs[i][0] > lastSelect){
        //         maxChain++ ;
        //         lastSelect = pairs[i][1] ;
        //     }
        // }
        // return maxChain ;
    }
}