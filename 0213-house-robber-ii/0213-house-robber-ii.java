class Solution {

    private int[] dp ;

    public int hr1(int[] nums ,int i , int n){
        if(i > n){
            return 0 ;
        }

        if(dp[i] != -1){
            return dp[i] ;
        }

        int steal = nums[i] + hr1(nums , i + 2 , n) ;
        int skip = hr1(nums , i + 1 , n) ;

        return dp[i] = Math.max(steal , skip) ;

    }

    public int rob(int[] nums) {

        int n = nums.length ;
        dp = new int[n+1] ;

        Arrays.fill(dp , 0) ;

        if(n==1){
            return nums[0] ;
        }

        dp[0] = 0 ;

        //case 1

        for(int i=1;i<=n-1;i++){
            int skip = dp[i-1] ;
            int steal = nums[i-1] + (i-2 >= 0 ? dp[i-2] : 0) ;
            dp[i] = Math.max(skip , steal) ;
        }

        int result1 = dp[n-1];
        
        //case 2

        dp = new int[n + 1];

        dp[0] = 0 ;
        dp[1] = 0 ; //skip 1st house 

        for(int i=2;i<=n;i++){
            int skip = dp[i-1] ;
            int steal = nums[i-1] + (i-2 >= 0 ? dp[i-2] : 0) ;
            dp[i] = Math.max(skip , steal) ;
        }

        int result2 = dp[n] ;

        return Math.max(result1 , result2) ;


        // int n = nums.length ;
        // dp = new int[n + 1] ;


        // if(n == 1){
        //     return nums[0] ;
        // }

        // if(n == 2){
        //     return Math.max(nums[0] , nums[1]) ;
        // }
        // Arrays.fill(dp , -1) ;
        // int incl_0th_Idx = hr1(nums , 0 , n - 2) ;

        // Arrays.fill(dp , -1) ;
        // int incl_1st_Idx = hr1(nums , 1 , n - 1) ;

        // return Math.max(incl_0th_Idx , incl_1st_Idx) ;
        
    }
}