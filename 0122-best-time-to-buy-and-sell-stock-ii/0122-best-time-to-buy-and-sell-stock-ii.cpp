class Solution {
public:

    int rec(vector<int>& vec,int idx,int buy,vector<vector<int>>& dp){
        if(idx==vec.size()) return 0;
        int p=0;
        if(dp[idx][buy]!=-1) return dp[idx][buy];
        if(buy){   
            p=max(-vec[idx]+rec(vec,idx+1,0,dp) , 0+rec(vec,idx+1,1,dp));
        }else{
            p=max(vec[idx]+rec(vec,idx+1,1,dp) , 0+rec(vec,idx+1,0,dp));
        }
        return dp[idx][buy]=p;
    }

    int maxProfit(vector<int>& vec) {
        int n=vec.size();
        vector<vector<int>> dp(n+1 , vector<int>(2,0));
        dp[n][0]=dp[n][1]=0;
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<=1;j++){
                int p=0;
                if(j){   
                    p=max(-vec[i]+dp[i+1][0] , 0+dp[i+1][1]);
                }else{
                    p=max(vec[i]+dp[i+1][1] , 0+dp[i+1][0]);
                }
                dp[i][j]=p;
            }
        }
        return dp[0][1];
        // return rec(prices,0,1,dp);
    }
};