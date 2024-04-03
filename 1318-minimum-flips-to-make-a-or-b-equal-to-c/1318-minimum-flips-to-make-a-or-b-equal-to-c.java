class Solution {
    public int minFlips(int a, int b, int c) {
        int ans = 0 ;
        for(int i=0;i<32;i++){
            int x = 0 , y = 0 , z = 0 ;
            if((a & (1<<i)) != 0) x = 1 ;
            if((b & (1<<i)) != 0) y = 1 ;
            if((c & (1<<i)) != 0) z = 1 ;

            if(z==0){
                if(x==1 && y==1){
                    ans+=2 ;
                }else if(x==1 || y==1){
                    ans++ ;
                }
                
            }else{
                if(x==0 && y==0){
                    ans++ ;
                }
            }
        }
        return ans ;
    }
}