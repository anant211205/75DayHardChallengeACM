class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length ;
        List<int[]> result = new ArrayList<>() ;
        int index = 0 ; 
        
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0])) ;
        
        //optimal

        for(int i = 0 ; i < n ; i++){
            if(result.isEmpty() || intervals[i][0] > result.get(result.size() - 1)[1]){
                result.add(intervals[i]); 
            }else{
                result.get(result.size() - 1)[1] = Math.max(result.get(result.size() - 1)[1] , intervals[i][1]) ;
            }
        }

        return result.toArray(new int[result.size()][]) ;
        //brute force
        // for(int i = 0 ; i < n ; i++){

        //     int start = intervals[i][0] ;
        //     int end = intervals[i][1] ;

        //     //skipping the intervals which are alreasy merged
        //     if(!result.isEmpty() && end <= result.get(result.size() - 1)[1]) continue ;

        //     for(int j = i + 1 ; j < n ; j++){
                
        //         if(intervals[j][0] <= end){

        //             end = Math.max(end , intervals[j][1]) ;

        //         }else{
        //             break ;
        //         }
        //     }

        //     result.add(new int[]{start , end});
        // }
        // return result.toArray(new int[result.size()][]) ;
    }
}