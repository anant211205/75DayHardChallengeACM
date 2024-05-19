class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int ansP = 0 ;
        int ansG = 0 ;
        int ansM = 0 ;
        int total = 0;

        for(int i=0;i<garbage.length;i++){
            for(int j=0;j<garbage[i].length();j++){
                char ch = garbage[i].charAt(j) ;
                if(ch == 'M') ansM = i ;
                else if(ch == 'P') ansP = i ;
                else ansG = i ;
                total++ ;
            }
        }

        for(int i=1;i<travel.length;i++){
            travel[i] += travel[i-1] ;
        }
        total += ansP > 0 ? travel[ansP - 1] : 0 ;
        total += ansG > 0 ? travel[ansG - 1] : 0 ;
        total += ansM > 0 ? travel[ansM - 1] : 0 ;
        return total ;
    }
}