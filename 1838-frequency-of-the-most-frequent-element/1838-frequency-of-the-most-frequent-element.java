class Solution {

    // public int bs(int target_idx , int [] nums , int k , int[] ps){
    //     int low = 0 ;
    //     int high = target_idx ;
    //     int result = target_idx ;
    //     while(low <= high){

    //         int mid = low + (high - low) / 2 ;
    //         int count = target_idx - mid + 1 ;
    //         int sum = count * nums[target_idx] ;
    //         int OriginalSum = ps[target_idx] - ps[mid] + nums[mid];

    //         int ops = sum - OriginalSum ;

    //         if(ops > k){
    //             low = mid + 1; 
    //         }else{
    //             result = mid ;
    //             high = mid -1 ;
    //         }

    //     }

    //     return target_idx - result + 1 ; 
    // }

    public int maxFrequency(int[] nums, int k) {

        //sliding window approach

        Arrays.sort(nums) ;

        int n = nums.length ;
        int result = 0 ;
        int l = 0; 

        long currSum = 0 ;

        for(int r=0;r<n;r++){

            long target = nums[r] ;
            currSum += nums[r] ;

            if((r-l+1)*target - currSum > k){
                currSum -= nums[l] ;
                l++ ;
            }
            result = Math.max(result , r-l+1) ;
        }

        return result ;

        //tc-> o(nlogn)
        // int n = nums.length ;
        // Arrays.sort(nums) ;
        // int result = 0 ;
        // int []ps = new int[n] ;
        // ps[0] = nums[0] ;

        // for(int i=1;i<n;i++){
        //     ps[i] = ps[i-1] + nums[i] ;
        // }
        // int freq = 0 ;
        // for(int target_idx = 0 ; target_idx<n ; target_idx++){
        //     freq = bs(target_idx , nums , k , ps); 
        //     result = Math.max(result , freq) ;
        // }

        // return result ;
    }
}