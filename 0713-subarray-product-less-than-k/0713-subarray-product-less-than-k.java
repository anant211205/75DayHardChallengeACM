class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int r = 0 , l = 0 , n = nums.length ;
        int prod = 1  , ans = 0 ;

        for(; r < n ; r++){

            prod *= nums[r] ;
            for(; prod >= k && l <= r ; l++){          //invalid window 
                prod /= nums[l] ;
            }
            ans += (r - l + 1) ;
        }
        return ans ;
    }
}