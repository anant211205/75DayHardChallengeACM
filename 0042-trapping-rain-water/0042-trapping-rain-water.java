class Solution {
    public int trap(int[] height) {
        int n = height.length ;
        int rMax = 0 , lMax = 0 , l = 0 , r = n - 1 , ans = 0 ;
        while(l<=r){
            if(height[l]<=height[r]){
                if(height[l]<lMax) ans += lMax-height[l] ;
                lMax = Math.max(lMax,height[l]) ;
                l++ ;
            }else{
                if(height[r]<rMax) ans += rMax-height[r] ;
                rMax = Math.max(rMax,height[r]) ;
                r--;
            }
        }
        return ans ;
    }
}