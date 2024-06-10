class Pair{
    int x ; int y ;

    Pair(int x , int y){
        this.x = x ;
        this.y = y ;
    }
}

class Solution {
    private int[][] directions = {{1,0},{0,1},{-1,0},{0,-1},{1,1},{-1,-1},{1,-1},{-1,1}} ;

    public boolean isValid(int i , int j , int n){
        return i >= 0 && i < n && j >= 0 && j < n ;
    }

    public int shortestPathBinaryMatrix(int[][] grid) {

        int n = grid.length ;
        
        if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0) {
            return -1;
        }

        Queue<Pair> q = new LinkedList<>() ;

        q.add(new Pair(0 , 0)) ;
        

        grid[0][0] = 1 ;
        int level = 0 ;

        
        while(!q.isEmpty()){
            
            int size = q.size() ;

            while(size-- > 0){

                Pair p = q.poll() ;
                int i = p.x ;
                int j = p.y ;

                if(i == n-1 && j == n-1){
                    return level + 1 ;
                }

                for(int []dir : directions){

                    int newi = i + dir[0] ;
                    int newj = j + dir[1] ;

                    if(isValid(newi , newj , n) && grid[newi][newj] == 0){

                        q.add(new Pair(newi , newj)) ;
                        grid[newi][newj] = 1; 

                    }

                }

            }
            level++ ;
        }
        return -1 ;
    }
}