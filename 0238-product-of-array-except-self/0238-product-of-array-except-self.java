class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int [] prefixArr = new int[n];
        int [] suffixArr = new int[n];
        int [] res = new int[n];
        int prePro = 1 , suffPro = 1 ;
        prefixArr[0] = nums[0]; 
        suffixArr[n-1] = nums[n-1]; 
        for(int i=1;i<n;i++){
            prefixArr[i] = prefixArr[i-1] * nums[i] ;
        }
        for(int i=n-2;i>=0;i--){
            suffixArr[i] = suffixArr[i+1] * nums[i] ;
        }

        for(int i=0;i<n;i++){
            prePro = i > 0 ? prefixArr[i-1] : 1 ;
            suffPro = i < n - 1 ? suffixArr[i+1] : 1 ;
            res[i] = prePro * suffPro ;
        }
        return res ; 
    }
}