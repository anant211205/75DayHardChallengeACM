import java.util.*; 
class Solution {
    public int maxProduct(int[] nums) {
        // optimal approach
        int n = nums.length ;
        int max = Integer.MIN_VALUE ;
        int prefix = 1 ;
        int suffix = 1 ;
        for(int i = 0 ; i < n  ; i++){
            if(suffix == 0) suffix = 1 ;
            if(prefix == 0) prefix = 1 ;
            prefix *= nums[i] ;
            suffix *= nums[n - i - 1] ;
            max = Math.max(max , Math.max(prefix , suffix)); 
        }

        return max ;

        // brute
        // int n = nums.length;
        // int result = Integer.MIN_VALUE;
        
        // for (int i = 0; i < n; i++) {
        //     int prod = 1;
        //     for (int j = i; j < n; j++) {
        //         prod *= nums[j];
        //         result = Math.max(result, prod);
        //     }
        // }
        
        // return result;
    }
}
