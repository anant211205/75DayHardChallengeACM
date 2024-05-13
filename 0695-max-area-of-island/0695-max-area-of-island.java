class Solution {
    public boolean isValid(int i , int j , int n , int m){
        return i>=0 && i<n && j>=0 && j<m; 
    }

    public int dfs(int[][]g , int i , int j , boolean[][] vis){
        int n = g.length ;
        int m = g[0].length ;
        int area = 1 ;
        vis[i][j] = true ;

        if(isValid(i+1 , j , n , m) && g[i+1][j] == 1 && !vis[i+1][j]){
            area += dfs(g ,i+1 , j ,vis) ;
        }
        if(isValid(i-1 , j , n , m) && g[i-1][j] == 1 && !vis[i-1][j] ){
            area += dfs(g ,i-1 , j ,vis) ;
        }
        if(isValid(i , j+1 , n , m) && g[i][j+1] == 1 && !vis[i][j+1] ){
            area += dfs(g ,i , j+1 ,vis) ;
        }
        if(isValid(i , j-1 , n , m) && g[i][j-1] == 1 && !vis[i][j-1] ){
            area += dfs(g ,i , j-1 ,vis) ;
        }
            

        return area ;

    }
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length ;
        int m = grid[0].length ;
        boolean[][]vis = new boolean[n][m] ;
        int maxArea = 0 ;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1 && !vis[i][j]){
                    int area = dfs(grid, i, j , vis) ;
                    maxArea = Math.max(area , maxArea) ;
                }
            }
        }
        return maxArea;  
    }
}