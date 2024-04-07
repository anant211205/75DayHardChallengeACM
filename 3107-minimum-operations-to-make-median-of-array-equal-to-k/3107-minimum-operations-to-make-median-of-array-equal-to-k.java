class Solution {
    public long minOperationsToMakeMedianK(int[] nums, int k) {
        long ans = 0 ;
        int n = nums.length ;
        Arrays.sort(nums) ;
        int mid = n/2 , i = mid ;
        if(nums[mid]<k){
            while(i<n && nums[i]<k){
                ans+=Math.abs(k-nums[i]) ;
                i++ ;
            }
        }else{
            while(i>=0 && nums[i]>k){
                ans+=Math.abs(k-nums[i]) ;
                i-- ;
            }
        }
        return ans ;
    }
}