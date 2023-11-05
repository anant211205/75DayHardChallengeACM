class Solution {
    public boolean binarySearch(int[] arr , int target){
        int n = arr.length ;
        int low = 0 ; int high = n - 1 ;
        while(low <= high){
            int mid = (low + high) / 2 ;
            if(arr[mid] == target) return true ;

            else if(arr[mid] < target){
                low = mid + 1 ;
            }else{
                high = mid - 1;
            }
        }
        return false ;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        // optimal approach 1
        int n = matrix.length ;
        int m = matrix[0].length ;
        for(int i = 0 ; i < n ; i++){
            if(matrix[i][0] <= target && matrix[i][m - 1] >= target){
                return binarySearch(matrix[i] , target) ;
            }
        }
    return false ;

        // brute force
        // int n = matrix.length ;
        // int m = matrix[0].length; 
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