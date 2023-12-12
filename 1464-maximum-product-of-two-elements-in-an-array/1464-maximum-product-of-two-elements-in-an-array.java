import java.util.* ;
class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length ;
        int max = 0 ;
        Arrays.sort(nums); 
        for(int i = 0 ; i < n ; i++){
            max = (nums[n - 1] - 1) * (nums[n - 2] - 1) ;
        }
        return max ;
    }
}