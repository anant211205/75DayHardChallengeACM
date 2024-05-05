class Solution {
    public int minimumOperationsToMakeKPeriodic(String word, int k) {
        int n = word.length() ;
        HashMap<String , Integer> map = new HashMap<>() ;
        int maxSub = 0 ;
        for(int i=0;i<n;i+=k){
            String sub = word.substring(i , Math.min(i+k , n)) ;
            map.put(sub , map.getOrDefault(sub , 0) + 1) ;
        }

        for(int i : map.values()){
            maxSub = Math.max(maxSub , i) ;
        }

        return n/k - maxSub ;
    }
}