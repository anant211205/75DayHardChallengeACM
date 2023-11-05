class Solution {
    public int LowerBound(int[] nums , int target){
        int n = nums.length ;
        int low = 0 ; int high = n - 1 ;
        int ans = n ;
        while(low <= high){
            int mid = (low + high) / 2 ;
            if(nums[mid] >= target){
                ans = mid ;
                high = mid - 1 ;
            }else{
                low = mid + 1 ;
            }
        }
        return ans ;
    }

    public int UpperBound(int[] nums , int target){
        int n = nums.length ;
        int low = 0 ; int high = n - 1 ;
        int ans = n ;
        while(low <= high){
            int mid = (low + high) / 2 ;
            if(nums[mid] > target){
                ans = mid ;
                high = mid - 1 ;
            }else{
                low = mid + 1 ;
            }
        }
        return ans ;
    }

    public int[] searchRange(int[] nums, int target) {
       int lb = LowerBound(nums , target) ;
       int up = UpperBound(nums , target) ;
       if(lb == nums.length || nums[lb] != target) return new int[]{-1 , -1} ;
           
        return new int[]{lb , up - 1} ; 
       
    }
}