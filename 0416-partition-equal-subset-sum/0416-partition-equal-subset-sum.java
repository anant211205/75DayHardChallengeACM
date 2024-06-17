class Solution {

    private Boolean [][] dp ;

    public boolean subsetSum(int[] arr , int sum , int n){

        for(int i=0;i<n+1;i++){
            for(int j=0;j<sum+1;j++){
                if(i==0){
                    dp[i][j] = false ;
                }if(j==0){
                    dp[i][j] = true ;
                }
            }
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                if(arr[i-1] <= j){
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j] ;
                }else{
                    dp[i][j] = dp[i-1][j] ;
                }
            }
        }

        return dp[n][sum] ;

    }

    public boolean canPartition(int[] nums) {
        int n = nums.length ;
        int sum = 0 ;
        for(int i=0;i<n;i++) sum += nums[i] ;
        dp = new Boolean[n+1][sum+1] ;

        if(sum%2 != 0) return false; 
        
        else return subsetSum(nums , sum/2 , n) ;

    }
}