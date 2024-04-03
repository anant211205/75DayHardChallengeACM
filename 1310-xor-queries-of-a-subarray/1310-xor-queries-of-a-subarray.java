class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        //optimal
        int n = arr.length; 
        int m = queries.length ;
        int []ans = new int[m] ;
        int[]prefix = new int[n] ;
        prefix[0] = arr[0] ;
        for(int i=1;i<n;i++){
            prefix[i] = prefix[i-1]^arr[i] ;
        }

        for(int i=0;i<m;i++){
            int left = queries[i][0] , right = queries[i][1] ;
            if(left == 0) ans[i] = prefix[right] ;
            if(left > 0) ans[i] = prefix[right]^prefix[left-1]  ;
        }
        return ans ;
        

        // int n = queries.length ;
        // int []ans = new int[n]; 
        // for(int i=0;i<n;i++){
        //     int xor = 0 ;
        //     int left = queries[i][0] , right = queries[i][1] ;
        //     for(int j=left;j<=right;j++){
        //         xor = xor ^ arr[j] ;
        //     }
        //     ans[i] = xor ;
        // }
        // return ans ;
    }
}