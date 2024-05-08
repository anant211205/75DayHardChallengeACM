class Solution {

    public boolean isValid(int i , int j , int n , int m){
        return i >= 0 && i < n && j >= 0 && j < m ;
    }

    public void dfs(char[][]b , int i , int j , boolean[][] vis){
        int n = b.length;
        int m = b[0].length ;

        vis[i][j] = true ;

        if(isValid(i , j+1 , n , m) && !vis[i][j+1] && b[i][j] == 'O'){
            dfs(b , i , j+1 , vis) ;
        }

        if(isValid(i , j-1 , n , m) && !vis[i][j-1] && b[i][j] == 'O'){
            dfs(b , i , j-1 , vis) ;
        }
        
        if(isValid(i+1 , j , n , m) && !vis[i+1][j] && b[i][j] == 'O'){
            dfs(b , i+1 , j , vis) ;
        }

        if(isValid(i-1 , j , n , m) && !vis[i-1][j] && b[i][j] == 'O'){
            dfs(b , i-1 , j , vis) ;
        }

    }

    public void solve(char[][] board) {
        int n = board.length ;
        int m = board[0].length ;
        boolean[][] vis = new boolean[n][m]; 

        // column boundary
        for(int i=0;i<n;i++){
            if(board[i][0] == 'O' && !vis[i][0]){
                dfs(board , i , 0 , vis) ;
            }
            if(board[i][m-1] == 'O' && !vis[i][m-1]){
                dfs(board , i , m-1 , vis) ;
            }
        }

        for(int i=0;i<m;i++){
            if(board[0][i] == 'O' && !vis[0][i]){
                dfs(board , 0 , i , vis) ;
            }
            if(board[n-1][i] == 'O' && !vis[n-1][i]){
                dfs(board , n-1 , i , vis) ;
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='O' && !vis[i][j]){
                    board[i][j] = 'X' ;
                }
            }
        }

    }
}