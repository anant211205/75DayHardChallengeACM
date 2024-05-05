class Solution {
    public class Pair{
        int i , j ;

        public Pair(int i , int j){
            this.i = i ;
            this.j = j ;
        }

    }

    public boolean isValid(int i , int j , int n , int m){
        return i>=0 && i<n && j>=0 && j<m ;
    }

    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length ;
        int m = mat[0].length ;
        Queue<Pair> q = new LinkedList<>() ;
        int [][]ans = new int[n][m] ;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j] == 0){
                    ans[i][j] = 0 ;
                    q.add(new Pair(i , j)) ;
                }else{
                    ans[i][j] = -1; 
                }
            }
        }

        while(!q.isEmpty()){
            int s = q.size() ;
            for(int i=0;i<s;i++){
                Pair p = q.poll() ;
                int ic = p.i ;
                int jc = p.j ;

                for(int[] dir : directions){
                    int newIC = ic + dir[0] ;
                    int newJC = jc + dir[1] ;

                    if(isValid(newIC , newJC , n , m) && ans[newIC][newJC] == -1){
                        ans[newIC][newJC] = ans[ic][jc] + 1 ;
                        q.add(new Pair(newIC , newJC)) ;
                    }
                }

            }
        }
        return ans ;
    }
}