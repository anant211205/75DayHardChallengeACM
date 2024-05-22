class Solution {

    private int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}} ;

    public boolean isValid(int i , int j , int n , int m){
        return i>=0 && i<n && j>=0 && j<m; 
    }

    public boolean solve(char[][]board , int i , int j , int idx , String word){
        int n = board.length ;
        int m = board[0].length; 
        if(idx >= word.length()) return true ;

        if(!isValid(i , j , n , m) || board[i][j] != word.charAt(idx)) return false; 

        char temp = board[i][j] ;
        board[i][j] = '$' ;

        for(int []dir : directions){
            int newi = i + dir[0] ;
            int newj = j + dir[1] ;

            if(solve(board , newi , newj , idx+1 , word)){
                return true ;
            }
        }
        board[i][j] = temp ;
        return false ;

    }

    public boolean exist(char[][] board, String word) {
        int n = board.length ;
        int m = board[0].length ;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(solve(board , i  , j , 0 , word)){
                    return true  ;
                }
            }
        }
        return false ;
    }
}