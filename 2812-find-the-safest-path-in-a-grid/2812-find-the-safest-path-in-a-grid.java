class Pair{
    int x , y ;
    Pair(int x , int y){
        this.x = x; 
        this.y = y;
    }
}

class Solution {
    int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}}; 

    public boolean check(int[][] a , int sf){
        int n = a.length ;
        Queue<Pair> q = new LinkedList<>() ;
        boolean [][] vis = new boolean[n][n] ;
        q.add(new Pair(0 ,0)) ;
        vis[0][0] = true ;

        if(a[0][0] < sf){
            return false; 
        }

        while(!q.isEmpty()){
            Pair p = q.poll() ;
            int i = p.x ;
            int j = p.y ;

            if(i == n-1 && j == n-1){
                return true ;
            }

            for(int []dir : directions){
                int newi = i + dir[0] ;
                int newj = j + dir[1] ;

                if(newi >=0 && newi < n && newj >= 0 && newj < n && !vis[newi][newj]){
                    if(a[newi][newj] < sf){
                        continue ;
                    }
                    q.add(new Pair(newi , newj));
                    vis[newi][newj] = true ;
                }
            }
        }
        return false; 
    }


    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size() ;
        int[][] arr = new int[n][n] ;
        boolean[][] vis = new boolean[n][n] ;
        Queue<Pair> q = new LinkedList<>() ;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid.get(i).get(j) == 1){
                    q.add(new Pair(i,j));
                    vis[i][j] = true ;
                }
            }
        }
        int level = 0 ;
        while(!q.isEmpty()){
            int size = q.size() ;
            while(size-- > 0){
                Pair p = q.poll() ;
                int first = p.x ;
                int second = p.y ;

                arr[first][second] = level ;
                for(int[]dir : directions){
                    int newi = first + dir[0] ;
                    int newj = second + dir[1] ;
                    

                    if(newi<0 || newi>=n || newj<0 || newj>=n || vis[newi][newj]){
                        continue ;
                    }

                    q.add(new Pair(newi, newj)) ;
                    vis[newi][newj] = true ;
                }
            }
                level++ ;
        }

        int l = 0 ;
        int r = 400 ;
        int result = 0 ;

        while(l <= r){
            int mid = l + (r - l) / 2 ;

            if(check(arr , mid)){
                result = mid ;
                l = mid + 1 ;
            }else{
                r = mid - 1;
            }
        }
        return result; 
    }
}