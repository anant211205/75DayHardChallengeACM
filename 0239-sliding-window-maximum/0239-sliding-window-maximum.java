class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> dq = new ArrayDeque<>() ;
        int n = nums.length;
        int x=0 ;
        int [] result = new int[n-k+1] ;

        for(int i=0;i<n;i++){
            while(!dq.isEmpty() && dq.peek() <= i-k){
                dq.pollFirst() ;
            }

            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
                dq.pollLast() ;
            }

            dq.add(i) ;

            if(i >= k-1){
                result[x++] = nums[dq.peekFirst()] ;
            }
        }

        return result; 
        
        // int n = nums.length ;
        // int r=0 , l=0 ;

        // while(r<n){
        //     while(!dq.isEmpty() && dq.peekLast() < nums[r]){
        //         dq.pollLast(); 
        //     }

        //     dq.add(nums[r]) ;

        //     if(r-l+1 < k){
        //         r++ ;
        //     }else if(r-l+1 == k){
        //         result[x++] = dq.peek() ;

        //         if(nums[l] == dq.peek()){
        //             dq.pollFirst() ;
        //         }
        //         l++ ;
        //         r++ ;
        //     }


        // }

        // return result ;
    }
}