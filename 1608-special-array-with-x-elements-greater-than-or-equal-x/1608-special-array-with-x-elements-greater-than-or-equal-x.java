class Solution {
    public int specialArray(int[] nums) {
        // int n = nums.length;
        // Arrays.sort(nums);
        
        // for (int x = 0; x <= n; x++) {
        //     int count = 0;
        //     for (int i = 0; i < n; i++) {
        //         if (nums[i] >= x) {
        //             count++;
        //         }
        //     }
        //     if (count == x) {
        //         return x;
        //     }
        // }
        
        // return -1;
        
        int n = nums.length ;
        int []freq = new int[n+1] ;
        for(int i=0;i<n;i++){
            int num = nums[i] ;
            freq[Math.min(num , n)]++ ;
        }

        int count = 0 ;
        for(int x = n ;x >= 0 ; x--){
            count += freq[x] ;
            if(count == x){
                return x ;
            }
        }
        return -1 ;
    }
}