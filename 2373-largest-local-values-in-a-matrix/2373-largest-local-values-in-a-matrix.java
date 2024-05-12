class Solution {

    public int max(int[][] g, int x, int y) {
    int maxNum = Integer.MIN_VALUE;
    for (int i = x; i < x + 3; i++) {
        for (int j = y; j < y + 3; j++) {
            maxNum = Math.max(maxNum, g[i][j]);
        }
    }
    return maxNum;
    }

    public int[][] largestLocal(int[][] grid) {
        int n = grid.length ;

        int [][]ans = new int[n-2][n-2] ;
        int max = Integer.MIN_VALUE;    
        for(int i=0;i<n-2;i++){
            for(int j=0;j<n-2;j++){
                ans[i][j] = max(grid , i, j); 
            }
        }
        return ans ;
    }
}