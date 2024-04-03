class Solution {
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length ;
        Arrays.sort(pairs , Comparator.comparingDouble(o->o[1])) ;
        int maxChain = 1 ; // 1 chain is already added 
        int lastSelect = pairs[0][1] ;
        for(int i=1;i<n;i++){
            if(pairs[i][0] > lastSelect){
                maxChain++ ;
                lastSelect = pairs[i][1] ;
            }
        }
        return maxChain ;
    }
}