class Solution {

    public static void reverse(int[] arr , int left , int right){
        while(left <= right){
            int temp = arr[left] ;
            arr[left] = arr[right] ;
            arr[right] = temp ;
            right-- ;
            left++ ;
        }
    }

    public void rotate(int[] nums, int k) {

        int n = nums.length ;

        if (k > n) k = k % n ;

        reverse(nums , 0 , n - 1) ;

        reverse(nums , 0 , k - 1); 

        reverse(nums , k , n - 1) ;

        


    //     int n = nums.length ;
    //     if (n == 0)  return;
    //     if (k > n) return;
    //     k = k % n;
        
    //     int[] temp = new int[n];
    //     //putting first k no. in new array..
    //     for(int i = n - k ; i < n ; i++){
    //         temp[i - n + k] = nums[i];
    //     }
    //     //shifting other to backward..
    //     for (int i = n - k - 1; i >= 0; i--) {
    //     nums[i + k] = nums[i];
    // }
    //     //putting new array back to prev array...
    //     for (int i = 0; i < k; i++) {
    //     nums[i] = temp[i];
    // }
  }
}