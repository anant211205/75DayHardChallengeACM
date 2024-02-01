class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer , Integer> mp = new HashMap<>() ;
        int ans = 0 ; 
        for(List<Integer> bigWall : wall){
            int emptySpace = 0 ;

            for(int i = 0 ; i < bigWall.size() - 1 ; i++){

                emptySpace += bigWall.get(i) ;

                mp.put(emptySpace , mp.getOrDefault(emptySpace , 0) + 1) ;

                ans = Math.max(ans , mp.get(emptySpace)) ;
            }
        }
        return wall.size() - ans ; 
    }
}