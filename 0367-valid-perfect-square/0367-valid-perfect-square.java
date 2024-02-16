class Solution {
    public boolean isPerfectSquare(int num) {
        

        int start = 0 , end = num ;

        while(start <= end){

            long mid = start + (end - start) / 2 ;
            
            if(mid * mid == num) return true ;

            else if(mid * mid < num){
                start = (int)mid + 1 ;
            }
            else end = (int)mid - 1;
        } 

        return false ;
    }
}