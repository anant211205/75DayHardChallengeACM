class Solution {
    public int candy(int[] ratings) {

        //approach 2 

        int n = ratings.length ;
        int candy = n ;
        int i = 1; 
        while(i < n){

            if(ratings[i] == ratings[i - 1]){
                i++;
                continue ;
            }

            int peak = 0 ;
            while(ratings[i] > ratings[i - 1]){
                peak++ ;
                candy += peak ;
                i++ ;
                if(i == n) return candy ;
            }

            int dip = 0 ;

            while(i < n && ratings[i - 1] > ratings[i]){
                dip++ ;
                candy += dip ;
                i++ ;
            }

            candy -= Math.min(dip , peak) ;

        }

        return candy ;

        //approach 1 
        // int n = ratings.length ;

        // int[] l2r = new int[n] ;
        // int[] r2l = new int[n] ;

        // Arrays.fill(l2r , 1) ;
        // Arrays.fill(r2l , 1) ;

        // for(int i=1;i<n;i++){
        //     if(ratings[i] > ratings[i-1]){
        //         l2r[i] = Math.max(l2r[i] , l2r[i-1] + 1) ;
        //     }
        // }

        // for(int i=n-2;i>=0;i--){
        //     if(ratings[i] > ratings[i+1]){
        //         r2l[i] = Math.max(r2l[i] , r2l[i+1] + 1) ;
        //     }
        // }

        // int result = 0 ;
        // for(int i=0;i<n;i++){
        //     result += Math.max(r2l[i] , l2r[i]) ;
        // }

        // return result ;
    }
}