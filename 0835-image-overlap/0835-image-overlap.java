class Solution {

    public int count(int[][]a , int [][]b , int rowOff , int colOff){
        int n = a.length ;
        int cnt = 0 ;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){

                int newI = rowOff + i ;
                int newJ = colOff + j ;

                if(newI < 0 || newI >= n || newJ < 0 || newJ >= n){
                    continue ;
                }

                if(b[newI][newJ] == 1 && a[i][j] == 1){
                    cnt++ ;
                }
            }
        }
        return cnt ;
    }

    public int largestOverlap(int[][] a, int[][] b) {
        int n = a.length ;

        int max = 0 ;

        // i is row-offsets
        // j is col-offsets
        for(int i=-n+1;i<n;i++){
            for(int j=-n+1;j<n;j++){

                int overLaps = count(a, b, i , j) ;
                max = Math.max(max , overLaps) ;
            }
        }

        return max ;
    }
}