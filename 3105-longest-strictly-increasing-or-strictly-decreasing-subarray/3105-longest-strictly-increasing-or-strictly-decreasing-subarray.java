class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length ;
        int increLen = 1, decLen = 1 , max = 1 ;
        for(int i=1;i<n;i++){
            if(nums[i]>nums[i-1]){
                increLen+=1;
                decLen=1 ;
            }else if(nums[i]<nums[i-1]){
                decLen+=1 ;
                increLen=1 ;
            }else{
                increLen = 1;
                decLen = 1;
            }
            max = Math.max(max , Math.max(increLen , decLen)) ;
        }
        return max ;
    }
}