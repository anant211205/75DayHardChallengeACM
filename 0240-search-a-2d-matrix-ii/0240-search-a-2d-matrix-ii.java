class Solution {
    // public static boolean binarySearch(int[] mat , int target){
    //     int n = mat.length ; int low = 0 ; int high = n - 1 ;
    //     int mid = 0 ;
    //     while(low <= high){
    //         mid = low + (high - low) / 2 ;

    //         if(mat[mid] == target) return true ;

    //         if(target >= mat[mid]){
    //             low = mid + 1;
    //         }
    //         else{
    //             high = mid - 1;
    //         }
    //     }
    //     return false ;
    // }

    public boolean searchMatrix(int[][] matrix, int target) {
        //Optimal
        
        int n = matrix.length , m = matrix[0].length ;
        int row = 0 ; int col = m - 1 ;

        while(row < n && col >= 0){
            if(matrix[row][col] == target) return true; 

            if(matrix[row][col] < target) row++ ;

            else col-- ;
        }
        return false ;

        //Better Soln
        // int n = matrix.length , m = matrix[0].length ;
        // for(int i = 0 ; i < n ; i++){
        //     if(matrix[i][0] <= target && target <= matrix[i][m - 1]){
        //         return binarySearch(matrix[i] , target) ;
        //     }
        // }
        // return false ;
        
        //Brute force
        // int n = matrix.length ; int m = matrix[0].length ;
        
        // for(int i = 0 ; i < n ; i++){
        //     for(int j = 0 ; j < m ; j++){
        //         if(matrix[i][j] == target){
        //             return true ;
        //         }
        //     }
        // }
        // return false ;
    }
}