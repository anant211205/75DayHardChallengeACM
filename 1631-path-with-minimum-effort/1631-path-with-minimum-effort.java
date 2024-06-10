class Pair{
    int x , y , z ;

    Pair(int x , int y , int z){
        this.x = x ;
        this.y = y ;
        this.z = z ;
    }
}


class Solution {

    public boolean isValid(int i , int j , int n , int m){
        return i >= 0 && i < n && j >= 0 && j < m ;
    }

    private int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}} ;

    public int minimumEffortPath(int[][] heights) {
        int n = heights.length ;
        int m = heights[0].length ;

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x , y) -> x.x - y.x) ;

        int[][] result = new int[n][m] ;

        for(int i=0;i<n;i++){
            Arrays.fill(result[i] , Integer.MAX_VALUE) ;
        }

        result[0][0] = 0 ;
        pq.add(new Pair(0 , 0 , 0)) ;


        while(!pq.isEmpty()){
            Pair p = pq.poll() ;
            int d = p.x ;
            int i = p.y ;
            int j = p.z ;

            

            for(int [] dir : directions){
                int newi = i + dir[0] ;
                int newj = j + dir[1] ;

                if(isValid(newi , newj , n , m)){
                    
                    int absDiff = Math.abs(heights[newi][newj] - heights[i][j]) ;
                    int maxDiff = Math.max(d, absDiff) ;
                    
                    if(result[newi][newj] > maxDiff){

                        result[newi][newj] = maxDiff ;

                        pq.add(new Pair(maxDiff , newi , newj)) ;

                    }
         
                }

            }

        }

        return result[n-1][m-1] ;
        

    }
}