class Solution {

    int [][] directions = {{0,1} , {0,-1} ,{1,0} ,{-1,0}} ;

    public boolean isValid(int i , int j , int n , int m){
        return i >=0 && i<n && j >= 0 && j < m  ;
    }

    public class Pair{
        int i , j ;
        Pair(int i , int j){
            this.i = i; 
            this.j = j ;
        }
    }

    public int maxDistance(int[][] grid) {
        int n = grid.length ;
        int m = grid[0].length ;
        int ans = 0 ;

        int [][] mat = new int[n][m] ;
        Queue<Pair> q = new LinkedList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1){
                    q.add(new Pair(i,j)) ;
                }
            }
        }
        if(q.size() == m*n) return -1; 

        while(!q.isEmpty()){
            int s = q.size() ;
            ans++ ;
            for(int i=0;i<s;i++){
                Pair p = q.poll() ;
                int ir = p.i ;
                int jc = p.j ;

                for(int[]dir : directions){

                    int newi = ir + dir[0] ;
                    int newj = jc + dir[1] ; 

                    if(isValid(newi , newj , n , m) && grid[newi][newj] == 0){
                        grid[newi][newj] =  1;
                        q.add(new Pair(newi , newj)) ;
                    }
                }
            }
        }


        // for(int i=0;i<n;i++){
        //     for(int j=0;j<m;j++){
        //         ans = Math.max(ans , mat[i][j]) ;
        //     }
        // }
        return ans - 1 ;
    }
}