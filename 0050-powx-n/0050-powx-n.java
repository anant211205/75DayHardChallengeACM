class Solution {
    public double myPow(double x, double n) {
        // if(x == 0) return 0 ;
        if(n == 0) return 1 ;
        
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        double ans = 1.0 ;
        while(n > 0){
            if(n % 2 == 0){
                n /= 2 ;
                x *= x ;
            }
            else{
                ans *= x ;
                n-- ;
            }
        }
        if(n < 0) ans *= (double)(ans) ;
        return ans; 
    }
}


