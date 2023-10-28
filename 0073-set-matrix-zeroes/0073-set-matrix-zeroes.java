class Solution {
    // public void mark_row(int i , int matrix[][]){
    //     int col = matrix[0].length ;
    //     for(int j = 0 ; j < col ; j++){
    //         if(matrix[i][j] != 0){
    //             matrix[i][j] = -1 ;
    //         }
    //     }
    // }
    // public void mark_col(int j , int matrix[][]){
    //     int row = matrix.length ;
    //     for(int i = 0 ; i < row ; i++){
    //         if(matrix[i][j] != 0){
    //             matrix[i][j] = -1 ;
    //         }
    //     }
    // }
    public void setZeroes(int[][] matrix) {
        // int row = matrix.length ;
        // int col = matrix[0].length ;
        // for(int i = 0 ; i < row ; i++){
        //     for(int j = 0 ; j < col ; j++){
        //         if(matrix[i][j] == 0){
        //             mark_row(i , matrix) ;
        //             mark_col(j , matrix) ;
        //         }
        //     }
        // }
        // for(int i = 0 ; i < row ; i++){
        // for(int j = 0 ; j < col ; j++){
        //     if(matrix[i][j] == -1){
        //         matrix[i][j] = 0 ;
        //     }
        // }
        // }
        int n = matrix.length ;
        int m = matrix[0].length ;
        int row[] = new int[n] ; 
        int col[] = new int[m] ;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(matrix[i][j] == 0){
                    row[i] = 1 ;
                    col[j] = 1 ;
                }
            }
        }
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(row[i] == 1 || col[j] == 1){
                    matrix[i][j] = 0 ;
                }
            }
        }
    }
}