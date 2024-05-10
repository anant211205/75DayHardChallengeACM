class Solution {

    public boolean isValid(int i , int j , int n , int m){
        return i >= 0 && i < n && j >= 0 && j < m ;
    }

    public void dfs(int[][]g , int i , int j , boolean[][]vis){
        int n = g.length ;
        int m = g[0].length ;

        vis[i][j] = true ;
        
        if(isValid(i+1 , j , n , m ) && !vis[i+1][j] && g[i][j]==1){
            dfs(g , i+1 , j , vis) ;
        }
        if(isValid(i-1 , j , n , m ) && !vis[i-1][j] && g[i][j]==1){
            dfs(g , i-1 , j , vis) ;
        }
        if(isValid(i , j+1 , n , m ) && !vis[i][j+1] && g[i][j]==1){
            dfs(g , i , j+1 , vis) ;
        }
        if(isValid(i , j-1 , n , m ) && !vis[i][j-1] && g[i][j]==1){
            dfs(g , i , j-1 , vis) ;
        }
        

    }

    public int numEnclaves(int[][] grid) {
        
        int n = grid.length ;
        int m = grid[0].length ;

        boolean [][]vis = new boolean[n][m] ;
        for(int i=0;i<n;i++){
            if(grid[i][0] == 1 && !vis[i][0]){
                dfs(grid , i , 0 , vis) ;
            }
            if(grid[i][m-1] == 1 && !vis[i][m-1]){
                dfs(grid , i , m-1 , vis) ;
            }
        }

        for(int i=0;i<m;i++){
            if(grid[0][i] == 1 && !vis[0][i]){
                dfs(grid , 0 , i , vis) ;
            }
            if(grid[n-1][i] == 1 && !vis[n-1][i]){
                dfs(grid , n-1 , i , vis) ;
            }
        }

        int count = 0 ;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && !vis[i][j]){
                    count++ ;
                }
            }
        }

        return count ;

    }
}