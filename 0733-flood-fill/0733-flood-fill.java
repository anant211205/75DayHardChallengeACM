class Solution {
    
    public boolean isValid(int n , int m , int i , int j){
        return i >= 0 && i < n && j >= 0 && j < m ;
    }
    public void dfs(int[][] image, int sr, int sc , int initColor, int newColor , boolean[][]vis){
        int n = image.length ;
        int m = image[0].length; 

        if(!isValid(n , m , sr , sc)){
            return  ;
        }

        if(image[sr][sc] != initColor){
            return ;
        }

        if(vis[sr][sc]){
            return ;
        }

        image[sr][sc] = newColor ;
        vis[sr][sc] = true ;

        dfs(image , sr+1 , sc , initColor , newColor , vis) ;
        dfs(image , sr-1 , sc , initColor , newColor , vis) ;
        dfs(image , sr , sc+1 , initColor , newColor , vis) ;
        dfs(image , sr , sc-1 , initColor , newColor , vis) ;
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length ;
        int m = image[0].length; 
        boolean [][]vis = new boolean[n][m]; 
        int initColor = image[sr][sc] ;

        dfs(image , sr , sc , initColor , color , vis) ;

        return image ;
        
    }
}