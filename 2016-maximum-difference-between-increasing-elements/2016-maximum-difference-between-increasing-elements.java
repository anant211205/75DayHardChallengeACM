class Solution {
    public int maximumDifference(int[] nums) {
        int n = nums.length ;
        int maxDiff = Integer.MIN_VALUE , suffixMax = nums[n-1] ;

        for(int i=n-2;i>=0;i--){
            maxDiff = Math.max(maxDiff , suffixMax - nums[i]) ;
            suffixMax = Math.max(suffixMax , nums[i]) ;
        }
        return maxDiff > 0 ? maxDiff : -1 ;
    }
}