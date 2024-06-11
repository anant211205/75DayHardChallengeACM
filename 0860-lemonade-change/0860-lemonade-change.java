class Solution {
    public boolean lemonadeChange(int[] bills) {
        int n = bills.length ;
        int f = 0 , t = 0 ;
        for(int i=0;i<n;i++){
            if(bills[i] == 5){
                f++ ;
            }else if(bills[i] == 10){
                if(f >= 1){
                    f-- ;
                    t++ ;
                }else{
                    return false ;
                }
            }else{
                if(f >= 1 && t >= 1){
                    f-- ;
                    t-- ;
                }else if(f >= 3){
                    f -= 3 ;
                }else{
                    return false ;
                }
            }
        }
        return true ;
    }
}