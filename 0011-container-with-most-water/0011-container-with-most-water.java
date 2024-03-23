class Solution {
    public int maxArea(int[] height) {
        int n=height.length ;
        int start = 0 , end = n - 1 ;   
        int maxAmt = 0; 

        for(int i=0;i<n;i++){
            int area = 0 ;
            if(height[start] < height[end]){
                area = height[start] * (end - start) ;
                start++ ;
            }else{
                area = height[end] * (end - start) ;
                end-- ;
            }
            maxAmt = Math.max(maxAmt, area) ;
        }
        return maxAmt ;
    }
}