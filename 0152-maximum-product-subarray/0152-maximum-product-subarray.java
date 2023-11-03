import java.util.*; 
class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int result = Integer.MIN_VALUE;
        
        for (int i = 0; i < n; i++) {
            int prod = 1;
            for (int j = i; j < n; j++) {
                prod *= nums[j];
                result = Math.max(result, prod);
            }
        }
        
        return result;
    }
}
