class Solution {

    public boolean blooming(int[] arr , int mid , int m , int k){

        int n = arr.length ; 
        int count = 0 ;
        int flowers = 0 ;
        for(int i=0;i<n;i++){

            if(arr[i] <= mid){
                count++ ;
            }else{

                flowers += (count/k) ;
                
                count = 0 ;

            }
        }
        flowers += (count/k) ;

        if(flowers >= m) return true ;
        else return false ;

    }

    public int minDays(int[] bloomDay, int m, int k) {
        
        int n = bloomDay.length ;

        int max = Integer.MIN_VALUE ;
        int min = Integer.MAX_VALUE ;

        for(int i=0;i<n;i++){
            max = Math.max(max , bloomDay[i]) ;
            min = Math.min(min , bloomDay[i]) ;
        }

        int low = min , high = max , ans = -1 ;

        while(low <= high){

            int mid = low + (high - low) / 2 ;

            if(blooming(bloomDay , mid , m  , k)){
            
                ans = mid ;
                high = mid - 1 ;
            
            }else{
                low = mid + 1;
            }

        }

        return m*k > n ? -1 : ans ;
    }
}