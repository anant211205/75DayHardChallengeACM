import java.util.* ;
class Solution {
    // public int binarySearch(int[] nums , int target){
    //     int n = nums.length ;
    //     int low = 0; int high = n - 1;
    //     while(low <= high){
    //         int mid = (low + high) / 2 ;
    //         if(target == nums[mid]) return mid ;
            
    //         else if(target >= nums[mid]){
    //             low = mid + 1 ;
    //         }
    //         else{
    //             high = mid - 1 ;
    //         }
    //     }
    //     return -1 ;
    // }

    public int findMin(int[] nums) {

        //O(logN)(MOST OPTIMAL)
        int n = nums.length ;
        int min = Integer.MAX_VALUE ;
        int low = 0 ; int high = n - 1;
        while(low <= high){
            int mid = (low + high) / 2 ;
            if(nums[low] <= nums[mid]){            //checking if left part is sorted
                min = Math.min(min , nums[low]) ;  //updating min value
                low = mid + 1 ;                    //eliminating left half
            }else{
                min = Math.min(min , nums[mid]) ;  //updating min value on right half
                high = mid - 1 ;                   //eliminating right half
            }
        }
        return min ;

        //TC = O(n) + O(logN)
        // int n = nums.length ;
        // int min = Integer.MAX_VALUE ;
        // for(int i = 0 ; i < n ; i++){
        //     if(min > nums[i]){
        //         min = nums[i] ;
        //     }
        //     binarySearch(nums , min) ;
        // }
        // return min ;
    }
}