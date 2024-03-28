class Solution {
    //pre requisite binary subarray with sum k
    public int helper(int[] nums , int goal){
        if(goal<0)return 0 ;
        int n = nums.length ;
        int ans = 0 , sum = 0 ;
        int l = 0 , r = 0 ;
        while(r<n){
            sum+=nums[r] ;
            while(sum>goal && l<=r){
                sum-=nums[l];
                l++;
            }
            ans+=r-l+1 ;
            r++;
        }
        return ans ;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length ;
        for(int i=0;i<n;i++){
            if(nums[i]%2==0)nums[i]=0;
            else nums[i]=1 ;
        }

        if(k<0) return 0 ;
        return helper(nums , k) - helper(nums , k-1) ;
    }
}