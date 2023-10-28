class Solution {
    
    public int[][] rotate(int[][] matrix) {
        int n = matrix.length ;
        for(int i = 0 ; i < n ; i++){                    //transpose of a matrix
            for(int j = i + 1 ; j < n ; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp ; 
            }
        }

        for (int i = 0; i < n ; i++) {
            for (int j = 0 ; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    
        // int n = matrix.length ;
        // int rotatedArr[][] = new int[n][n]; 
        // for(int i = 0 ; i < n ; i++){
        //     for(int j = 0 ; j < n ; j++){
        //         rotatedArr[j][n - i - 1] = matrix[i][j] ;
        //     }
        // }
        // return rotatedArr;
        return matrix ;
    }
}