import java.util.* ;
class Solution {
    public int MaxElement(int[] arr){
        int max = Integer.MIN_VALUE ;
        int n = arr.length ;
        for(int i = 0 ; i < n ; i++){
           max = Math.max(max , arr[i]) ;
        }
        return max ;
    }

    public int CalculateTotalHrs(int[] arr , int k){
        int n = arr.length ;
        int totalHrs = 0 ;
        for(int i = 0 ; i < n ; i++){
            totalHrs += Math.ceil((double)(arr[i]) /(double) k) ;
        }
        return totalHrs ;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length ;
        int low = 1 ; int high = MaxElement(piles);
        
        int ans = Integer.MAX_VALUE ;
        while(low <= high){
            int mid = (low + high) / 2 ;
            int totalHours = CalculateTotalHrs(piles , mid) ;
            if(totalHours <= h){
                ans = mid ;
                high = mid - 1;
            }else{
                low = mid + 1 ;
            }
        }
        return low ;
    }
}