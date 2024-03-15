class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points , Comparator.comparingDouble(o -> o[1]));
        int minArr = 1 ;
        int lastBallonEnd = points[0][1]; 
        for(int i=0;i<points.length;i++){
            if(lastBallonEnd < points[i][0]){
                minArr++ ;
                lastBallonEnd = points[i][1] ;
            }
        }
        return minArr ;
    }
}