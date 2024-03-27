class Solution {
    public int longestOnes(int[] nums, int k) {
        int l = 0 , r = 0 , maxLen = 0 , zeroes = 0 ;
        int n = nums.length ;
        //tc:o(2n) due to inner while loop to futher optimise while loop can be changed to if cond'n
        while(r<n){
            if(nums[r]==0)zeroes++ ;
            while(zeroes > k){ 
                if(nums[l]==0)zeroes--;
                l++;
            }
            if(zeroes<=k)maxLen=Math.max(maxLen , r-l+1); 
            r++ ;
        }
        return maxLen ;
    }
}