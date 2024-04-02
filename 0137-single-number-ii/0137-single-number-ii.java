class Solution {
    public int singleNumber(int[] nums) {
        int ones = 0 , twos = 0 ;
        int n = nums.length ;
        for(int i=0;i<n;i++){
            ones = (nums[i]^ones) & (~twos) ;
            twos = (nums[i]^twos) & (~ones) ;
        }
        return ones ;
    }
}