class Solution {
    public int matrixScore(int[][] grid) {
        int n = grid.length ;
        int m = grid[0].length ;

        for(int i=0;i<n;i++){
            if(grid[i][0] == 0){
                for(int j=0;j<m;j++){
                    grid[i][j] = 1 - grid[i][j] ;
                }
            }
        }

        for(int i=0;i<m;i++){
            int countZero = 0 ;
            for(int j=0;j<n;j++){
                if(grid[j][i] == 0) countZero++ ;
            }

            if(countZero > n - countZero){
                for(int j=0;j<n;j++){
                    grid[j][i] = 1 - grid[j][i] ;
                }
            }
        }

        int ans = 0 ;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ans += grid[i][j] * Math.pow(2 , m - j - 1) ;
            }
        }

        return ans ;
    }
}